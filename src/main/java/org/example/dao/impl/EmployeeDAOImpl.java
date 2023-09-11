package org.example.dao.impl;

import org.example.dao.EmployeeDAO;
import org.example.model.entity.Account;
import org.example.model.entity.Employee;
import org.example.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public List<Employee> findAll() {
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateUtils.getSessionFactory().openSession();
            // start a transaction
            transaction = session.beginTransaction();
            Query query = session.createQuery("FROM Employee", Employee.class);
            // commit transaction
            transaction.commit();
            return query.getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public Employee findById(int id) {
        Transaction transaction = null;
        Employee data = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an object
            data = session.get(Employee.class, id);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public List<Employee> findEmpByName(String name) {
        List<Employee> rsEmp = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()){
            String hql = "FROM Employee u WHERE u.firstName = :name";
            org.hibernate.query.Query<Employee> query = session.createQuery(hql, Employee.class);
            query.setParameter("name", name);
            rsEmp = query.getResultList();
            return rsEmp;
        } catch (Exception e) {
            e.printStackTrace();
            return rsEmp;
        }
    }

    @Override
    public void save(Employee employee, Account account) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            int id = (int) session.save(employee);
            Employee dbEmp = session.find(Employee.class, id);
            account.setEmployee(dbEmp);
            session.save(account);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEmployeeById(int id) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Employee employee = findById(id);
            Account account = employee.getAccount();
            employee.setAccount(null);
            session.remove(account);
            session.remove(employee);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
