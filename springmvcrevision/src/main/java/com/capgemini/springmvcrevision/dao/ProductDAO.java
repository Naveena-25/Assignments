package com.capgemini.springmvcrevision.dao;

import java.util.List;

import com.capgemini.springmvcrevision.bean.ProductInfoBean;


public interface ProductDAO {
	ProductInfoBean getProductDetails(int id);
	boolean addProduct(ProductInfoBean info);
	boolean deleteProductInfo(int id);
	boolean updateProductInfo(ProductInfoBean info);
	List<ProductInfoBean> getAllProductInfo();

}
