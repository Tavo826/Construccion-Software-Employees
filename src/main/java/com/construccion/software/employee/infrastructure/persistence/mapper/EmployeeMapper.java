package com.construccion.software.employee.infrastructure.persistence.mapper;

import com.construccion.software.employee.domain.models.Employee;
import com.construccion.software.employee.domain.models.enums.Role;
import com.construccion.software.employee.infrastructure.persistence.entities.EmployeeEntity;

public class EmployeeMapper {

    public static EmployeeEntity toEntity(Employee employee) {

        if (employee == null) {
            return null;
        }

        EmployeeEntity entity = new EmployeeEntity();
        entity.setDocumentId(employee.getDocumentId());
        entity.setName(employee.getName());
        entity.setSurname(employee.getSurname());
        entity.setBirthDate(employee.getBirthDate());
        entity.setPhone(employee.getPhone());
        entity.setEmail(employee.getEmail());
        entity.setAddress(employee.getAddress());
        entity.setRole(employee.getRole().name());
        entity.setUsername(employee.getUsername());
        entity.setPassword(employee.getPassword());

        return entity;
    }

    public static Employee toDomain(EmployeeEntity entity) {

        if (entity == null) {
            return null;
        }
        Employee employee = new Employee();
        employee.setDocumentId(entity.getDocumentId());
        employee.setName(entity.getName());
        employee.setSurname(entity.getSurname());
        employee.setBirthDate(entity.getBirthDate());
        employee.setPhone(entity.getPhone());
        employee.setEmail(entity.getEmail());
        employee.setAddress(entity.getAddress());
        employee.setRole(Role.valueOf(entity.getRole()));
        employee.setUsername(entity.getUsername());
        employee.setPassword(entity.getPassword());

        return employee;
    }
}
