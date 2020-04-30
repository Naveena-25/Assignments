package com.capgemini.springassignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.capgemini.springassignment.bean.EmployeeInfoBean;
import com.capgemini.springassignment.service.EmployeeService;
import com.capgemini.springassignment.service.EmployeeServiceImpl;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeService service;
	@GetMapping("/getEmployeeForm") 
	public String getEmployeeForm() {
		
	return "searchEmployee";
	}
	@GetMapping("getEmployee")
	public String getEmployee(int empid, ModelMap modelMap) {
		EmployeeInfoBean employeeInfoBean = service.getEmployeeDetails(empid);
		if(employeeInfoBean != null) {
			modelMap.addAttribute(employeeInfoBean);
		} else {
			modelMap.addAttribute("errMsg","employee id not found");
		}
		return "searchEmployee";
	}
	@GetMapping("/delete")
	public String getdeleteForm() {
		return "deleteEmployee";
	}
	@GetMapping("/deleteEmployee")
	public String getDelete(int id, ModelMap map) {//model map to transfer the data
		boolean deleted = service.deleteEmployeeInfo(id);
		if(deleted) {
			map.addAttribute("hello", "Record Deleted");
			return "hello";
		} else {
			return "deleteEmployee";
		}
	}
	@GetMapping("/getAll")
	public String getAllForm() {
		return "allDetailOfEmp";
	}
	@GetMapping("/getAllEmployee")
	public String getAllForm(ModelMap map) {
		List<EmployeeInfoBean> allRecord = service.getAllEmployeeRecord();
		map.addAttribute("list", allRecord);
		return "getAllEmployee";
	}
	@GetMapping("/update")
	public String getupdateForm() {
		return "updateEmp";
	}
	@PostMapping("/updateEmployee")
	public String getUpdate(EmployeeInfoBean info, ModelMap map) {//model map to transfer the data
		boolean updated = service.updateEmployeeInfo(info);
		if(updated) {
			map.addAttribute("hello", "Record Updated");
			return "hello";
		} else {
			return "updateEmp";
		}
	}
	@GetMapping("/added") 
	public String addEmpForm() {
		return "add-employee";
	}
		@PostMapping("/addedEmployee")
		public String addEmp(EmployeeInfoBean info,ModelMap modelMap) {
			boolean added = service.addEmployee(info);
			if(added) {
				modelMap.addAttribute("add",added);
			}
			return "added";
		}		
}
