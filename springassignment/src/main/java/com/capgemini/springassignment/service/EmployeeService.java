package com.capgemini.springassignment.service;

import java.util.List;

import com.capgemini.springassignment.bean.EmployeeInfoBean;

public interface EmployeeService {
	EmployeeInfoBean getEmployeeDetails(int empid);
	boolean addEmployee(EmployeeInfoBean info);
	List<EmployeeInfoBean> getAllEmployeeRecord();
	boolean updateEmployeeInfo(EmployeeInfoBean ref);
	boolean deleteEmployeeInfo(int empid);
}
