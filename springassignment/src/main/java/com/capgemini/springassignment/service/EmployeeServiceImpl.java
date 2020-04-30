package com.capgemini.springassignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.springassignment.bean.EmployeeInfoBean;
import com.capgemini.springassignment.dao.EmployeeDAO;
@Service
public class EmployeeServiceImpl implements EmployeeService{
@Autowired
	private EmployeeDAO dao;
	@Override
	public EmployeeInfoBean getEmployeeDetails(int empid) {
		return dao.getEmployeeDetails(empid);
	}

	@Override
	public boolean addEmployee(EmployeeInfoBean info) {
		// TODO Auto-generated method stub
		return dao.addEmployee(info);
		}

	@Override
	public List<EmployeeInfoBean> getAllEmployeeRecord() {
		// TODO Auto-generated method stub
		return dao.getAllEmployeeRecord();
	}

	@Override
	public boolean updateEmployeeInfo(EmployeeInfoBean ref) {
		// TODO Auto-generated method stub
		return dao.updateEmployeeInfo(ref);
	}

	@Override
	public boolean deleteEmployeeInfo(int empid) {
		// TODO Auto-generated method stub
		return dao.deleteEmployeeInfo(empid);
	}

}
