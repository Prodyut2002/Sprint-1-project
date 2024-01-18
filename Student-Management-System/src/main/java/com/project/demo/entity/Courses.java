

/*
 * Developed by Supratim Das
 */
package com.project.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

// Entity class representing the Courses entity in the database
@Entity
@Table(name = "Courses")
public class Courses {
    // Primary key for the Courses entity
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_Id")
    private Integer courseId;

    // Name of the course
    private String courseName;

    // Fees associated with the course
    private double courseFees;

    // Duration of the course in months
    private Integer duration;

    // Default constructor
    public Courses() {

    }

    // Parameterized constructor
    public Courses(Integer courseId, String courseName, double courseFees, Integer duration) {
        super();
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseFees = courseFees;
        this.duration = duration;
    }

    // Getter and Setter methods for Courses properties

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public double getCourseFees() {
        return courseFees;
    }

    public void setCourseFees(double courseFees) {
        this.courseFees = courseFees;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    // toString method for debugging and logging

    @Override
    public String toString() {
        return "Courses [courseId=" + courseId + ", courseName=" + courseName + ", courseFees=" + courseFees
                + ", duration=" + duration + "]";
    }

}
