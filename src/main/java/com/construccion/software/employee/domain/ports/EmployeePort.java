package com.construccion.software.employee.domain.ports;

import com.construccion.software.employee.domain.models.Employee;

import java.util.List;

public interface EmployeePort {

    List<Employee> findAll();
    Employee findByDocumentId(long documentId);
    Employee findByUsername(String username);
    Employee save(Employee employee);
    Employee update(Employee employee);
    void delete(long documentId);
}
