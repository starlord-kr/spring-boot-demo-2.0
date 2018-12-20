package com.slowstarter.controller;

import com.slowstarter.Fruit;
import com.slowstarter.properties.FruitProperty2;
import com.slowstarter.service.FruitService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(FruitController.class)
public class FruitControllerTests {

    @Autowired MockMvc mockMvc;
    @MockBean FruitService fruitService;
    @MockBean FruitProperty2 fruitProperty2; // Controller 에서 주입되는 것은 MockBean 으로

    private String name = "apple";
    private String color = "red";

    @Test
    public void getFruitInfo() throws Exception {

        mockMvc.perform(
                    get("/v1/fruit/{name}", name)
                )
                .andExpect(status().isOk())
                .andReturn();

    }

    @Test
    public void setFruitInfo() throws Exception {

        given(fruitService.setFruitInfo(name))
                .willReturn(Boolean.TRUE);

        Fruit dummy = new Fruit();
        dummy.setName(name);
        dummy.setColor(color);

        mockMvc.perform(
                    post("/v1/fruit/{name}", name)
                    .requestAttr("fruit", dummy)
                )
                .andExpect(status().isOk())
                .andReturn();
    }
}
