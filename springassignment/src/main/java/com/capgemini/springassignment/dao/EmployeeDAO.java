package com.capgemini.springassignment.dao;

import com.capgemini.springassignment.bean.EmployeeInfoBean;

public interface EmployeeDAO {
	EmployeeInfoBean getEmployeeDetails(int id);
	boolean addEmployee(EmployeeInfoBean info);
}
