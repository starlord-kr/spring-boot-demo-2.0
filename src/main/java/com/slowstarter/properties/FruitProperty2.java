package com.slowstarter.properties;

import com.slowstarter.Fruit;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
@Component("fruitProperty2")
@ConfigurationProperties(prefix = "fruit")
public class FruitProperty2 {

    private List<Fruit> list;
}
