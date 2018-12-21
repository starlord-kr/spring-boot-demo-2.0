package com.slowstarter.jpa.repository;

import com.slowstarter.jpa.entity.SimpleCar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SimpleCarRepository extends JpaRepository<SimpleCar, Long> {
    SimpleCar findByName(String name);
}
