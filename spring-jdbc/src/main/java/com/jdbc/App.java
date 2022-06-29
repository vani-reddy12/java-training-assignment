package com.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.jdbc.dao.StudentDao;
import com.jdbc.entity.Student;



public class App {
	public static void main(String[] args) {
	
		ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);

		StudentDao studentDao = context.getBean("studentDao" , StudentDao.class);
		
//		List<Student> students = studentDao.getAllStudents();
//		for (Student s : students) {
//			System.out.println(s);
//		}
		
		
//		Student student = studentDao.getStudent(25);
//		System.out.println(student);

	


		
		Student student = new Student();
		student.setStudentId(2);
		student.setStudentName("Jayshri");
		student.setRollNumber(25);

		int result = studentDao.insertStudent(student);

		/*Student student = new Student();
		student.setStudentId(2);
		student.setStudentName("Jayshri");
		student.setRollNumber(12);
		System.out.println("Student Data"+result+ " Student");*/

		
//		int result = studentDao.deleteStudent(2);
		
	}
}
