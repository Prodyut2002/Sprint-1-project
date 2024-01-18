
/*
 * Developed by Supratim Das
 */
package com.project.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

// Entity class representing the Student entity in the database
@Entity
@Table(name = "students")
public class Student {
    // Primary key for the Student entity
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "std_Id")
    private Integer stdId;

    // Name of the student
    private String stdName;

    // Email of the student
    private String stdEmail;

    // Contact number of the student
    private Integer stdNumber;

    // Age of the student
    private Integer stdAge;

    // Many-to-One relationship with Courses entity
    @ManyToOne
    @JoinColumn(name = "course_Id")
    private Courses courses;

    // Default constructor
    public Student() {

    }

    // Parameterized constructor
    public Student(Integer stdId, String stdName, String stdEmail, Integer stdNumber, Integer stdAge, Courses courses) {
        super();
        this.stdId = stdId;
        this.stdName = stdName;
        this.stdEmail = stdEmail;
        this.stdNumber = stdNumber;
        this.stdAge = stdAge;
        this.courses = courses;
    }

    // Getter and Setter methods for Student properties

    public Integer getStdId() {
        return stdId;
    }

    public void setStdId(Integer stdId) {
        this.stdId = stdId;
    }

    public String getStdName() {
        return stdName;
    }

    public void setStdName(String stdName) {
        this.stdName = stdName;
    }

    public String getStdEmail() {
        return stdEmail;
    }

    public void setStdEmail(String stdEmail) {
        this.stdEmail = stdEmail;
    }

    public Integer getStdNumber() {
        return stdNumber;
    }

    public void setStdNumber(Integer stdNumber) {
        this.stdNumber = stdNumber;
    }

    public Integer getStdAge() {
        return stdAge;
    }

    public void setStdAge(Integer stdAge) {
        this.stdAge = stdAge;
    }

    public Courses getCourses() {
        return courses;
    }

    public void setCourses(Courses courses) {
        this.courses = courses;
    }

    // toString method for debugging and logging

    @Override
    public String toString() {
        return "Student [stdId=" + stdId + ", stdName=" + stdName + ", stdEmail=" + stdEmail + ", stdNumber="
                + stdNumber + ", stdAge=" + stdAge + ", courses=" + courses + "]";
    }
}
