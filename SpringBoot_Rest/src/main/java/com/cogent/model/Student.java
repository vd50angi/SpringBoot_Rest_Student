package com.cogent.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity

@Table(name="student_rest")
public class Student {
	@Id
	private int studentcode;
	public int getStudentcode() {
		return studentcode;
	}
	public void setStudentcode(int studentcode) {
		this.studentcode = studentcode;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	private String studentname;
	private double score;

}



















/*@Table(name="StudentDetails")


public class Student {
@Id


private int student_id;
private String student_name;
private int score;

	
	
}*/
