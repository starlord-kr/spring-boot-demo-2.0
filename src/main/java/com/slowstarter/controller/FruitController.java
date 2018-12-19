package com.slowstarter.controller;

import com.slowstarter.Fruit;
import com.slowstarter.properties.FruitProperty2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@Controller
@RestController // ResponseBody가 포함되어 기본 json 으로 출력됨
public class FruitController {

    private FruitProperty2 fruitProperty2;


//    @Autowired // 특정 Spring 버전 이후로 하나의 DI에 대해서는 어노테이션 붙이지 않아도 됌.

    public FruitController(FruitProperty2 fruitProperty2) {
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

    @PutMapping("/v1/fruit/{name}")
    public Boolean setFruitInfo(@PathVariable("name") String name) {

        return Boolean.TRUE;
    }
}
