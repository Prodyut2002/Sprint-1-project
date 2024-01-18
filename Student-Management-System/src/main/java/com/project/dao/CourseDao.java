/*
 * Developed by Supratim Das
 */
package com.project.dao;

import java.util.List;

import com.project.demo.entity.Courses;

// This interface defines methods for interacting with the database to perform CRUD operations on Courses entities
public interface CourseDao {

    // Saves a new course to the database
    void saveCourse(Courses courses);

    // Updates an existing course in the database
    void updateCourse(Courses courses);

    // Retrieves a course from the database based on its ID
    Courses getCourseById(Integer id);

    // Retrieves a list of all courses in the database
    List<Courses> getAllCourse();

    // Deletes a course from the database based on its ID and returns the deleted course
    Courses deleteCourseById(Integer id);

}
