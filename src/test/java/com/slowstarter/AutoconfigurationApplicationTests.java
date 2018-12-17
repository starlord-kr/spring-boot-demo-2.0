package com.slowstarter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class AutoconfigurationApplicationTests {
    @Value("${property.test.name}")
    private String propertyTestName;

    @Value("${propertyCamelCase}")
    private String propertyCamelCase;

    @Value("${propertyList}")
    private String[] propertyArrayOfString;

    @Value("#{'${propertyList}'.split(',')}")
    private List<String> propertyList;


    @Test
    public void testValue() {
        assertThat(propertyTestName, is("property first second"));
        assertThat(propertyCamelCase, is("camelCase"));
        assertThat(propertyArrayOfString[0], is("camel"));
        assertThat(propertyList.get(1), is("case"));
        assertThat(propertyArrayOfString[2], is("list"));
    }
}
