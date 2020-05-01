package com.capgemini.springmvcrevision.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;


import com.capgemini.springmvcrevision.bean.ProductInfoBean;
@Repository
public class ProductDaoImple implements ProductDAO {
	
	@PersistenceUnit
	EntityManagerFactory factory;

	@Override
	public ProductInfoBean getProductDetails(int id) {
		EntityManager manager = factory.createEntityManager();
		ProductInfoBean productInfoBean = manager.find(ProductInfoBean.class, id);

		return productInfoBean;
	}

	@Override
	public boolean addProduct(ProductInfoBean info) {
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		boolean isAdded=false;
		try {
			transaction.begin();
			manager.persist(info);
			transaction.commit();
			isAdded=true;
			System.out.println("Added");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			manager.close();
			System.out.println("add");
		}
		return isAdded;
	}

	@Override
	public boolean deleteProductInfo(int id) {
		boolean isDeleted=false;
		EntityManager manager=factory.createEntityManager();
		ProductInfoBean productInfo=manager.find(ProductInfoBean.class,id);
		if(productInfo!=null) {
			EntityTransaction transaction=manager.getTransaction();
			transaction.begin();
			manager.remove(productInfo);
			transaction.commit();
			isDeleted=true;
		}
		manager.close();
		return isDeleted;

	}

	@Override
	public boolean updateProductInfo(ProductInfoBean info) {
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		boolean isUpdated=false;
		try {
			transaction.begin();
		String jpql="update ProductInfoBean p set p.productName=:productName where p.productId=:productId";
		Query query=manager.createQuery(jpql);
		query.setParameter("productId",info.getProductId());
		query.setParameter("productName",info.getProductName());
         int id=query.executeUpdate();
         transaction.commit();
         isUpdated=true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			manager.close();
		}
		
		return isUpdated;
	}

	@Override
	public List<ProductInfoBean> getAllProductInfo() {
		EntityManager manager=factory.createEntityManager();
		String jpql="Select p from ProductInfoBean p";
		Query query=manager.createQuery(jpql);
		List<ProductInfoBean> productList=query.getResultList();
		manager.close();
		return productList;
	}

}
