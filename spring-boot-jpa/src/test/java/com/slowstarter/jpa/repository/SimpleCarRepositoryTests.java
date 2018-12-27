package com.slowstarter.jpa.repository;


import com.slowstarter.jpa.entity.SimpleCar;
import org.hamcrest.collection.IsEmptyCollection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("local")
@AutoConfigureTestDatabase(
        replace = AutoConfigureTestDatabase.Replace.NONE,
        connection = EmbeddedDatabaseConnection.H2  // 해도되고 안해도 되고...
)
public class SimpleCarRepositoryTests {

    static final String BMW = "BMW";
    static final String AUDI = "AUDI";
    static final String BENZ = "BENZ";

    @Autowired TestEntityManager testEntityManager;
    @Autowired SimpleCarRepository simpleCarRepository;

    @Test
    public void saveTest() {

        SimpleCar simpleCar = SimpleCar
                .builder()
                .name(BMW)
                .number(1234567)
                .createDate(LocalDateTime.now())
                .build();

        testEntityManager.persist(simpleCar);

        assertThat(simpleCarRepository.getOne(simpleCar.getId()), is(simpleCar));
    }

    @Test
    public void saveAll() {
        SimpleCar bmw = SimpleCar
                .builder()
                .name(BMW)
                .number(1234567)
                .createDate(LocalDateTime.now())
                .build();

        testEntityManager.persist(bmw);


        SimpleCar audi = SimpleCar
                .builder()
                .name(AUDI)
                .number(2345678)
                .createDate(LocalDateTime.now())
                .build();

        testEntityManager.persist(audi);

        SimpleCar benz = SimpleCar
                .builder()
                .name(BENZ)
                .number(2345678)
                .createDate(LocalDateTime.now())
                .build();

        testEntityManager.persist(benz);


        List<SimpleCar> simpleCarList = simpleCarRepository.findAll();
        assertThat(simpleCarList, hasSize(3));
        assertThat(simpleCarList, contains(bmw, audi, benz));
    }

    @Test
    public void saveThenDeleteTest() {

        SimpleCar bmw = SimpleCar
                .builder()
                .name(BMW)
                .number(1234567)
                .createDate(LocalDateTime.now())
                .build();

        testEntityManager.persist(bmw);

        simpleCarRepository.deleteAll();

        assertThat(simpleCarRepository.findAll(), IsEmptyCollection.empty());
    }

}
