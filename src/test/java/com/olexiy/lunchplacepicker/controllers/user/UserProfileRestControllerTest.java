package com.olexiy.lunchplacepicker.controllers.user;

import com.olexiy.lunchplacepicker.UserTestData;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.olexiy.lunchplacepicker.controllers.AbstractControllerTest;
import com.olexiy.lunchplacepicker.web.json.JacksonObjectMapper;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class UserProfileRestControllerTest extends AbstractControllerTest {

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
                "springSecurityFilterChain", context);

        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
                .addFilter(filterProxy, "/*")
                .apply(documentationConfiguration(this.restDocumentation))
                .build();
    }

    @Test
    public void ifLoggedIn() throws Exception {
        this.mockMvc.perform(get("/rest/ifloggedin")).andExpect(status().isOk())
                .andDo(document("{methodName}",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint())));
    }

    @Test
    public void save() throws Exception {
        ObjectMapper mapper = JacksonObjectMapper.getMapper();
        String newUser = mapper.writeValueAsString(UserTestData.getNew());
        this.mockMvc.perform(post("/rest/register").contentType(MediaType.APPLICATION_JSON).content(newUser))
                .andExpect(status().isCreated())
                .andDo(document("{methodName}",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint())));
    }
}