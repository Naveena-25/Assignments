package com.capgemini.springmvcrevision.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import com.capgemini.springmvcrevision.bean.ProductInfoBean;
import com.capgemini.springmvcrevision.service.ProductServiceDao;

@Controller
public class ProductController {
	@Autowired
	ProductServiceDao service;

	@GetMapping("/getProductForm")
	public String getProductForm() {

		return "searchProduct";
	}

	@GetMapping("/getProduct")
	public String getProduct(int id, ModelMap modelMap) {
		ProductInfoBean bean = service.getProductDetails(id);
		if (bean != null) {
			modelMap.addAttribute("bean", bean);
		} else {
			modelMap.addAttribute("errmsg", "Product Id Not Found");
		}
		return "searchProduct";
	}

	@GetMapping("/add")
	public String getAddProductForm() {

		return "addProduct";
	}

	@PostMapping("/added")
	public String submitForm(ProductInfoBean info, ModelMap map) {
		boolean added = service.addProduct(info);
		if (added) {
			map.addAttribute("added", added);
		}
		return "addProduct";

	}
	@GetMapping("/delete")
	public String getDeleteForm() {
		return "deleteProduct";
	}
	@GetMapping("/deleted")
	public String getDelete(int id,ModelMap map) {
		boolean deleted=service.deleteProductInfo(id);
		if(deleted) {
			return "hello";
		}else {
		return "deleteProduct";
		}
	}
	@GetMapping("/update")
	public String getUpdateForm() {
		return "updateProduct";
	}
	@PostMapping("/updated")
	public String updated(ProductInfoBean info, ModelMap map) {
		
		boolean updated=service.updateProductInfo(info);
		if(updated) {
			map.addAttribute("hello","Record Updated");
			return "hello";
		}else {
		return "updateProduct";
	}
	}
}
