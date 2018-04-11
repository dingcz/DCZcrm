package com.ithc.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.ithc.bean.Linkman;
import com.ithc.util.PageBean;
import com.ithc.util.UtilDaoImpl;

@SuppressWarnings("all")
public class LinkmanDaoImpl extends UtilDaoImpl<Linkman> implements LinkmanDao{

	/*
	 * @Override
	public void save(Linkman linkman) {
		this.getHibernateTemplate().save(linkman);
		
	}

	@Override
	public PageBean<Linkman> findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria) {
		
		PageBean<Linkman> pageBean = new PageBean<>();
		//1.当前页
		pageBean.setPageCode(pageCode);
		//2.每页显示的数量
		pageBean.setPageSize(pageSize);
		List<Number> value = (List<Number>) this.getHibernateTemplate().findByCriteria(criteria.setProjection(Projections.rowCount()));
		if(value != null){
			//3.设置总记录数
			pageBean.setTotalCount(value.get(0).intValue());
		}
		
		//设置null
		criteria.setProjection(null);
		
		//4.求值
		List<Linkman> list = (List<Linkman>) this.getHibernateTemplate().findByCriteria(criteria,(pageCode-1)*pageSize,pageSize);
		pageBean.setBeanList(list);
		
		
		return pageBean;
	}
	//用id去查询
	@Override
	public Linkman findById(Long id) {
		List<Linkman> list = (List<Linkman>) this.getHibernateTemplate().find("from Linkman where lkm_id = ?", id);
		if(list != null && list.size()>0){
			return list.get(0);
		}
		
		return null;
	}

	@Override
	public void delete(Linkman linkman) {
		this.getHibernateTemplate().delete(linkman);
		
	}

	@Override
	public void update(Linkman linkman) {
	
		this.getHibernateTemplate().update(linkman);
		
	}
	
	*/

}
