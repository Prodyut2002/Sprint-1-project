
/*
 * Developed by Supratim Das
 */
package com.project.dao;

import java.util.List;

import com.project.demo.entity.Student;

// This interface defines methods for interacting with the database to perform CRUD operations on Student entities
public interface StudentDao {

    // Saves a new student to the database along with the associated course ID
    void saveStudent(Student student, Integer courseId);

    // Updates an existing student in the database along with the associated course ID
    void updateStudent(Student student, Integer courseId);

    // Retrieves a student from the database based on their ID
    Student getStudentById(Integer id);

    // Retrieves a list of all students in the database
    List<Student> getAllStudents();

    // Deletes a student from the database based on their ID and returns the deleted student
    Student deleteStudentById(Integer id);

}
