package com.example.advancehibernate;

import com.example.advancehibernate.dao.AppDAO;
import com.example.advancehibernate.entity.Instructor;
import com.example.advancehibernate.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AdvancehibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdvancehibernateApplication.class, args);
	}

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO){
        return runner -> {
            // createInstructor(appDAO);
            // findInstructor(appDAO);
            // deleteInstructor(appDAO);
        };
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
