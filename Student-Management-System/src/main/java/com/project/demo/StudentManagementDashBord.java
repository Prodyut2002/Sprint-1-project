/*
 * Developed by Supratim Das
 */
package com.project.demo;

import java.util.List;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.project.dao.CourseDao;
import com.project.dao.StudentDao;
import com.project.dao.TeacherDao;
import com.project.dao.Impl.CourseDaoImpl;
import com.project.dao.Impl.StudentDaoImpl;
import com.project.dao.Impl.TeacherDaoImpl;
import com.project.demo.entity.Admin;
import com.project.demo.entity.Courses;
import com.project.demo.entity.Student;
import com.project.demo.entity.Teacher;
import com.project.demo.utils.Hibernate_Util;

public class StudentManagementDashBord {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int option = 0, optionUser = 0, optionProduct = 0, optionCart = 0, optionOrder = 0;

		String adName = "Prodyut Choudhury";
		String adPassword = "prodyut123";
		boolean login = false;

		do {

			System.out.println("Welcome to Student Management DashBord\n=====================================");
			if (!login) {
				System.out.println("Enter Admin Name");
				String adName1 = s.nextLine();
				System.out.println("Enter admin password");
				String adpassword1 = s.nextLine();
				if (adName1.equals(adName) && adpassword1.equals(adPassword)) {
					login = true;
					System.out.println("Admin Login Success");
				} else {
					System.out.println("Incorrect Password or Name");
				}
			} else {
				System.out.println(
						"1. Select 1 for Admin\n2. Select 2 for Courses\n3. Select 3 for Teacher\n4. Select 4 for Students\n5. Select 5 for Exit");
				option = s.nextInt();
				switch (option) {
				case 1:

					do {
						System.out.println("1. Select 1 Add User\n2. Select 2 Delete User\n3. Select 3 Update User"
								+ "\n4. Select 4 to Show All User\n5. Select 5 to Show Any User\n6. Select 6 for Exit");
						optionUser = s.nextInt();
						switch (optionUser) {
						case 1:
							System.out.println("Add User...");

							break;
						case 2:
							System.out.println("Delete User...");
							break;
						case 3:
							System.out.println("Update User...");
							break;
						case 4:
							System.out.println("Show All User...");
							break;
						case 5:
							System.out.println("Show Any User...");
							break;
						case 6:
							System.out.println("Exited from User Section Successfully...");
							break;
						}
					} while (optionUser != 6);
					break;
				case 2:
					do {
						System.out.println(
								"1. Select 1 Add Courses\n2. Select 2 Delete Courses\n3. Select 3 Update Courses"
										+ "\n4. Select 4 to Show All Courses\n5. Select 5 to Show Any Courses\n6. Select 6 for Exit");
						optionProduct = s.nextInt();
						switch (optionProduct) {
						case 1:
							//logic for save courses
							CourseDao courseDao = new CourseDaoImpl();

							Courses courses = new Courses();
							Scanner sc = new Scanner(System.in);
							System.out.println("Enter course name");
							String c1Name = sc.next();
							courses.setCourseName(c1Name);

							System.out.println("Enter course fees");
							double cFees = sc.nextDouble();
							courses.setCourseFees(cFees);

							System.out.println("Enter course duration");
							Integer cDuration = sc.nextInt();
							courses.setDuration(cDuration);

							courseDao.saveCourse(courses);

							break;
						case 2:
							//logic for delete courses
							System.out.println("Delete Courses...");
							CourseDao courseDao1 = new CourseDaoImpl();
							// Courses courses1 = new Courses();
							Scanner sc1 = new Scanner(System.in);
							System.out.println("Enter course id");
							Integer cId = sc1.nextInt();
							courseDao1.deleteCourseById(cId);
							break;
						case 3:
							//logic for update courses
							System.out.println("Update Courses...");
							CourseDao courseDao2 = new CourseDaoImpl();

							Courses courses2 = new Courses();
							Scanner sc2 = new Scanner(System.in);
							System.out.println("Enter course id");
							Integer cId2 = sc2.nextInt();
							courses2.setCourseId(cId2);

							System.out.println("Enter course name");
							String c1Name2 = sc2.next();
							courses2.setCourseName(c1Name2);

							System.out.println("Enter course fees");
							double cFees2 = sc2.nextDouble();
							courses2.setCourseFees(cFees2);

							System.out.println("Enter course duration");
							Integer cDuration2 = sc2.nextInt();
							courses2.setDuration(cDuration2);

							courseDao2.updateCourse(courses2);
							break;
						case 4:
							//logic for show all courses
							System.out.println("Show All Courses...");
							CourseDao courseDao3 = new CourseDaoImpl();
							// Courses courses3 = new Courses();
							List<Courses> list = courseDao3.getAllCourse();
							list.forEach(course -> System.out.println(course));
							break;
						case 5:
							//logic for any courses
							System.out.println("Show Course by id...");
							CourseDao courseDao4 = new CourseDaoImpl();
							// Courses courses4 = new Courses();
							Scanner sc4 = new Scanner(System.in);
							System.out.println("Enter course id");
							Integer cId4 = sc4.nextInt();
							Courses courseById = courseDao4.getCourseById(cId4);
							System.out.println(courseById);
							break;
						case 6:
							System.out.println("Exited from Courses Section Successfully...");
							break;
						}
					} while (optionProduct != 6);
					break;
				case 3:
					do {
						System.out.println(
								"1. Select 1 Add Teacher\n2. Select 2 Delete Teacher\n3. Select 3 Update Teacher"
										+ "\n4. Select 4 to Show All Teacher\n5. Select 5 to Show Any Teacher\n6. Select 6 for Exit");
						optionCart = s.nextInt();
						switch (optionCart) {
						case 1:
							System.out.println("Add Teacher...");
							TeacherDao teacherDao = new TeacherDaoImpl();
							System.out.println("Enter Course Id");
							Scanner sc = new Scanner(System.in);
							Integer cId = sc.nextInt();

							Teacher teacher = new Teacher();

							System.out.println("Enter teacher name");
							String tName = sc.next();
							teacher.setTeachName(tName);

							System.out.println("Enter teacher email");
							String email = sc.next();
							teacher.setTeachEmail(email);

							System.out.println("Enter teacher phone number");
							Integer num = sc.nextInt();
							teacher.setNumber(num);

							teacherDao.saveTeacher(teacher, cId);
							break;
						case 2:
							System.out.println("Delete Teacher...");
							TeacherDao teacherDao1 = new TeacherDaoImpl();
							Scanner sc1 = new Scanner(System.in);
							System.out.println("Enter teacher id");
							Integer tId = sc1.nextInt();
							teacherDao1.deleteTeacherById(tId);
							break;
						case 3:
							System.out.println("Update Teacher...");
							TeacherDao teacherDao2 = new TeacherDaoImpl();
							Scanner sc2 = new Scanner(System.in);
							System.out.println("Enter Course Id");
							Integer c1Id = sc2.nextInt();

							Teacher teacher2 = new Teacher();

							System.out.println("Enter teacher id");
							Integer tId2 = sc2.nextInt();
							teacher2.setTeachId(tId2);

							System.out.println("Enter teacher name");
							String tName2 = sc2.next();
							teacher2.setTeachName(tName2);

							System.out.println("Enter teacher email");
							String email2 = sc2.next();
							teacher2.setTeachEmail(email2);

							System.out.println("Enter teacher phone number");
							Integer num2 = sc2.nextInt();
							teacher2.setNumber(num2);

							teacherDao2.updateTeacher(teacher2, c1Id);
							break;

						case 4:
							System.out.println("Show All Teacher...");
							TeacherDao teacherDao3 = new TeacherDaoImpl();
							List<Teacher> teacherList = teacherDao3.getAllTeachers();
							teacherList.forEach(teach -> System.out.println(teach));
							break;
						case 5:
							System.out.println("Show Any Teacher...");
							TeacherDao teacherDao4 = new TeacherDaoImpl();
							Scanner sc4 = new Scanner(System.in);
							System.out.println("Enter teacher id");
							Integer tId4 = sc4.nextInt();
							Teacher teacherById = teacherDao4.getTeacherById(tId4);
							System.out.println(teacherById);
							break;
						case 6:
							System.out.println("Exited from Teacher Section Successfully...");
							break;
						}
					} while (optionCart != 6);
					break;
				case 4:
					do {
						System.out.println(
								"1. Select 1 Add Student\n2. Select 2 Delete Student\n3. Select 3 Update Student"
										+ "\n4. Select 4 to Show All Student\n5. Select 5 to Show Any Student\n6. Select 6 for Exit");
						optionOrder = s.nextInt();
						switch (optionOrder) {
						case 1:
							System.out.println("Add Students...");
							StudentDao studentDao = new StudentDaoImpl();
							System.out.println("Enter Course Id");
							Scanner sc = new Scanner(System.in);
							Integer cId = sc.nextInt();

							Student student = new Student();

							System.out.println("Enter student name");
							String sName = sc.next();
							student.setStdName(sName);

							System.out.println("Enter student age");
							int sAge = sc.nextInt();
							student.setStdAge(sAge);

							System.out.println("Enter student email");
							String email = sc.next();
							student.setStdEmail(email);

							System.out.println("Enter student ph number");
							Integer num = sc.nextInt();
							student.setStdNumber(num);

							studentDao.saveStudent(student, cId);
							break;
						case 2:
							System.out.println("Delete Students...");
							StudentDao studentDao1 = new StudentDaoImpl();
							Scanner sc1 = new Scanner(System.in);
							System.out.println("Enter student id");
							Integer sId = sc1.nextInt();
							studentDao1.deleteStudentById(sId);
							break;
						case 3:
							System.out.println("Update Students...");
							StudentDao studentDao2 = new StudentDaoImpl();
							Scanner sc2 = new Scanner(System.in);
							System.out.println("Enter Course Id");

							Integer c1Id = sc2.nextInt();

							Student student2 = new Student();
							System.out.println("Enter student id");
							Integer sId2 = sc2.nextInt();
							student2.setStdId(sId2);

							System.out.println("Enter student name");
							String sName2 = sc2.next();
							student2.setStdName(sName2);

							System.out.println("Enter student age");
							int sAge2 = sc2.nextInt();
							student2.setStdAge(sAge2);

							System.out.println("Enter student Email");
							String email1 = sc2.next();
							student2.setStdEmail(email1);

							System.out.println("Enter student ph number");
							Integer num2 = sc2.nextInt();
							student2.setStdNumber(num2);

							studentDao2.updateStudent(student2, c1Id);
							break;
						case 4:
							System.out.println("Show All Students...");
							StudentDao studentDao3 = new StudentDaoImpl();
							List<Student> studentList = studentDao3.getAllStudents();
							studentList.forEach(stud -> System.out.println(stud));
							break;
						case 5:
							System.out.println("Show Any Students...");
							StudentDao studentDao4 = new StudentDaoImpl();
							Scanner sc4 = new Scanner(System.in);
							System.out.println("Enter student id");
							Integer sId4 = sc4.nextInt();
							Student studentById = studentDao4.getStudentById(sId4);
							System.out.println(studentById);
							break;
						case 6:
							System.out.println("Exited from Student Section Successfully...");
							break;
						}
					} while (optionOrder != 6);
					break;
				case 5:
					System.out.println("Case 5 Executed...");
					System.out.println("Exited Successfully...");
					s.close();
					System.exit(0);
					break;
				}
			}

		} while (option != 5);

	}
}
