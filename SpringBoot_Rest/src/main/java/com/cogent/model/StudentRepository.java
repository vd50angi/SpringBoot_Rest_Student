package com.cogent.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
	
	/*	@Query
	(value="select s from Student s where s.name=:name")
	
	public Student getStudentByName(@Param("name")String name);
	//public Student findByName(@Param("name") String n);
*/
}
	
	


