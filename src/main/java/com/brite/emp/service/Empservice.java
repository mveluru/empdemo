package com.brite.emp.service;

import com.brite.emp.domain.Employee;
import com.brite.emp.repositary.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Optional;


@Service
public class Empservice {
    private EmployeeRepository employeeRepository;

    @Autowired
    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee addemployee(String empName, String empDept){
        Employee emp = new Employee(empName,empDept);
        return (employeeRepository.save(emp));
    }

    public  Iterable<Employee> getemployees(){
        return  employeeRepository.findAll();
    }

    public Optional<Employee> findbyEmpId(Integer id) throws SQLException{
        Optional<Employee> employee = employeeRepository.findById(id);
        if (!employee.isPresent()){
            throw new SQLException("Employee Not Found");
        }
        return employee;
    }

    public String deleteEmployee(Integer id) throws SQLException{
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isPresent()) {
            employeeRepository.deleteById(employee.get().getId());
        }else{
            throw new SQLException("Resource Not Found");
        }
        return "Deleted";
    }

    public Employee putemployee(Employee employee) throws SQLException {
        Optional<Employee> emp = employeeRepository.findById(employee.getId());
        Employee updateEmp = new Employee();
        if (emp.isPresent()){
            updateEmp.setId(emp.get().getId());
            updateEmp.setDept(employee.getDept());
            updateEmp.setName(employee.getName());
            employeeRepository.save(updateEmp);

        }else if (!emp.isPresent() || emp == null){
            throw new SQLException("NotData found");
        }
    return updateEmp;
    }
}
