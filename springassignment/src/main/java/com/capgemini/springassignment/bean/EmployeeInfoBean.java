package com.capgemini.springassignment.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name = "employee_info")
public class EmployeeInfoBean {

	@Id
	@Column
	private int empid;
	@Column
	private String name;
	@Column
	private String password;
	@Column
	private int age;
	@Column
	private String designation;
	@Column
	private double salary;
}
