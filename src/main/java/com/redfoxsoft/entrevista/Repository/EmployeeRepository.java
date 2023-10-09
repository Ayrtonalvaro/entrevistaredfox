package com.redfoxsoft.entrevista.Repository;

import com.redfoxsoft.entrevista.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findById(Long id);
    Optional<Employee> findByName(String name);
}
