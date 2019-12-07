package ru.xpendence.rosbank.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Table;

@Table(name = "employee")
@Data
@EqualsAndHashCode
@ToString
public class Employee {
    private Long id;
    private String name;
    private boolean is_online;
    private int count_lid;
    private Long branch_id;

}
