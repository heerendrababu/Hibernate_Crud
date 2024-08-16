package com.shivin.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student 
{
  @Id
  private int sno;
  private String sname;
  private String subject;
  
  
// hibernate and spring will use parameterless constructor or else it will show error when we get the values of table.
 // hibernate will use empty object/constructor/table for getters and setters
public Student() {
	super();
	// TODO Auto-generated constructor stub
}
public Student(int sno, String sname, String subject) {
	super();
	this.sno = sno;
	this.sname = sname;
	this.subject = subject;
}
public int getSno() {
	return sno;
}
public void setSno(int sno) {
	this.sno = sno;
}
public String getSname() {
	return sname;
}
public void setSname(String sname) {
	this.sname = sname;
}
public String getSubject() {
	return subject;
}
public void setSubject(String subject) {
	this.subject = subject;
}
  
  
}
