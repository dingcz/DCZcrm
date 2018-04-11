package com.ithc.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.ithc.bean.Customer;
import com.ithc.util.PageBean;
@SuppressWarnings("all")
public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {

	@Override
	public void save(Customer customer) {
		this.getHibernateTemplate().save(customer);
		
	}

	@Override
	public PageBean<Customer> findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria) {
		PageBean<Customer> pageBean = new PageBean<Customer>();
		//设置当前页
		pageBean.setPageCode(pageCode);
		//设置每页显示的数量去球总页数
		pageBean.setPageSize(pageSize);
		//select count(*)
		List<Number> number = (List<Number>) this.getHibernateTemplate().findByCriteria(criteria.setProjection(Projections.rowCount()));
		if(number != null && number.size()>0){
			int intValue = number.get(0).intValue();
			//设置总记录数
			pageBean.setTotalCount(intValue);
		}
		
		//查询控制
		criteria.setProjection(null);
		
		//设置Beanlist集合
		
		List<Customer> list = (List<Customer>) this.getHibernateTemplate().findByCriteria(criteria,(pageCode-1)*pageSize,pageSize);
		System.out.println(11);
		if(list != null && list.size()>0){
			pageBean.setBeanList(list);
		}
		return pageBean;
	}
	//删除
	@Override
	public void delete(Customer customer) {
		this.getHibernateTemplate().delete(customer);
		
	}
	//用id去查询
	@Override
	public Customer findById(Long cust_id) {
		List<Customer> list = (List<Customer>) this.getHibernateTemplate().find(" from Customer where cust_id = ?", cust_id);
		if(list != null && list.size()>0 ){
			return list.get(0);
		}
		return null;
	}
	//修改
	@Override
	public void update(Customer customer) {
		this.getHibernateTemplate().update(customer);
		
	}

	@Override
	public List<Customer> findByAll() {
		List<Customer> customer = (List<Customer>) this.getHibernateTemplate().find("from Customer");
		if(customer != null && customer.size()>0){
			return customer;
		}
		return null;
	}

	@Override
	public List<Object[]> findByLevel() {
		
		/**
		 * 	SELECT
			b.dict_item_name,COUNT(*)
			FROM 
			cst_customer c,base_dict b
			WHERE c.cust_level = b.dict_id
			GROUP BY 
			b.dict_id;
		 */
		String hql = "select c.level.dict_item_name,count(*) from Customer c inner join c.level group by c.level ";
		List<Object[]> list = (List<Object[]>) this.getHibernateTemplate().find(hql);
		if(list != null && list.size()>0){
			return list;
		}
		return null;
	}

	@Override
	public List<Object[]> findBySource() {
		/**
		 *  SELECT
			b.dict_item_name,COUNT(*)
			FROM 
			cst_customer c,base_dict b
			WHERE c.cust_source = b.dict_id
			GROUP BY 
			b.dict_id;
		 */
		String hql = "select c.source.dict_item_name, count(*) from Customer c inner join c.source group by c.source ";
		
		List<Object[]> list = (List<Object[]>) this.getHibernateTemplate().find(hql);
		if(list != null && list.size()>0){
			
			return list;
		}
		
		return null;
	}

	@Override
	public List<Object[]> findByIndustry() {
		
		String hql = "select c.industry.dict_item_name,count(*) from Customer c inner join c.industry group by c.industry ";
		List<Object[]> list = (List<Object[]>) this.getHibernateTemplate().find(hql);
		if(list != null && list.size() > 0){
			return list;
		}
		
		return null;
	}

}















