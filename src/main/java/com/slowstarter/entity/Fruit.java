package com.slowstarter.entity;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Getter
@NoArgsConstructor
@Table
public class Fruit {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "color")
    private String color;
    @Column(name = "createDate")
    private LocalDateTime createDate;

    @Builder
    public Fruit(Long id, String name, String color) {
        this.id = id;
        this.name = name;
        this.color = color;
    }
}
