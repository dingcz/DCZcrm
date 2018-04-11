package com.ithc.service;

import org.hibernate.criterion.DetachedCriteria;

import com.ithc.bean.Linkman;
import com.ithc.util.PageBean;

public interface LinkmanService {
	//添加联系人
	void save(Linkman linkman);
	//分页查询
	PageBean<Linkman> findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria);
	//用id去查询
	Linkman findById(Long id);
	//去删除
	void delete(Linkman linkman);
	
	void update(Linkman linkman);

}
