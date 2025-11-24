package com.construccion.software.employee.adapter.out;

import com.construccion.software.employee.application.exceptions.BusinessException;
import com.construccion.software.employee.domain.models.Employee;
import com.construccion.software.employee.domain.ports.EmployeePort;
import com.construccion.software.employee.infrastructure.persistence.entities.EmployeeEntity;
import com.construccion.software.employee.infrastructure.persistence.mapper.EmployeeMapper;
import com.construccion.software.employee.infrastructure.persistence.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeAdapter implements EmployeePort {

    private final EmployeeRepository employeeRepository;

    public EmployeeAdapter(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {

        List<EmployeeEntity> employees = employeeRepository.findAll();

        return EmployeeMapper.toDomain(employees);
    }

    @Override
    public Employee findByDocumentId(long documentId) {

        Optional<EmployeeEntity> employeeOptional = employeeRepository.findById(documentId);

        if (employeeOptional.isPresent()) {
            EmployeeEntity employeeEntity = employeeOptional.get();
            return EmployeeMapper.toDomain(employeeEntity);
        }

        return null;
    }

    @Override
    public Employee findByUsername(String username) {

        EmployeeEntity employeeEntity = employeeRepository.findByUsername(username);

        return EmployeeMapper.toDomain(employeeEntity);
    }

    @Override
    public Employee save(Employee employee) {

        EmployeeEntity employeeEntity = employeeRepository.save(EmployeeMapper.toEntity(employee));
        return EmployeeMapper.toDomain(employeeEntity);
    }

    @Override
    public Employee update(Employee employee) {

        Optional<EmployeeEntity> employeeOptional = employeeRepository.findById(employee.getDocumentId());

        if (employeeOptional.isPresent()) {
            EmployeeEntity employeeEntity = employeeOptional.get();

            employeeEntity.setName(employee.getName());
            employeeEntity.setSurname(employeeEntity.getSurname());
            employeeEntity.setBirthDate(employee.getBirthDate());
            employeeEntity.setPhone(employee.getPhone());
            employeeEntity.setEmail(employee.getEmail());
            employeeEntity.setAddress(employee.getAddress());
            employeeEntity.setRole(employee.getRole().name());
            employeeEntity.setUsername(employee.getUsername());
            employeeEntity.setPassword(employee.getPassword());

            EmployeeEntity updatedEmployee = employeeRepository.save(employeeEntity);
            return EmployeeMapper.toDomain(updatedEmployee);
        }

        return null;
    }

    @Override
    public void delete(long documentId) {

        employeeRepository.deleteById(documentId);
    }
}
