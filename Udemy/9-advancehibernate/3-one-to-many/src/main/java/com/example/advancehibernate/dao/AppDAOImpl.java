package com.example.advancehibernate.dao;

import com.example.advancehibernate.entity.Course;
import com.example.advancehibernate.entity.Instructor;
import com.example.advancehibernate.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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

        // get the courses
        List<Course> courses  = tempInstructor.getCourses();

        // break the association of all courses for instructor
        for(Course tempCourse : courses){
            tempCourse.setInstructor(null); // remove the instructor from the course
        }
        // if we don't remove instructor from courses ... then ConstraintViolationException will come

        // delete the instructor
        // we only delete the instructor not the associated courses based on our cascade type
        entityManager.remove(tempInstructor);
    }

    // This will ALSO retrieve the instructor object
    // Because of default behaviour of @OneToOne
    @Override
    public InstructorDetail findInstructorDetailById(int theId) {
        return entityManager.find(InstructorDetail.class, theId);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int theId) {

        // retrieve instructor detail
        InstructorDetail tempInstructorDetail = entityManager.find(InstructorDetail.class, theId);

        // remove the associated object reference
        // break bidirectional link
        tempInstructorDetail.getInstructor().setInstructorDetail(null);

        // delete the instructor detail
        entityManager.remove(tempInstructorDetail);
    }

    @Override
    public List<Course> findCoursesByInstructorId(int theId) {

        // create query
        TypedQuery<Course> query = entityManager.createQuery(
                "FROM Course WHERE instructor.id = :data", Course.class);

        query.setParameter("data", theId);

        // execute query
        List<Course> courses = query.getResultList();

        return courses;
    }

    // Even with instructor @OneToMany - FetchType.LAZY
    // The code will still retrieve Instructor and Courses
    // The JOIN FETCH is similar to EAGER loading
    @Override
    public Instructor findInstructorByIdJoinFetch(int theId) {

        // create query
        TypedQuery<Instructor> query = entityManager.createQuery(
                "SELECT i from Instructor i "
                + "JOIN FETCH i.courses "
                + "JOIN FETCH i.instructorDetail " // Be sure to add whitespace before double-quotes
                + "WHERE i.id = :data", Instructor.class
        );

        query.setParameter("data", theId);

        // execute query
        Instructor instructor = query.getSingleResult();

        return instructor;
    }

    @Override
    @Transactional
    public void update(Instructor tempInstructor) {
        entityManager.merge(tempInstructor); // merge will update the existing entity
    }

    @Override
    @Transactional
    public void update(Course tempCourse) {
        entityManager.merge(tempCourse); // merge will update the existing entity
    }

    @Override
    public Course findCourseById(int theId) {
        return entityManager.find(Course.class, theId);
    }

    @Override
    @Transactional
    public void deleteCourseById(int theId) {

        // retrieve the course
        Course tempCourse = entityManager.find(Course.class, theId);

        // delete the course
        entityManager.remove(tempCourse);
    }


}
