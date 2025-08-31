package com.example.advancehibernate.dao;

import com.example.advancehibernate.entity.Instructor;
import com.example.advancehibernate.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AppDAOImpl implements AppDAO{

    // define the field for entity manager
    private EntityManager entityManager;

    @Autowired
    public AppDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor); // This will also save the details object because of CascadeType.ALL
    }

    // This will ALSO retrieve the instructor details object
    // Because of default behaviour of @OneToOne fetch type is Eager
    @Override
    public Instructor findInstructorById(int theId) {
        return entityManager.find(Instructor.class, theId);
    }


    // This will ALSO delete the instructor details object
    // Because of CascadeType.ALL
    @Override
    @Transactional
    public void deleteInstructorById(int theId) {

        // retrieve the instructor
        Instructor tempInstructor = entityManager.find(Instructor.class, theId);

        // delete the instructor
        entityManager.remove(tempInstructor);
    }
}
