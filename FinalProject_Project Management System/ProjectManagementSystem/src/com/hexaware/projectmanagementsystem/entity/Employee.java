package com.hexaware.projectmanagementsystem.entity;

public class Employee {
	private int employeeId;
	private String name;
	private String designation;
	private String gender;
	private int salary;
	private int projectId;
	public Employee() {
		super();
	}
	public Employee(String name, String designation, String gender, int salary, int projectId) {
		super();
		this.name = name;
		this.designation = designation;
		this.gender = gender;
		this.salary = salary;
		this.projectId = projectId;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	
	

}
