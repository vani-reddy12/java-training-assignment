package com.zensar.springbootdemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.springboot.dto.StudentDto;
import com.zensar.springbootdemo.entity.Student;
import com.zensar.springbootdemo.service.StudentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping(value = "/student-api")
public class StudentController {
	@Autowired
	private StudentService studentService;

	public StudentController() {

	}
	/*
	 * @ExceptionHandler(value = StudentAlreadyExistsException.class)
	 * 
	 * @ResponseStatus(HttpStatus.CONFLICT) public ErrorResponse
	 * handleStudentAlreadyExistsException(StudentAlreadyExistsException ex) {
	 * return new ErrorResponse(HttpStatus.CONFLICT.value(), ex.getMessage()); }
	 */

	/*
	 * @ExceptionHandler(value = NoSuchStudentExistsException.class)
	 * 
	 * @ResponseStatus(HttpStatus.NOT_FOUND) public ErrorResponse
	 * handleNoSuchStudentExistsException(NoSuchStudentExistsException ex) { return
	 * new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage()); }
	 */

	// http://localhost:8080/students/1001 GET
	// @RequestMapping(value = "/students/{studentId}",method=RequestMethod.GET)
	@Operation(summary = "This is to fetch record by studentId")
	@GetMapping(value = "/students/{studentId}")
	public ResponseEntity<StudentDto> getStudent(@PathVariable("studentId") int studentId) {
		return new ResponseEntity<StudentDto>(studentService.getStudent(studentId), HttpStatus.OK);
		// return studentService.getStudent(studentId);
	}

	@GetMapping(value = "/mystudents/{studentId}")
	public ResponseEntity<StudentDto> getStudents(@PathVariable("studentId") int studentId) {
		return new ResponseEntity<StudentDto>(studentService.getStudent(studentId), HttpStatus.OK);
		// return studentService.getStudent(studentId);
	}

	// http://localhost:8080/students
	// @RequestMapping(value = { "/students", "/listOfStudents"
	// },method=RequestMethod.GET)
	@Operation(summary = "This is to get all the student records from database")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Fetched all records from database", content = {
					@Content(mediaType = "application/json"), @Content(mediaType = "application/xml") }) })
	@GetMapping(value = { "/students", "/listOfStudents" })
	public ResponseEntity<List<StudentDto>> getAllStudents(
			@RequestParam(value = "pageNumber", required = false, defaultValue = "0") int pageNumber,
			@RequestParam(value = "pageSize", required = false, defaultValue = "5") int pageSize,
			@RequestParam(value = "sortBy", required = false, defaultValue = "studentName") String sortBy,
			@RequestParam(value = "dir", required = false, defaultValue = "DESC") Direction dir) {

		return new ResponseEntity<List<StudentDto>>(studentService.getAllStudents(pageNumber, pageSize, sortBy, dir),
				HttpStatus.OK);
	}

	// http://localhost:8080/students POST
	// @RequestMapping(value = "/students",method=RequestMethod.POST)
	@Operation(summary = "to insert the record into database")
	@PostMapping(value = "/students")
	public ResponseEntity<StudentDto> insertStudent(@RequestBody StudentDto studentDto) {

		return new ResponseEntity<StudentDto>(studentService.insertStudent(studentDto), HttpStatus.CREATED);

		// System.out.println("HI");
	}

	// @RequestMapping(value="/students/{studentId}",method=RequestMethod.PUT)
	@Operation(summary = " This is to update the record by studentId")
	@PutMapping(value = "/students/{studentId}")
	public ResponseEntity<String> updateStudent(@PathVariable("studentId") int studentId,
			@RequestBody StudentDto studentDto) {
		studentService.updateStudent(studentId, studentDto);
		return new ResponseEntity<String>("Student updated succesfully", HttpStatus.OK);

	}

	// http://localhost:8080/students/1001 -> Delete
	// @RequestMapping(value="/students/{studentId}",method=RequestMethod.DELETE)
	@Operation(summary = "This is to delete record by studentId from database")
	@DeleteMapping("/students/{studentId}")
	public ResponseEntity<String> delete(@PathVariable("studentId") int studentId) {
		studentService.deleteStudent(studentId);
		return new ResponseEntity<String>("Student deleted succesfully", HttpStatus.OK);
	}

	@Operation(summary = "This is to fetch record by studentName")
	@GetMapping(value = "/students/name/{studentName}")
	public ResponseEntity<List<StudentDto>> getByStudentName(@PathVariable("studentName") String studentName) {
		return new ResponseEntity<List<StudentDto>>(studentService.getByStudentName(studentName), HttpStatus.OK);
	}

	@Operation(summary = "This is to fetch record by studentName and Age")
	@GetMapping(value = "/students/{studentName}/{studentAge}")
	public ResponseEntity<List<StudentDto>> findByStudentNameAndStudentAge(
			@PathVariable("studentName") String studentName, @PathVariable("studentAge") int age) {
		return new ResponseEntity<List<StudentDto>>(studentService.findByStudentNameAndStudentAge(studentName, age),
				HttpStatus.OK);
	}

}
