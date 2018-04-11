package com.ithc.service;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.ithc.bean.Linkman;
import com.ithc.dao.LinkmanDao;
import com.ithc.util.PageBean;

@Transactional
public class LinkmanServiceImpl implements LinkmanService{
	private LinkmanDao linkmanDao;

	public void setLinkmanDao(LinkmanDao linkmanDao) {
		this.linkmanDao = linkmanDao;
	}

	@Override
	public void save(Linkman linkman) {
		linkmanDao.save(linkman);
		
	}

	@Override
	public PageBean<Linkman> findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria) {
	
		return linkmanDao.findByPage(pageCode,pageSize,criteria);
	}
	//用id去查询
	@Override
	public Linkman findById(Long id) {
		
		return linkmanDao.findById(id);
	}
	//去删除
	@Override
	public void delete(Linkman linkman) {
		linkmanDao.delete(linkman);
		
	}

	@Override
	public void update(Linkman linkman) {
		linkmanDao.update(linkman);
		
	}
	
	

}
