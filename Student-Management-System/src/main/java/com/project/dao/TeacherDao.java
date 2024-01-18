

/*
 * Developed by Supratim Das
 */
package com.project.dao;

import java.util.List;

import com.project.demo.entity.Teacher;

// This interface defines methods for interacting with the database to perform CRUD operations on Teacher entities
public interface TeacherDao {

    // Saves a new teacher to the database along with the associated course ID
    void saveTeacher(Teacher teacher, Integer courseId);

    // Updates an existing teacher in the database along with the associated course ID
    void updateTeacher(Teacher teacher, Integer courseId);

    // Retrieves a teacher from the database based on their ID
    Teacher getTeacherById(Integer id);

    // Retrieves a list of all teachers in the database
    List<Teacher> getAllTeachers();

    // Deletes a teacher from the database based on their ID and returns the deleted teacher
    Teacher deleteTeacherById(Integer id);

}
