package vn.edu.iuh.fit.backend.services;

import vn.edu.iuh.fit.backend.models.Employee;
import vn.edu.iuh.fit.backend.repositories.EmployeeRepository;

import java.util.Optional;

public class EmployeeServices {
    private EmployeeRepository employeeRepository;
    public EmployeeServices(){
        employeeRepository = new EmployeeRepository();
    }
    public boolean insertEmp (Employee e){
        return employeeRepository.insertEmployee(e);
    }

}
