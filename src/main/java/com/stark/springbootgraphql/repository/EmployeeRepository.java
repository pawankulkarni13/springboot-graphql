package com.stark.springbootgraphql.repository;

import com.stark.springbootgraphql.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
