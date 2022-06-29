package com.jdbc.dao;

import java.util.List;

import com.jdbc.entity.Student;

public interface StudentDao {
	
	public Student getStudent(int StudentId);
	
	public List<Student> getAllStudents();
	
	public int insertStudent(Student student);

	public int updateStudent(Student student);

	public int deleteStudent(int StudentId);


}
