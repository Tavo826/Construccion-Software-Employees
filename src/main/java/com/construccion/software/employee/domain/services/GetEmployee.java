package com.construccion.software.employee.domain.services;

import com.construccion.software.employee.application.exceptions.EmployeeNotFoundException;
import com.construccion.software.employee.domain.models.Employee;
import com.construccion.software.employee.domain.ports.EmployeePort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetEmployee {

    private final EmployeePort employeePort;

    public GetEmployee(EmployeePort employeePort) {
        this.employeePort = employeePort;
    }

    public List<Employee> getAllEmployees() throws Exception {

        List<Employee> employeeList = employeePort.findAll();

        if (employeeList.isEmpty()) {
            throw new EmployeeNotFoundException("no existen empleados");
        }

        return employeeList;
    }

    public Employee getByDocumentId(long documentId) throws Exception {

        Employee employee = employeePort.findByDocumentId(documentId);
        if (employee == null) {
            throw new EmployeeNotFoundException("no existe una persona registrada con esa cédula");
        }

        return employee;
    }

    public Employee getByUsername(String username) throws Exception {

        Employee employee = employeePort.findByUsername(username);
        if (employee == null) {
            throw new EmployeeNotFoundException("no existe una persona registrada con ese usuario");
        }

        return employee;
    }
}
