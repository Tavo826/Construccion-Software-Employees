package com.construccion.software.employee.application.usecases;

import com.construccion.software.employee.domain.models.Employee;
import com.construccion.software.employee.domain.services.CreateEmployee;
import com.construccion.software.employee.domain.services.DeleteEmployee;
import com.construccion.software.employee.domain.services.GetEmployee;
import com.construccion.software.employee.domain.services.UpdateEmployee;
import org.springframework.stereotype.Service;

@Service
public class EmployeeUseCase {

    private final GetEmployee getEmployee;
    private final CreateEmployee createEmployee;
    private final UpdateEmployee updateEmployee;
    private final DeleteEmployee deleteEmployee;

    public EmployeeUseCase(
            GetEmployee getEmployee,
            CreateEmployee createEmployee,
            UpdateEmployee updateEmployee,
            DeleteEmployee deleteEmployee) {
        this.getEmployee = getEmployee;
        this.createEmployee = createEmployee;
        this.updateEmployee = updateEmployee;
        this.deleteEmployee = deleteEmployee;
    }

    public Employee getEmployeeByDocumentId(long documentId) throws Exception {

        return getEmployee.getByDocumentId(documentId);
    }

    public Employee createEmployee(Employee employee) throws Exception {

        return createEmployee.create(employee);
    }

    public Employee updateEmployee(long id, Employee employee) throws Exception {

        return updateEmployee.update(id, employee);
    }

    public void deleteEmployee(long id) throws Exception {

        deleteEmployee.delete(id);
    }
}
