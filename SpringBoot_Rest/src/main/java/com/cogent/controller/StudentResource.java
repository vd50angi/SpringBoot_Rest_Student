package com.cogent.controller;
import java.net.URI;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cogent.model.Student;
import com.cogent.model.StudentRepository;


//{"studentcode":1001,"studentname":"Angie","score":90}


//@Controller
@RestController



public class StudentResource {
	
	/*@GetMapping
	@PostMapping
	@PutMapping
	@DeleteMapping*/

	@Autowired
	private StudentRepository studentRepository;
//http://localhost:8080/students
	public void insertStudent(Student s)
	{
		studentRepository.save(s);
	}
	

	public void deleteData(int studentid)
	{
		studentRepository.deleteById(studentid);
	}
	public void updataData(int studentid)
	{
		Optional<Student> s=studentRepository.findById(studentid);
		if(s.isPresent())
		{
			Student s1=s.get();
			s1.setStudentname("Angie");
			studentRepository.save(s1);
			
		}
		
	}
	public void findAllData()
	{
		List<Student > studentlist=studentRepository.findAll();
	}
	
	//http://localhost:8080/
	@GetMapping("/")
	public List<Student> retrieveAllStudents() {
		List<Student> slist=studentRepository.findAll();
		System.out.println("List is "+slist);
		for(Student s:slist)
		{
			System.out.println("data is "+s.getStudentname());
		}
		
		System.out.println("Coming here");
		return studentRepository.findAll();
		
	}
//http://localhost:8080/students/10132
	@GetMapping("/students/{id}")
	public ResponseEntity<Student> retrieveStudent(@PathVariable int id)
			throws ResourceNotFoundException {

	    Student student1 = studentRepository.findById(id)
	            .orElseThrow(() -> 
	            new ResourceNotFoundException
	            ("Student not found for this id :: " + id));
	          return ResponseEntity.ok().body(student1);
	          //your application is working properly and it is return proper employee object
	      	}
	/*@GetMapping("/studentname/{name}")
		public Student getStudentByName(@PathVariable String name)
	{
			Student s=studentRepository.getStudentByName(name);
			return s;
			
	}
	*/
	@DeleteMapping("/students/{id}")
	public void deleteStudent(@PathVariable int id) {
		studentRepository.deleteById(id);
	}

	@PostMapping("/students")
	public ResponseEntity<Object>
	createStudent(@RequestBody Student student) {
		Student savedStudent = studentRepository.save(student);
//http://localhost:8080/sstudent/102
		URI location = 
			ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedStudent.getStudentcode()).toUri();
//it is changing the uri from current location to location http://localhost:8080/students/1004
		return ResponseEntity.created(location).build();

	}
	//http://localhost:8080/students/1003
	
	@PutMapping("/students/{id}")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable int id)
	throws ResourceNotFoundException{

	       Student student1 = studentRepository.findById(id)
	    	        .orElseThrow(() -> 
	    	        new ResourceNotFoundException("Student not found for this id :: " + id));


		student1.setStudentcode(id);
		student1.setStudentname(student.getStudentname());
	Student studentupdated=	studentRepository.save(student);

		return ResponseEntity.ok(studentupdated);
	}
}
	
	
	
	
	


