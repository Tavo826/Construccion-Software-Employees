package com.construccion.software.employee.domain.services;

import com.construccion.software.employee.application.exceptions.EmployeeNotFoundException;
import com.construccion.software.employee.domain.models.Employee;
import com.construccion.software.employee.domain.ports.EmployeePort;
import org.springframework.stereotype.Service;

@Service
public class GetEmployee {

    private final EmployeePort employeePort;

    public GetEmployee(EmployeePort employeePort) {
        this.employeePort = employeePort;
    }

    public Employee getByDocumentId(long documentId) throws Exception {

        Employee employee = employeePort.findByDocument(documentId);
        if (employee == null) {
            throw new EmployeeNotFoundException("no existe una persona registrada con esa cédula");
        }

        return employee;
    }
}
