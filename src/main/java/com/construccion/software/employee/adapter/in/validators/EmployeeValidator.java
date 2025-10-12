package com.construccion.software.employee.adapter.in.validators;

import com.construccion.software.employee.domain.models.enums.Role;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class EmployeeValidator extends SimpleValidator{

    public long documentValidator(String value) {
        return longValidator("el documento de la persona", value);
    }

    public String nameValidator(String value) {
        return stringValidator("nombre de la persona", value);
    }

    public LocalDate birthDateValidator(String value) {
        return dateValidator("fecha de nacimiento", value);
    }

    public String phoneValidator(String value) {
        return stringValidator("telefono", value);
    }

    public String emailValidator(String value) {
        return emailValidator("email", value);
    }

    public String addressValidator(String value) {
        return stringValidator("direccion", value);
    }

    public Role roleValidator(String value) {
        return roleValidator("role", value);
    }

    public String usernameValidator(String value) {
        return stringValidator("username", value);
    }

    public String passwordValidator(String value) {
        return stringValidator("clave", value);
    }
}
