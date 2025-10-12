package com.construccion.software.employee.infrastructure.persistence.repository;

import com.construccion.software.employee.infrastructure.persistence.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

    public EmployeeEntity findByDocumentId(long documentId);
}
