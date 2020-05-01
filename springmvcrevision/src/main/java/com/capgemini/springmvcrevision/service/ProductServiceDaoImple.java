package com.capgemini.springmvcrevision.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.springmvcrevision.bean.ProductInfoBean;
import com.capgemini.springmvcrevision.dao.ProductDAO;
@Service
public class ProductServiceDaoImple implements ProductServiceDao {
	@Autowired
	private ProductDAO dao;

	@Override
	public ProductInfoBean getProductDetails(int id) {
		// TODO Auto-generated method stub
		return dao.getProductDetails(id);
	}

	@Override
	public boolean addProduct(ProductInfoBean info) {
		// TODO Auto-generated method stub
		return dao.addProduct(info);
	}

	@Override
	public boolean deleteProductInfo(int id) {
		// TODO Auto-generated method stub
		return dao.deleteProductInfo(id);
	}

	@Override
	public boolean updateProductInfo(ProductInfoBean info) {
		// TODO Auto-generated method stub
		return dao.updateProductInfo(info);
	}

	@Override
	public List<ProductInfoBean> getAllProductInfo() {
		// TODO Auto-generated method stub
		return dao.getAllProductInfo();
	}

}
