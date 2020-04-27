package com.capgemini.springassignment.service;

import com.capgemini.springassignment.bean.EmployeeInfoBean;

public interface EmployeeService {
	EmployeeInfoBean getEmployeeDetails(int id);
	boolean addEmployee(EmployeeInfoBean info);
}
