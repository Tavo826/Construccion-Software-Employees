package com.construccion.software.employee.domain.services;

import com.construccion.software.employee.domain.models.Employee;
import com.construccion.software.employee.domain.ports.EmployeePort;
import org.springframework.stereotype.Service;

@Service
public class UpdateEmployee {

    private final EmployeePort employeePort;

    public UpdateEmployee(EmployeePort employeePort) {
        this.employeePort = employeePort;
    }

    public Employee update(long id, Employee employee) throws Exception {

        return employeePort.update(id, employee);
    }
}
