package com.construccion.software.employee.adapter.in.validators;

import com.construccion.software.employee.application.exceptions.InputsException;
import com.construccion.software.employee.domain.models.enums.Role;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class SimpleValidator {

    public String stringValidator(String element, String value) {
        if (value == null || value.equals("")) {
            throw new InputsException(element + " no puede tener un valor vacio o nulo");
        }
        return value;
    }

    public long longValidator(String element, String value) {
        stringValidator(element, value);
        try {
            return Long.parseLong(value);
        } catch (Exception e) {
            throw new InputsException(element + " debe ser un valor numerico");
        }
    }

    public Role roleValidator(String element, String value) {
        stringValidator(element, value);
        try {
            return Role.valueOf(value);
        } catch (Exception e) {
            throw new InputsException(element + " no es un rol válido");
        }
    }

    public LocalDate dateValidator(String element, String value) {
        stringValidator(element, value);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try {
            return LocalDate.parse(value, formatter);
        } catch (Exception e) {
            throw new InputsException(element + " debe ser una fecha válida en formato yyyy-MM-dd");
        }
    }

    public String emailValidator(String element, String value) {
        stringValidator(element, value);

        if (!value.contains("@")) {
            throw new InputsException(element + " debe contener el símbolo @");
        }

        String[] parts = value.split("@");

        if (parts.length != 2 || parts[0].isEmpty() || parts[1].isEmpty()) {
            throw new InputsException(element + " debe tener el formato: usuario@dominio.com");
        }

        String dominio = parts[1];

        if (!dominio.contains(".")) {
            throw new InputsException(element + " debe tener un dominio válido");
        }

        String[] dominioParts = dominio.split("\\.");
        String extension = dominioParts[dominioParts.length - 1];

        if (extension.length() < 2) {
            throw new InputsException(element + " debe tener una extensión de dominio válida");
        }

        return value;
    }
}
