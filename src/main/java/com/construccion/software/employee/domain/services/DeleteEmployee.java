package com.construccion.software.employee.domain.services;

import com.construccion.software.employee.application.exceptions.BusinessException;
import com.construccion.software.employee.application.exceptions.EmployeeNotFoundException;
import com.construccion.software.employee.domain.ports.EmployeePort;
import org.springframework.stereotype.Service;

@Service
public class DeleteEmployee {

    private final EmployeePort employeePort;

    public DeleteEmployee(EmployeePort employeePort) {
        this.employeePort = employeePort;
    }

    public void delete(long id) throws Exception {

        if (employeePort.findById(id) == null) {
            throw new BusinessException("No existe un empleado con el id " + id);
        }

        employeePort.delete(id);
    }
}
