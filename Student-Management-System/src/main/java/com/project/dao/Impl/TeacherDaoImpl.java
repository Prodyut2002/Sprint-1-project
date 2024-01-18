
/*
 * Developed by Supratim Das
 */
package com.project.dao.Impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.project.dao.TeacherDao;
import com.project.demo.entity.Courses;
import com.project.demo.entity.Teacher;
import com.project.demo.userexception.StudentException;
import com.project.demo.userexception.TeacherException;
import com.project.demo.utils.Hibernate_Util;

// Implementation of TeacherDao interface using Hibernate for database operations
public class TeacherDaoImpl implements TeacherDao {

    // Saves a new teacher to the database along with the associated course ID
    @Override
    public void saveTeacher(Teacher teacher, Integer courseId) {
        Session session = Hibernate_Util.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            Courses courses = session.get(Courses.class, courseId);
            teacher.setCourses(courses);
            session.save(teacher);

            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw new TeacherException("ERROR PLEASE CHECK.... " + e.getMessage(), e);
        } finally {
            session.close();
        }
    }

    // Updates an existing teacher in the database along with the associated course ID
    @Override
    public void updateTeacher(Teacher teacher, Integer courseId) {
        Session session = Hibernate_Util.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Courses courses = session.get(Courses.class, courseId);
            teacher.setCourses(courses);
            session.merge(teacher);

            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw new TeacherException("ERROR PLEASE CHECK.... " + e.getMessage(), e);
        } finally {
            session.close();
        }
    }

    // Retrieves a teacher from the database based on their ID
    @Override
    public Teacher getTeacherById(Integer id) {
        Session session = Hibernate_Util.getSessionFactory().openSession();
        Transaction tx = null;
        Teacher teacher = null;
        try {
            tx = session.beginTransaction();

            teacher = session.get(Teacher.class, id);

            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw new TeacherException("ERROR PLEASE CHECK.... " + e.getMessage(), e);
        } finally {
            session.close();
        }
        return teacher;
    }

    // Retrieves a list of all teachers in the database
    @Override
    @SuppressWarnings("unchecked")
    public List<Teacher> getAllTeachers() {
        Session session = Hibernate_Util.getSessionFactory().openSession();
        Transaction tx = null;
        List<Teacher> teachers = null;
        try {
            tx = session.beginTransaction();

            teachers = session.createQuery("from Teacher").list();

            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return teachers;
    }

    // Deletes a teacher from the database based on their ID and returns the deleted teacher
    @Override
    public Teacher deleteTeacherById(Integer id) {
        Session session = Hibernate_Util.getSessionFactory().openSession();
        Transaction tx = null;
        Teacher teacher = null;
        try {
            tx = session.beginTransaction();

            teacher = session.get(Teacher.class, id);

            session.delete(teacher);

            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw new TeacherException("ERROR PLEASE CHECK.... " + e.getMessage(), e);
        } finally {
            session.close();
        }
        return teacher;
    }
}
