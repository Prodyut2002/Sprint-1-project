
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

// Entity class representing the Admin entity in the database
@Entity
@Table(name = "admin")
public class Admin {
    // Primary key for the Admin entity
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Ad_Id")
    private Integer adminId;

    // Name of the Admin
    private String adName;

    // Password of the Admin
    private String adPassword;

    // One-to-Many relationship with Courses entity
    @OneToMany
    private List<Courses> courses;

    // Default constructor
    public Admin() {

    }

    // Parameterized constructor
    public Admin(Integer adminId, String adName, String adPassword, List<Courses> courses) {
        super();
        this.adminId = adminId;
        this.adName = adName;
        this.adPassword = adPassword;
        this.courses = courses;
    }

    // Getter and Setter methods for Admin properties

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdName() {
        return adName;
    }

    public void setAdName(String adName) {
        this.adName = adName;
    }

    public String getAdPassword() {
        return adPassword;
    }

    public void setAdPassword(String adPassword) {
        this.adPassword = adPassword;
    }

    public List<Courses> getCourses() {
        return courses;
    }

    public void setCourses(List<Courses> courses) {
        this.courses = courses;
    }

    // toString method for debugging and logging

    @Override
    public String toString() {
        return "Admin [adminId=" + adminId + ", adName=" + adName + ", adPassword=" + adPassword + ", courses="
                + courses + "]";
    }

}
