package com.capgemini.springassignment.dao;

import java.util.List;

import com.capgemini.springassignment.bean.EmployeeInfoBean;


public interface EmployeeDAO {
	EmployeeInfoBean getEmployeeDetails(int empid);
	boolean addEmployee(EmployeeInfoBean info);
	List<EmployeeInfoBean> getAllEmployeeRecord();
	boolean updateEmployeeInfo(EmployeeInfoBean ref);
	boolean deleteEmployeeInfo(int empid);
}

