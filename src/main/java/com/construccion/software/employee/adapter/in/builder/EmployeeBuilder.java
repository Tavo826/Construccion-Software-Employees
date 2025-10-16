package com.construccion.software.employee.adapter.in.builder;

import com.construccion.software.employee.adapter.in.validators.EmployeeValidator;
import com.construccion.software.employee.application.exceptions.InputsException;
import com.construccion.software.employee.domain.models.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeBuilder {

    private final EmployeeValidator employeeValidator;

    public EmployeeBuilder(EmployeeValidator employeeValidator) {
        this.employeeValidator = employeeValidator;
    }

    public Employee build(
            String documentId,
            String name,
            String birthDate,
            String phone,
            String email,
            String address,
            String role,
            String username,
            String password) throws InputsException {

        Employee employee = new Employee();
        employee.setDocumentId(employeeValidator.documentValidator(documentId));
        employee.setName(employeeValidator.nameValidator(name));
        employee.setBirthDate(employeeValidator.birthDateValidator(birthDate));
        employee.setPhone(employeeValidator.phoneValidator(phone));
        employee.setEmail(employeeValidator.emailValidator(email));
        employee.setAddress(employeeValidator.addressValidator(address));
        employee.setRole(employeeValidator.roleValidator(role));
        employee.setUsername(employeeValidator.usernameValidator(username));
        employee.setPassword(employeeValidator.passwordValidator(password));

        return employee;
    }

    public long getDocumentId(String documentId) throws InputsException {

        return employeeValidator.documentValidator(documentId);
    }
}
