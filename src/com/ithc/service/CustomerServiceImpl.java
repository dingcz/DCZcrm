package com.ithc.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.ithc.bean.Customer;
import com.ithc.dao.CustomerDao;
import com.ithc.util.PageBean;

@Transactional
public class CustomerServiceImpl implements CustomerService{

	private CustomerDao customerDao;

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public void save(Customer customer) {
		this.customerDao.save(customer);
		
	}

	@Override
	public PageBean<Customer> findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria) {
		
		return customerDao.findByPage(pageCode,pageSize,criteria);
	}

	@Override
	public void delete(Customer customer) {
		customerDao.delete(customer);
		
	}

	@Override
	public Customer findById(Long cust_id) {
		
		return customerDao.findById(cust_id);
	}

	@Override
	public void update(Customer customer) {
		customerDao.update(customer);
		
	}

	@Override
	public List<Customer> findByAll() {
		
		return customerDao.findByAll();
	}
	//客户级别统计
	@Override
	public List<Object[]> findByLevel() {
		
		return customerDao.findByLevel();
	}
	//客户来源统计
	@Override
	public List<Object[]> findBySource() {
		
		return customerDao.findBySource();
	}
	//客户行业统计
	@Override
	public List<Object[]> findByIndustry() {
		
		return customerDao.findByIndustry();
	}
	
}
