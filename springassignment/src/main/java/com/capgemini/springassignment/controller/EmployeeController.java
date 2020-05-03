package com.capgemini.springassignment.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.capgemini.springassignment.bean.EmployeeInfoBean;
import com.capgemini.springassignment.service.EmployeeService;
import com.capgemini.springassignment.service.EmployeeServiceImpl;
import com.mysql.fabric.proto.xmlrpc.AuthenticatedXmlRpcMethodCaller;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService service;
	
	@GetMapping("/loginForm")
	public String getLoginForm() {
		return "loginForm";
	}
	@PostMapping("/login")
	public String authenticate(int empid, String password, HttpServletRequest req) {
		EmployeeInfoBean employeeInfoBean = service.authenticate(empid, password);
		if(employeeInfoBean != null) {
			HttpSession session = req.getSession(true);
			session.setAttribute("loggedInEmpInfo",employeeInfoBean);
			return "homePage";
		} else {
			req.setAttribute("errMsg", "Invalid Credentials");
			return "loginForm";
		}
	}
	
	@GetMapping("/home")
	public String showHomePage(HttpSession session, ModelMap modelMap) {
		if(session.getAttribute("loggedInEmpInfo")!=null) {
			return "homePage";
		}else {
			modelMap.addAttribute("errMsg","please Login To Access This Page");
			return "loginForm";
		}
	}
	@GetMapping("/getEmployeeForm")
	public String getEmployeeForm(HttpSession session, ModelMap modelMap) {
		if(session.isNew()) {
			modelMap.addAttribute("errMsg","Please LogIn First!");
			return "loginForm";
		}
		
		return "searchEmployee";
	}//End Of GetEmployeeForm()
	
	@GetMapping("getEmployee")
	public String getEmployee(int empid,ModelMap modelMap,HttpSession session) {
		if(session.getAttribute("loggedInEmpInfo")!=null) {
			EmployeeInfoBean employeeInfoBean=service.getEmployeeDetails(empid);
			if(employeeInfoBean!=null) {
				modelMap.addAttribute("employeeInfo",employeeInfoBean);
			}else {
				modelMap.addAttribute("errMsg","Employee Id Not Found");
			}
			return "searchEmployee";	
		}else {
			modelMap.addAttribute("errMsg","Please Login First");
			return "loginForm";
		}		
		
	}//End Of getEmployee()
	
 @GetMapping("/delete")
	public String getdeleteForm(HttpSession session,ModelMap modelMap) {
		if(session.isNew()) {
			modelMap.addAttribute("errMsg","Please LogIn First!");
		return "loginForm";
		}
		return "deleteEmployee";
	}
	@GetMapping("/deleteEmployee")
	public String getDelete(int empid, ModelMap map,HttpSession session) {//model map to transfer the data
		if(session.getAttribute("loggedInEmpInfo")!=null) {
		boolean deleted = service.deleteEmployeeInfo(empid);
		if(deleted) {
			map.addAttribute("hello", "Record Deleted");
			return "hello";
		} else {
			return "deleteEmployee";
		}
		}else {
			map.addAttribute("errMsg","Please Login First");
			return "loginForm";
		}
	}
	@GetMapping("/getAll")
	public String getAllForm() {
		return "getAllEmployee";
	}
	@GetMapping("/getAllEmployee")
	public String getAllForm(ModelMap map) {
		List<EmployeeInfoBean> allRecord = service.getAllEmployeeRecord();
		map.addAttribute("list", allRecord);
		return "getAllEmployee";
	}
	@GetMapping("/update")
	public String getupdateForm(HttpSession session,ModelMap modelMap) {
		if(session.isNew()) {
			modelMap.addAttribute("errMsg","Please LogIn First!");
		return "loginForm";
		}
		return "updateEmp";
	}
	@GetMapping("/updateEmployee")
	public String getUpdate(EmployeeInfoBean info, ModelMap map,HttpSession session) {//model map to transfer the data
		if(session.getAttribute("loggedInEmpInfo")!=null) {
		boolean updated = service.updateEmployeeInfo(info);
		if(updated) {
			map.addAttribute("hello", "Record Updated");
			return "hello";
		} else {
			return "updateEmp";
		}
		}else {
			map.addAttribute("errMsg","Please Login First");
			return "loginForm";
		}
	}
	@GetMapping("/add")
	public String getAddEmployeeForm(HttpSession session,ModelMap modelMap) {
		if(session.isNew()) {
			modelMap.addAttribute("errMsg","Please LogIn First!");
		return "loginForm";
		}

		return "add-employee";
	}

	@PostMapping("/addemp")
	public String submitForm(EmployeeInfoBean info, ModelMap map,HttpSession session) {
		if(session.getAttribute("loggedInEmpInfo")!=null) {
		boolean added = service.addEmployee(info);
		if (added) {
			map.addAttribute("added", added);
			return "hello";
		}else {
		return "add-employee";
		}
		}else {
			map.addAttribute("errMsg","Please Login First");
			return "loginForm";
		}
	}	
		@GetMapping("/logout")
		public String logOut(HttpSession session,ModelMap modelMap) {
			session.invalidate();
			modelMap.addAttribute("errMsg","You Are Logged Out Successsfully");
			return "loginForm";
		}
}
