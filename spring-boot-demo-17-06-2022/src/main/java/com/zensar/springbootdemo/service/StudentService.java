package com.zensar.springbootdemo.service;

import java.util.List;

import org.springframework.data.domain.Sort.Direction;

import com.zensar.springboot.dto.StudentDto;
import com.zensar.springbootdemo.entity.Student;

public interface StudentService {

	public StudentDto getStudent(int studentId);

	public List<StudentDto> getAllStudents(int pagNumber,int pageSize,String sortBy,Direction dir);

	public StudentDto insertStudent(StudentDto student);

	public void updateStudent(int studentId, StudentDto student);

	public void deleteStudent(int studentId);
	
	List<StudentDto>getByStudentName(String studentName);

	List<StudentDto>findByStudentNameAndStudentAge(String studentName,int age);

}