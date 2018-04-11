package com.ithc.web;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.ithc.bean.Linkman;
import com.ithc.service.LinkmanService;
import com.ithc.util.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

public class LinkmanAction extends ActionSupport implements ModelDriven<Linkman>{
	
	private Linkman linkman = new Linkman();
	
	private LinkmanService linkmanService;

	public void setLinkmanService(LinkmanService linkmanService) {
		this.linkmanService = linkmanService;
	}

	@Override
	public Linkman getModel() {
		
		return linkman;
	}
	//跳转新增联系人
	public String initAddUI(){
		return "initAddUI";
		
	}
	//添加联系人
	public String save(){
		
		linkmanService.save(linkman);
		
		return initAddUI();
	}
	
	//当前页
	private Integer pageCode = 1;

	public void setPageCode(Integer pageCode) {
		if(pageCode == null){
			this.pageCode=1;
		}
		this.pageCode = pageCode;
	}
	
	//每页显示的数量
	private Integer pageSize=2;

	public void setPageSize(Integer pageSize) {
		if(pageSize == null ){
			this.pageSize= 2;
		}
		this.pageSize = pageSize;
	}
	
	//分页查询
	public String findByPage(){
		DetachedCriteria criteria = DetachedCriteria.forClass(Linkman.class);
		
		//筛选条件
		if(linkman != null){
			String lkm_name = linkman.getLkm_name();
			try{
				if(!lkm_name.equals("")){	
					criteria.add(Restrictions.like("lkm_name", "%"+lkm_name+"%"));
				}
				
			}catch(Exception e){	
			}
			
			/*拼接所属客户*/
			try{
				//拼所属行业
				Long id = linkman.getCustomer().getCust_id();
				System.out.println(id);
				if(!id.equals("")){
					criteria.add(Restrictions.eq("customer.cust_id",id ));
				}
				
			}catch(Exception e){
				
			}
			
		
		}
		
		
		if(pageCode == null){
			pageCode =1;
		}
		if(pageSize == null){
			pageSize =2;
		}
		
		PageBean<Linkman> page =  linkmanService.findByPage(pageCode,pageSize,criteria);
		
		ValueStack vs = ActionContext.getContext().getValueStack();
		vs.set("page", page);
		return "findByPage";
	}
	
	//删除
	public String delete(){
		//先查询
		Long id = linkman.getLkm_id();
		if(id == null){
			Linkman linkman = linkmanService.findById(id);
			if(linkman != null){
				linkmanService.delete(linkman);
				return findByPage();
			}
		}
		return "login";
	}
	
	// 修改跳转
		public String initUpdate() {
			Long id = linkman.getLkm_id();
			if (id != null) {
				linkman = linkmanService.findById(id);
			}
			return "initUpdate";
		}

		//修改保存
		public String update(){
			
			linkmanService.update(linkman);
			
			return "update";
		}
	
	
	
	
	
	
	
	
	
	
	
	

}
