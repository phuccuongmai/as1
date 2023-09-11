package org.example.dao;

import org.example.model.entity.Account;
import org.example.model.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(int id);

    void save(Employee employee, Account account);

    List<Employee> findEmpByName(String name);

    void deleteEmployeeById(int id);

}
