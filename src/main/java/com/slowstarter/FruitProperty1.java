package com.slowstarter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Data
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
@Component("fruitProperty1")
@ConfigurationProperties(prefix = "fruit")
public class FruitProperty1 {

    private List<Map> list;
}
