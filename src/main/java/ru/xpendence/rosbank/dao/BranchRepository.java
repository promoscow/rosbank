package ru.xpendence.rosbank.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.xpendence.rosbank.model.Branch;

import java.util.List;

public interface BranchRepository extends JpaRepository<Branch, Long> {
    @Query("select b from Branch b where b.cityId = ?1")
    List<Branch> findAllByCityId(Long id);
}