package com.construccion.software.employee.domain.services;

import com.construccion.software.employee.application.exceptions.BusinessException;
import com.construccion.software.employee.domain.models.Employee;
import com.construccion.software.employee.domain.ports.EmployeePort;
import org.springframework.stereotype.Service;

@Service
public class CreateEmployee {

    private final EmployeePort employeePort;

    public CreateEmployee(EmployeePort employeePort) {
        this.employeePort = employeePort;
    }

    public Employee create(Employee employee) throws Exception {

        if (employeePort.findByDocument(employee.getDocumentId()) != null) {
            throw new BusinessException("ya existe una persona registrada con esa cédula");
        }

        if (employeePort.findByUsername(employee.getUsername()) != null) {
            throw new BusinessException("ya existe una persona registrada con este username");
        }

        return employeePort.save(employee);
    }
}
