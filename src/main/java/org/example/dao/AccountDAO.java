package org.example.dao;

import org.example.model.entity.Account;
import org.example.model.entity.Employee;
import org.hibernate.HibernateException;

import java.util.List;

public interface AccountDAO {

    List<Account> findAll();

    Account findByEmployee(int employeeId);

    Account findById(int id);

    void save(Account account);

    void deleteAccountById(int id);

    Account findByUserName(String username);



}




