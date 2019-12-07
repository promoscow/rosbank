package ru.xpendence.rosbank.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@ToString
@EqualsAndHashCode
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private boolean online;
    @Column(name="count_lid")
    private int countLid;
    @Column(name="branch_id")
    private Long branchId;

}
