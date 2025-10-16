package com.construccion.software.employee.adapter.in.validators;

import com.construccion.software.employee.application.exceptions.InputsException;
import com.construccion.software.employee.domain.models.enums.Role;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class EmployeeValidator extends SimpleValidator{

    public long documentValidator(String value) throws InputsException {
        return longValidator("el documento de la persona", value);
    }

    public String nameValidator(String value) throws InputsException {
        return stringValidator("nombre de la persona", value);
    }

    public String surnameValidator(String value) throws InputsException {
        return stringValidator("apellido de la persona", value);
    }

    public LocalDate birthDateValidator(String value) throws InputsException {
        return dateValidator("fecha de nacimiento", value);
    }

    public long phoneValidator(String value) throws InputsException {
        return phoneValidator("teléfono", value);
    }

    public String emailValidator(String value) throws InputsException {
        return emailValidator("email", value);
    }

    public String addressValidator(String value) throws InputsException {
        return addressValidator("dirección", value);
    }

    public Role roleValidator(String value) throws InputsException {
        return roleValidator("role", value);
    }

    public String usernameValidator(String value) throws InputsException {
        return usernameValidator("username", value);
    }

    public String passwordValidator(String value) throws InputsException {
        return passwordValidator("clave", value);
    }
}
