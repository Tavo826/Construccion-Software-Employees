package com.construccion.software.employee.domain.services;

import com.construccion.software.employee.application.exceptions.BusinessException;
import com.construccion.software.employee.domain.ports.EmployeePort;
import org.springframework.stereotype.Service;

@Service
public class DeleteEmployee {

    private final EmployeePort employeePort;

    public DeleteEmployee(EmployeePort employeePort) {
        this.employeePort = employeePort;
    }

    public void delete(long id) throws Exception {

        if (employeePort.findByDocument(id) == null) {
            throw new BusinessException("No existe un empleado con el documento " + id);
        }

        employeePort.delete(id);
    }
}
