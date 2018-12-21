package com.slowstarter.jpa.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor
@Table
public class SimpleCar {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private Integer number;

    @Column
    private LocalDateTime createDate;

    @Builder
    public SimpleCar(Long id,
                     String name,
                     Integer number,
                     LocalDateTime createDate) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.createDate = createDate;
    }
}
