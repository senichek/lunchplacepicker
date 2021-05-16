package com.olexiy.lunchplacepicker.controllers;

import org.junit.Before;
import org.junit.Rule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public abstract class AbstractRestControllerTest {

    public static final String APP_CONTEXT = "/lunchplacepicker";

    @Rule
    public JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation("target/generated-snippets");

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void setUp() {

          /* Right after the registration the Login method is called, this is why we need SecurityContextHolderAwareRequestWrapper.
           This filter is internal to Spring Security and is setup and run by the springSecurityFilterChain. */
        DelegatingFilterProxy filterProxy = new DelegatingFilterProxy(
                "springSecurityFilterChain", this.context);

        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
                .addFilter(filterProxy, "/*")
                .apply(documentationConfiguration(this.restDocumentation))
                .apply(springSecurity())
                .build();
    }

    public JUnitRestDocumentation getRestDocumentation() {
        return restDocumentation;
    }

    public WebApplicationContext getContext() {
        return context;
    }

    public MockMvc getMockMvc() {
        return mockMvc;
    }
}