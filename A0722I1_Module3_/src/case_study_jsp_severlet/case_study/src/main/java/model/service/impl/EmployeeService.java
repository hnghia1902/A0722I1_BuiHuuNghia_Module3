package model.service.impl;

import model.person.Employee;
import model.repository.IEmployeeRepository;
import model.repository.impl.EmployeeRepository;
import model.service.IEmployeeService;

import java.util.List;

public class EmployeeService implements IEmployeeService {
    IEmployeeRepository iEmployeeRepository = new EmployeeRepository();

    @Override
    public List<Employee> showListEmployee() {
        return iEmployeeRepository.showListEmployee();
    }
}
