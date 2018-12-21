package com.slowstarter.controller;

import com.slowstarter.entity.Fruit;
import com.slowstarter.properties.FruitProperty2;
import com.slowstarter.service.FruitService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
@RestController // ResponseBody가 포함되어 기본 json 으로 출력됨
public class FruitController {

    private FruitService fruitService;
    private FruitProperty2 fruitProperty2;

//    @Autowired // 특정 Spring 버전 이후로 하나의 DI에 대해서는 어노테이션 붙이지 않아도 됌.

    public FruitController(FruitService fruitService,
                           FruitProperty2 fruitProperty2) {

        this.fruitService = fruitService;
        this.fruitProperty2 = fruitProperty2;
    }

    @GetMapping("/v1/fruit/{name}")
    public Fruit getFruitInfo(@PathVariable("name") String name) {

        List<Fruit> fruitData = fruitProperty2.getList();
        System.out.println("fruitData=" + fruitData);

        Fruit fruit = new Fruit();
        fruit.setName("apple");
        fruit.setColor("red");

        return fruit;
    }

    @PostMapping("/v1/fruit/{name}")
    public Boolean setFruitInfo(@PathVariable("name") String name,
                                @ModelAttribute Fruit fruit) {

        fruitService.setFruitInfo(name);

        return Boolean.TRUE;
    }
}
