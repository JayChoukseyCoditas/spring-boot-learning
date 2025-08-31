package com.example.advancehibernate;

import com.example.advancehibernate.dao.AppDAO;
import com.example.advancehibernate.entity.Course;
import com.example.advancehibernate.entity.Instructor;
import com.example.advancehibernate.entity.InstructorDetail;
import com.example.advancehibernate.entity.Review;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AdvanceHibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdvanceHibernateApplication.class, args);
	}

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO){
        return runner -> {
            // createCourseAndReview(appDAO);

            // retrieveCourseAndReview(appDAO);

            deleteCourseAndReviews(appDAO);
        };
    }

    private void deleteCourseAndReviews(AppDAO appDAO) {

        int theId = 10;

        System.out.println("Deleting course id: " + theId);

        appDAO.deleteCourseById(theId); // will delete course and associate reviews, due to CascadeType.ALL

        System.out.println("Done!");
    }

    private void retrieveCourseAndReview(AppDAO appDAO) {

        // get the course and reviews
        int theId = 10;
        Course tempCourse = appDAO.findCourseAndReviewsByCourseId(theId);

        // print the course
        System.out.println(tempCourse);

        // print the reviews
        System.out.println(tempCourse.getReviews());

        System.out.println("Done!");
    }

    private void createCourseAndReview(AppDAO appDAO) {
        // create a course
        Course tempCourse = new Course("Pacman - How to Score One Million Points");

        // add some reviews
        tempCourse.addReview(new Review("Great course... Loved it!"));
        tempCourse.addReview(new Review("Cool course, job well done."));
        tempCourse.addReview(new Review("What a dumb course, you are an idiot!"));

        // save the course ... and leverage the cascade all
        System.out.println("Saving the course");
        System.out.println(tempCourse);
        System.out.println(tempCourse.getReviews());

        appDAO.save(tempCourse);

        System.out.println("Done!");
    }

    private void deleteCourse(AppDAO appDAO) {

        int theId = 10;

        System.out.println("Deleting course id: " + theId);

        appDAO.deleteCourseById(theId);

        System.out.println("Done!");
    }

    private void updateCourse(AppDAO appDAO) {

        int theId = 10;

        // find the course
        System.out.println("Finding course id: " + theId);
        Course tempCourse = appDAO.findCourseById(theId);

        // update the course
        System.out.println("Updating the course id: " + theId);
        tempCourse.setTitle("Enjoy the Simple Things");

        appDAO.update(tempCourse);

        System.out.println("Done!");
    }

    private void updateInstructor(AppDAO appDAO) {

        int theId = 1;

        // find the instructor
        System.out.println("Finding instructor id: " + theId);
        Instructor tempInstructor = appDAO.findInstructorById(theId);

        // update the instructor
        System.out.println("Updating instructor id: " + theId);
        tempInstructor.setLastName("Soni");

        appDAO.update(tempInstructor);

        System.out.println("Done");
    }

    private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
        int theId = 1;

        // find the instructor
        System.out.println("Finding the instructor id: " + theId);
        Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);

        System.out.println("tempInstructor: " + tempInstructor);
        System.out.println("the associated courses: " + tempInstructor.getCourses());

        System.out.println("Done!");
    }

    private void findCoursesForInstructor(AppDAO appDAO) {
        int theId = 1;

        System.out.println("Finding instructor id: " + theId);

        // find the instructor
        Instructor tempInstructor = appDAO.findInstructorById(theId);
        System.out.println("tempInstructor: " + tempInstructor);

        // find courses for instructor
        // since fetch type for courses is LAZY, this will retrieve the instructor WITHOUT courses
        List<Course> courses = appDAO.findCoursesByInstructorId(theId);

        // associate the object
        tempInstructor.setCourses(courses);

        System.out.println("the associated courses: " + tempInstructor.getCourses());

        System.out.println("Done!");
    }

    private void findInstructorWithCourses(AppDAO appDAO) {
        int theId = 1;

        System.out.println("Finding instructor id: " + theId);

        // Find the instructor
        Instructor tempInstructor = appDAO.findInstructorById(theId);
        System.out.println("tempInstructor: " + tempInstructor);
        System.out.println("the associated courses: " + tempInstructor.getCourses());

        System.out.println("Done!");
    }

    private void createInstructorWithCourses(AppDAO appDAO) {
        // create the instructor
        Instructor tempInstructor = new Instructor(
                "Shubham", "Singh", "shubham@gmail.com");

        // create the instructor detail
        InstructorDetail tempInstructorDetail = new InstructorDetail(
                "http://www.shubham.com/youtube", "Running");


        // associate the objects
        tempInstructor.setInstructorDetail(tempInstructorDetail);

        // create some courses
        Course tempCourse1 = new Course("Air Guitar - The Ultimate Guide");
        Course tempCourse2 = new Course("The Pinball Masterclass");

        // add courses to instructor
        tempInstructor.add(tempCourse1);
        tempInstructor.add(tempCourse2);

        // save the instructor
        //
        // NOTE: this will ALSO save the course
        // because of CascadeType.Persist
        System.out.println("Saving instructor: " + tempInstructor);
        System.out.println("The course: " + tempInstructor.getCourses());
        appDAO.save(tempInstructor);
        System.out.println("Done!");
    }

    private void deleteInstructorDetail(AppDAO appDAO) {

        int theId = 4;
        System.out.println("Deleting instructor detail id: " + theId);

        appDAO.deleteInstructorDetailById(theId);

        System.out.println("Done!");
    }

    private void findInstructorDetail(AppDAO appDAO) {
        // get the instructor detail object
        int theId = 2;
        InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);

        // print the instructor detail
        System.out.println("tempInstructorDetail: " + tempInstructorDetail);

        // print the associated instructor
        System.out.println("the associated instructor: " + tempInstructorDetail.getInstructor());

        System.out.println("Done!");
    }

    private void deleteInstructor(AppDAO appDAO) {
        int theId = 1;
        System.out.println("Deleting instructor: " + theId);

        appDAO.deleteInstructorById(theId);

        System.out.println("Done!");
    }

    private void findInstructor(AppDAO appDAO) {
        int theId = 2;
        System.out.println("Finding instructor id: " + theId);

        Instructor tempInstructor = appDAO.findInstructorById(theId);

        System.out.println("tempInstructor: " + tempInstructor);
        System.out.println("the associated instructor only: " + tempInstructor.getInstructorDetail());
    }


    // Inserts the associated entity first: InstructorDetail then inserts : Instructor
    // Due to relationship of FK Instructor needs to know the id of the InstructorDetail
    private void createInstructor(AppDAO appDAO){
//        // create the instructor
//        Instructor tempInstructor = new Instructor(
//                "Jay", "Chouksey", "jay@gmail.com");
//
//        // create the instructor detail
//        InstructorDetail tempInstructorDetail = new InstructorDetail(
//                "http://www.jay.com/youtube", "Cricket");

        // create the instructor
        Instructor tempInstructor = new Instructor(
                "Harsh", "Lowanshi", "hasrh@gmail.com");

        // create the instructor detail
        InstructorDetail tempInstructorDetail = new InstructorDetail(
                "http://www.hasrh.com/youtube", "Songs");


        // associate the objects
        tempInstructor.setInstructorDetail(tempInstructorDetail);

        // save the instructor
        //
        // NOTE : this will ALSO save the details object
        // because of CascadeType.ALL
        System.out.println("Saving instructor: " + tempInstructor);
        appDAO.save(tempInstructor);

        System.out.println("Done");
    }

}
