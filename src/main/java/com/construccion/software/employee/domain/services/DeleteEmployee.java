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

    public void delete(long documentId) throws Exception {

        if (employeePort.findByDocument(documentId) == null) {
            throw new BusinessException("No existe un empleado con el documento " + documentId);
        }

        employeePort.delete(documentId);
    }
}
