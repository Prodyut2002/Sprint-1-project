
/*
 * Developed by Supratim Das
 */
package com.project.dao.Impl;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.project.dao.StudentDao;
import com.project.demo.entity.Courses;
import com.project.demo.entity.Student;
import com.project.demo.userexception.CourseException;
import com.project.demo.userexception.StudentException;
import com.project.demo.utils.Hibernate_Util;

// Implementation of StudentDao interface using Hibernate for database operations
public class StudentDaoImpl implements StudentDao {

    // Saves a new student to the database along with the associated course ID
    @Override
    public void saveStudent(Student student, Integer courseId) {
        Session session = Hibernate_Util.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            Courses courses = session.get(Courses.class, courseId);
            student.setCourses(courses);
            session.save(student);

            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw new StudentException("ERROR PLEASE CHECK.... " + e.getMessage(), e);
        } finally {
            session.close();
        }
    }

    // Updates an existing student in the database along with the associated course ID
    @Override
    public void updateStudent(Student student, Integer courseId) {
        Session session = Hibernate_Util.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Courses courses = session.get(Courses.class, courseId);
            student.setCourses(courses);
            session.merge(student);

            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw new StudentException("ERROR PLEASE CHECK.... " + e.getMessage(), e);
        } finally {
            session.close();
        }
    }

    // Retrieves a student from the database based on their ID
    @Override
    public Student getStudentById(Integer id) {
        Session session = Hibernate_Util.getSessionFactory().openSession();
        Transaction tx = null;
        Student student = null;
        try {
            tx = session.beginTransaction();

            student = session.get(Student.class, id);

            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw new StudentException("ERROR PLEASE CHECK.... " + e.getMessage(), e);
        } finally {
            session.close();
        }
        return student;
    }

    // Retrieves a list of all students in the database
    @Override
    @SuppressWarnings("unchecked")
    public List<Student> getAllStudents() {
        Session session = Hibernate_Util.getSessionFactory().openSession();
        Transaction tx = null;
        List<Student> students = null;
        try {
            tx = session.beginTransaction();

            students = session.createQuery("from Student").list();

            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return students;
    }

    // Deletes a student from the database based on their ID and returns the deleted student
    @Override
    public Student deleteStudentById(Integer id) {
        Session session = Hibernate_Util.getSessionFactory().openSession();
        Transaction tx = null;
        Student student = null;
        try {
            tx = session.beginTransaction();

            student = session.get(Student.class, id);

            session.delete(student);

            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw new StudentException("ERROR PLEASE CHECK.... " + e.getMessage(), e);
        } finally {
            session.close();
        }
        return student;
    }
}
