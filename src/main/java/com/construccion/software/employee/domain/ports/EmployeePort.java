package com.construccion.software.employee.domain.ports;

import com.construccion.software.employee.domain.models.Employee;

public interface EmployeePort {

    public Employee findByDocument(long documentId);
    public Employee findByUsername(String username);
    public Employee save(Employee user);
    public Employee update(Employee employee);
    public void delete(long documentId);
}
