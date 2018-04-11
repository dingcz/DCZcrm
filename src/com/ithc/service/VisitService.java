package com.ithc.service;

import org.hibernate.criterion.DetachedCriteria;

import com.ithc.bean.Visit;
import com.ithc.util.PageBean;


public interface VisitService {
	

	void save(Visit visit);
	//分页查询
	PageBean<Visit> findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria);

}
