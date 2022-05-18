package com.example.Payroll;

import org.springframework.data.jpa.repository.JpaRepository;

interface EmployeeRepository extends JpaReporsitory<Employee, Long> {

}