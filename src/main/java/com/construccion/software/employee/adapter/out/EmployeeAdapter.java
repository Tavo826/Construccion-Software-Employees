package com.construccion.software.employee.adapter.out;

import com.construccion.software.employee.application.exceptions.BusinessException;
import com.construccion.software.employee.application.exceptions.EmployeeNotFoundException;
import com.construccion.software.employee.domain.models.Employee;
import com.construccion.software.employee.domain.ports.EmployeePort;
import com.construccion.software.employee.infrastructure.persistence.entities.EmployeeEntity;
import com.construccion.software.employee.infrastructure.persistence.mapper.EmployeeMapper;
import com.construccion.software.employee.infrastructure.persistence.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeAdapter implements EmployeePort {

    private final EmployeeRepository employeeRepository;

    public EmployeeAdapter(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee findById(long id) {

        EmployeeEntity employeeEntity = employeeRepository.findById(id).orElse(null);

        return EmployeeMapper.toDomain(employeeEntity);
    }

    @Override
    public Employee findByDocument(long documentId) {

        EmployeeEntity employeeEntity = employeeRepository.findByDocumentId(documentId);

        return EmployeeMapper.toDomain(employeeEntity);
    }

    @Override
    public Employee save(Employee employee) {

        EmployeeEntity employeeEntity = employeeRepository.save(EmployeeMapper.toEntity(employee));
        return EmployeeMapper.toDomain(employeeEntity);
    }

    @Override
    public Employee update(long id, Employee employee) throws Exception {

        Optional<EmployeeEntity> employeeOptional = employeeRepository.findById(id);

        if (employeeOptional.isPresent()) {
            EmployeeEntity employeeEntity = employeeOptional.get();

            employeeEntity.setName(employee.getName());
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
        else {
            throw new BusinessException("ocurrió un problema encontrando al usuario");
        }
    }

    @Override
    public void delete(long id) {

        employeeRepository.deleteById(id);
    }
}
