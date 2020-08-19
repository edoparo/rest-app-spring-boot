package com.kube.restapp.RestApp.repository;

import com.kube.restapp.RestApp.bean.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}