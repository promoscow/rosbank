package ru.xpendence.rosbank.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "branch")
@Data
@EqualsAndHashCode
@ToString
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long city_id;
    private String name;
    private Double geo_lat;
    private Double geo_lon;
    private String street;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "branch_id")
    private List<Employee> employees = new ArrayList<>();
}
