package org.example.dao.impl;

import org.example.dao.AccountDAO;
import org.example.model.entity.Account;
import org.example.model.entity.Employee;
import org.example.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class AccountDAOImpl implements AccountDAO {
    @Override
    public List<Account> findAll() {
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateUtils.getSessionFactory().openSession();
            // start a transaction
            transaction = session.beginTransaction();
            Query query = session.createQuery("FROM Account", Account.class);
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
    public Account findByEmployee(int employeeId) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateUtils.getSessionFactory().openSession();
            // start a transaction
            transaction = session.beginTransaction();
            Query query = session.createQuery("FROM Account a WHERE a.employee.employeeId = :employeeId", Account.class);
            query.setParameter("employeeId", employeeId);
            // commit transaction
            transaction.commit();
            return (Account) query.getSingleResult();
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
    public Account findById(int id) {
        Transaction transaction = null;
        Account data = null;

        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an object
            data = session.get(Account.class, id);
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
    public void save(Account account) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the object
            session.saveOrUpdate(account);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAccountById(int id) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Account account = session.get(Account.class, id);
            if (account != null) {
                session.delete(account);
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Account findByUserName(String username) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("FROM Account a Where a.accountName = :username", Account.class);
            query.setParameter("username", username);
            // commit transaction
            transaction.commit();
            return (Account) query.getSingleResult();
        } catch (Exception e) {
            // Handle exception appropriately
            e.printStackTrace();
        }
        return null;
    }
}
