package ru.xpendence.rosbank.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.xpendence.rosbank.model.Branch;

public interface BranchRepository extends JpaRepository<Branch, Long> {

}
