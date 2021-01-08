package com.olexiy.lunchplacepicker.service;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@SpringBootTest
//@Sql(scripts = {"classpath:database/InitDB.sql", "classpath:database/PopulateDB.sql"}, config = @SqlConfig(encoding = "UTF-8"))
public abstract class AbstractServiceTest {
}