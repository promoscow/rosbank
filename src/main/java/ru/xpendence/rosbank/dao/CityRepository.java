package ru.xpendence.rosbank.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.xpendence.rosbank.model.City;

public interface CityRepository extends JpaRepository<City, Long> {
    City getByName(String name);

}
