package com.capgemini.springassignment.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import com.capgemini.springassignment.bean.EmployeeInfoBean;


@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
	@PersistenceUnit
	private EntityManagerFactory factory;
	@Override
	public EmployeeInfoBean getEmployeeDetails(int empid) {
	EntityManager manager = factory.createEntityManager();
	EmployeeInfoBean bean = manager.find(EmployeeInfoBean.class, empid);
		return bean;
	}

	@Override
	public boolean addEmployee(EmployeeInfoBean info) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction trasaction = manager.getTransaction();
		boolean isAdded = false;
		try {
			trasaction.begin();
			manager.persist(info);
			trasaction.commit();
			isAdded = true;
			System.out.println("Added");
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			manager.close();
		}
		return isAdded;
	}

	@Override
	public List<EmployeeInfoBean> getAllEmployeeRecord() {
		EntityManager manager = factory.createEntityManager();
		String jpql = "select m from EmployeeInfoBean m";
		Query query = manager.createQuery(jpql);

		List<EmployeeInfoBean> employeelist = query.getResultList();
		manager.close();
		return employeelist;
	}

	@Override
	public boolean updateEmployeeInfo(EmployeeInfoBean ref) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction =manager.getTransaction();
		boolean isUpdated = false;
		try {
			transaction.begin();
			String jpql ="update EmployeeInfoBean e set e.age=:age where e.id=:id";
			Query query = manager.createQuery(jpql);
			query.setParameter("id",ref.getEmpid());
			query.setParameter("age", ref.getAge());
			int id = query.executeUpdate();
			transaction.commit();
			isUpdated = true;
		}catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			manager.close();
		}
		return isUpdated;
	}

	@Override
	public boolean deleteEmployeeInfo(int empid) {
		boolean isDeleted=false;
		EntityManager manager = factory.createEntityManager();
		EmployeeInfoBean employeeInfoBean = manager.find(EmployeeInfoBean.class, empid);
		if(employeeInfoBean != null) {
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.remove(employeeInfoBean);
			transaction.commit();
			isDeleted = true;
		}
		manager.close();
		return isDeleted;
	}

}
