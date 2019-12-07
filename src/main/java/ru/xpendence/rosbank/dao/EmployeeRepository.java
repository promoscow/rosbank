package ru.xpendence.rosbank.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.xpendence.rosbank.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
