package com.example.hibernate_demo;

import com.example.hibernate_demo.dao.StudentDAO;
import com.example.hibernate_demo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class HibernateDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateDemoApplication.class, args);
	}

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
            // createStudent(studentDAO);
            createMultipleStudent(studentDAO);
            // readStudent(studentDAO);
            // queryForStudents(studentDAO);
            // queryForStudentsByLastName(studentDAO);
            // updateStudent(studentDAO);
            // deleteStudent(studentDAO);
            // deleteAllStudents(studentDAO);
        };
    }

    private void deleteAllStudents(StudentDAO studentDAO) {

        System.out.println("Deleting all students");
        int numRowsDeleted = studentDAO.deleteAll();
        System.out.println("Deleted row count: " + numRowsDeleted);
    }

    private void deleteStudent(StudentDAO studentDAO) {
        // delete the student
        int studentId = 6;

        System.out.println("Deleting student id: " + studentId);

        studentDAO.delete(studentId);
    }

    private void updateStudent(StudentDAO studentDAO) {
        // retrieve student based on the id: primary key
        int studentId = 3;
        System.out.println("Getting student with id: " + studentId);
        Student myStudent = studentDAO.findById(studentId);

        // change last name to "Lovanshi"
        System.out.println("Updating the student with id: " + studentId);
        myStudent.setLastName("Lovanshi");

        // update the student
        studentDAO.update(myStudent);

        // display the updated student
        System.out.println("Updated student: " + myStudent);
    }

    private void queryForStudentsByLastName(StudentDAO studentDAO) {
        // get a list of students
        List<Student> theStudents = studentDAO.findByLastName("Chouksey");

        // display list of students
        for (Student tempStudent : theStudents){
            System.out.println(tempStudent);
        }
    }

    private void queryForStudents(StudentDAO studentDAO) {
        // get a list of students
        List<Student> theStudents = studentDAO.findAll();

        // display list of students
        for (Student tempStudent : theStudents){
            System.out.println(tempStudent);
        }
    }

    private void readStudent(StudentDAO studentDAO) {
        // create a student object
        System.out.println("Creating new student object ... ");
        Student tempStudent = new Student("Shantanu", "Rawat", "shantanu@gmail.com");

        // save the student
        studentDAO.save(tempStudent);

        // display id of the saved student
        int id = tempStudent.getId();
        System.out.println("Saved student. Generated id: " + id);

        // retrieve student based on the id: primary key
        Student student = studentDAO.findById(id);

        // display student
        System.out.println("Found the student: " + student);
    }

    private void createStudent(StudentDAO studentDAO) {
        // create the student object
        System.out.println("Creating new student object ...");

        // save the student object
        Student tempStudent = new Student("Jay", "Chouksey", "jay@gmail.com");
        studentDAO.save(tempStudent);

        // display id of the saved student
        System.out.println("Saved student. Generated id: " + tempStudent.getId());
    }

    private void createMultipleStudent(StudentDAO studentDAO) {
        System.out.println("Creating multiple students object ...");

        Student shubham = new Student("Shuham", "Singh", "shubham@gmail.com");
        Student harsh = new Student("Harsh", "Lowanshi", "harsh@gmail.com");
        Student mukul = new Student("Mukul", "Patel", "mukul@gmail.com");
        Student deepak = new Student("Deepak", "Goswami", "deepak@gmail.com");

        studentDAO.save(shubham);
        System.out.println("Saved student. Generated id: " + shubham.getId());

        studentDAO.save(harsh);
        System.out.println("Saved student. Generated id: " + harsh.getId());

        studentDAO.save(mukul);
        System.out.println("Saved student. Generated id: " + mukul.getId());

        studentDAO.save(deepak);
        System.out.println("Saved student. Generated id: " + deepak.getId());

    }

}
