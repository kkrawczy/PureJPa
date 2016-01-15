package com.karol.dao;

import com.karol.EntityManagerHelper;
import com.karol.entity.Employee;

import javax.persistence.EntityManager;
import java.util.List;

public class EmployeeDao {

    private EntityManager entityManager = EntityManagerHelper.getEntityManager();

    public Employee create(Employee e) {
        entityManager.getTransaction().begin();
        entityManager.persist(e);
        entityManager.getTransaction().commit();
        return e;
    }

    public Employee findById(int id) {
        return entityManager.find(Employee.class, id);
    }

    public List<Employee> findAll() {
        return entityManager.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
    }

}