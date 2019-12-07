package ru.xpendence.rosbank.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity
@ToString
@EqualsAndHashCode
@Table(name = "branch")
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "city_id")
    private Long cityId;
    private String name;
    private Double geoLat;
    private Double geoLon;
    private String street;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "branch_id")
    private List<Employee> employees = new ArrayList<>();
    @Transient
    private Double path;
    @Transient
    private int countEmployee;

}
