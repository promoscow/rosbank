package ru.xpendence.rosbank.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "employees")
@Data
@EqualsAndHashCode
@ToString
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private boolean is_online;
    private int count_lid;
    private Long branch_id;

}
