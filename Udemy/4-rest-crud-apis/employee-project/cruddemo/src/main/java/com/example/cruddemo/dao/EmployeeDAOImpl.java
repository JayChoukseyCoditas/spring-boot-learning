package com.example.cruddemo.dao;

import com.example.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    // define field for entityManager
    private EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        // create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery(
                "FROM Employee",Employee.class
        );

        // execute query and get result list
        List<Employee> employees = theQuery.getResultList();

        // return the results
        return employees;
    }

    @Override
    public Employee findById(int theId) {

        // get employee
        Employee theEmployee = entityManager.find(Employee.class, theId);

        // return employee
        return theEmployee;
    }

    // We don't use @Transactional at DAO layer. It will be handled at Service layer
    @Override
    public Employee save(Employee theEmployee) {

        // save or update the employee
        // if id==0 then save/insert else update
        Employee dbEmployee = entityManager.merge(theEmployee);

        // return dbEmployee
        return dbEmployee; // it has updated id from the db(in case of insert)
    }

    // We don't use @Transactional at DAO layer. It will be handled at Service layer
    @Override
    public void deleteById(int theId) {

        // find the employee by id
        Employee employee = entityManager.find(Employee.class, theId);

        // remove employee
        entityManager.remove(employee);
    }
}
