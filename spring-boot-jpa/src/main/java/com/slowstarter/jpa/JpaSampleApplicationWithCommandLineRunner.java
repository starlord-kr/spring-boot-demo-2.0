package com.slowstarter.jpa;

import com.slowstarter.jpa.entity.SimpleCar;
import com.slowstarter.jpa.service.SimpleCarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class JpaSampleApplicationWithCommandLineRunner implements CommandLineRunner {

    Logger LOG = LoggerFactory.getLogger(JpaSampleApplicationWithCommandLineRunner.class);

    static final String BMW = "BMW";
    static final String AUDI = "AUDI";
    static final String BENZ = "BENZ";

    private SimpleCarService simpleCarService;

    @Autowired
    public JpaSampleApplicationWithCommandLineRunner(SimpleCarService simpleCarService) {
        this.simpleCarService = simpleCarService;
    }

    @Override
    public void run(String... args) {
        simpleCarService.saveSimpleCar(BMW, 1234567);
        LOG.info("-- BMW saved!!");
        simpleCarService.saveSimpleCar(AUDI, 4567890);
        LOG.info("-- AUDI saved!!");
        simpleCarService.saveSimpleCar(BENZ, 2345678);
        LOG.info("-- BENZ saved!!");

        LOG.info("-- -- -- ");
        LOG.info("-- -- -- ");
        SimpleCar bmw = simpleCarService.getSimpleCarByName(BMW);
        LOG.info("-- BMW={}", bmw);
        SimpleCar audi = simpleCarService.getSimpleCarByName(AUDI);
        LOG.info("-- AUDI={}", audi);
        SimpleCar benz = simpleCarService.getSimpleCarByName(BENZ);
        LOG.info("-- BENZ={}", benz);
        LOG.info("-- -- -- ");
        LOG.info("-- -- -- ");

        List<SimpleCar> simpleCarList = simpleCarService.findAll();
        for(SimpleCar simpleCar : simpleCarList) {
            LOG.info("-- SimpleCar={}", simpleCar);
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(JpaSampleApplicationWithCommandLineRunner.class, args);
    }
}
