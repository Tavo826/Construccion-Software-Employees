package com.construccion.software.employee.domain.ports;

import com.construccion.software.employee.domain.models.Employee;

public interface EmployeePort {

    public Employee findById(long id);
    public Employee findByDocument(long documentId);
    public Employee save(Employee user);
    public Employee update(long id, Employee employee) throws Exception;
    public void delete(long id);
}
