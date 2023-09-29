package vn.edu.iuh.fit.backend.services;

import vn.edu.iuh.fit.backend.models.Employee;
import vn.edu.iuh.fit.backend.repositories.EmployeeRepository;

import java.util.List;
import java.util.Optional;

public class EmployeeServices {
    private EmployeeRepository employeeRepository;
    public EmployeeServices(){
        employeeRepository = new EmployeeRepository();
    }
    public boolean insertEmp (Employee e){
        return employeeRepository.insertEmployee(e);
    }

    public Optional<Employee> findEmp(long id){
        return employeeRepository.findEmployee(id);
    }

    public List<Employee> getAllEmp(){
        return employeeRepository.getAllEmployee();
    }

    public boolean insertEmps(Employee employees){
        return employeeRepository.insertEmployee(employees);
    }

    public boolean deleteEmp(long id){
        return employeeRepository.deleteEmployee(id);
    }
}
