package com.karol.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@Builder
public class Employee {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;
}