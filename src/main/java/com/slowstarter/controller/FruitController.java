package com.slowstarter.controller;

import com.slowstarter.Fruit;
import com.slowstarter.properties.FruitProperty2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FruitController {

    private FruitProperty2 fruitProperty2;

    @Autowired
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
}
