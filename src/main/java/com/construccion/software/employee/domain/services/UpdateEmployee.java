package com.construccion.software.employee.domain.services;

import com.construccion.software.employee.application.exceptions.EmployeeNotFoundException;
import com.construccion.software.employee.domain.models.Employee;
import com.construccion.software.employee.domain.ports.EmployeePort;
import org.springframework.stereotype.Service;

@Service
public class UpdateEmployee {

    private final EmployeePort employeePort;

    public UpdateEmployee(EmployeePort employeePort) {
        this.employeePort = employeePort;
    }

    public Employee update(Employee employee) throws Exception {

        Employee updatedEmployee = employeePort.update(employee);
        if (updatedEmployee == null) {
            throw new EmployeeNotFoundException("no existe una persona registrada con esa cédula");
        }
        return updatedEmployee;
    }
}
