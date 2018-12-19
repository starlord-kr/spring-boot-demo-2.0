package com.slowstarter;

import com.slowstarter.properties.FruitProperty1;
import com.slowstarter.properties.FruitProperty2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles({"test", "fruit"})
public class FruitPropertyTests {

    @Autowired
    FruitProperty1 fruitProperty1;

    @Autowired
    FruitProperty2 fruitProperty2;

    @Test public void test1() {
        List<Map> fruitData = fruitProperty1.getList();

        assertThat(fruitData.get(0).get("name"), is("banana"));
        assertThat(fruitData.get(0).get("color"), is("yellow"));

        assertThat(fruitData.get(1).get("name"), is("apple"));
        assertThat(fruitData.get(1).get("color"), is("red"));

        assertThat(fruitData.get(2).get("name"), is("water melon"));
        assertThat(fruitData.get(2).get("color"), is("green"));
     }

    @Test public void test2() {
        List<Fruit> fruitData = fruitProperty2.getList();

        assertThat(fruitData.get(0).getName(), is("banana"));
        assertThat(fruitData.get(0).getColor(), is("yellow"));

        assertThat(fruitData.get(1).getName(), is("apple"));
        assertThat(fruitData.get(1).getColor(), is("red"));

        assertThat(fruitData.get(2).getName(), is("water melon"));
        assertThat(fruitData.get(2).getColor(), is("green"));
    }
}
