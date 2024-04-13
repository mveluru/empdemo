package com.brite.emp.controller;

import com.brite.emp.domain.Employee;
import com.brite.emp.service.Empservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/emp")
public class Empcontroller {

    public Empservice empservice;

    @Autowired
    public void setEmpservice(Empservice empservice) {
        this.empservice = empservice;
    }

    @PostMapping("/addemp")
    public @ResponseBody Employee addemp(@RequestBody Employee employee) {
        return empservice.addemployee(employee.getName(), employee.getDept());
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Employee> getAllUsers() {
        return empservice.getemployees();
    }

    @GetMapping(path = "/empid/{id}")
    public @ResponseBody Optional<Employee> getempbyid(@PathVariable Integer id) throws SQLException{
        return empservice.findbyEmpId(id);
    }

    @PutMapping(path = "/updateemp")
    public @ResponseBody Optional<Employee> updateEmp(@RequestBody Employee employee) throws SQLException {
        return Optional.ofNullable(empservice.putemployee(employee));

    }

    @DeleteMapping(path = "/deleteemp/{id}")
    public @ResponseBody Optional<String> deleteEmp(@PathVariable Integer id) throws SQLException {
        return Optional.ofNullable(empservice.deleteEmployee(id));
    }
}
