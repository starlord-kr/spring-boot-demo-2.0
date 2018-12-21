package com.slowstarter.jpa.service;

import com.slowstarter.jpa.entity.SimpleCar;
import com.slowstarter.jpa.repository.SimpleCarRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SimpleCarService {

    private SimpleCarRepository simpleCarRepository;

    public SimpleCarService(SimpleCarRepository simpleCarRepository) {
        this.simpleCarRepository = simpleCarRepository;
    }

    public List<SimpleCar> findAll() {
        return simpleCarRepository.findAll();
    }

    public SimpleCar getSimpleCar(Long id) {
        return simpleCarRepository.getOne(id);
    }

    public SimpleCar getSimpleCarByName(String name) {
        return simpleCarRepository.findByName(name);
    }

    public void saveSimpleCar(String name, Integer number) {
        SimpleCar simpleCar = SimpleCar
                .builder()
                .name(name)
                .number(number)
                .createDate(LocalDateTime.now())
                .build();
        simpleCarRepository.save(simpleCar);
    }
}
