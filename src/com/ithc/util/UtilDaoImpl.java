package com.ithc.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

@SuppressWarnings("all")
public class UtilDaoImpl<T> extends HibernateDaoSupport implements UtilDao<T> {
	
	Class clazz;
	public UtilDaoImpl(){
		
		//this代表子类，子类加载的时候父类也会加载
		/*getClass().getGenericSuperclass()返回表示此 Class 所表示的实体（类、接口、基本类型或 void）的直接超类的 Type
		然后将其转换ParameterizedType
		getActualTypeArguments()返回表示此类型实际类型参数的 Type 对象的数组。[0]就是这个数组中第一个,
		
		简而言之就是获得超类的泛型参数的实际类型。
		*
		*/
		Type type = this.getClass().getGenericSuperclass();
		
		if(type instanceof ParameterizedType){
			
			ParameterizedType parameterizedType = (ParameterizedType) type;
			Type[] types = parameterizedType.getActualTypeArguments();
			clazz = (Class) types[0];
		}
		
	}
	
	//保存
	@Override
	public void save(T t) {
		this.getHibernateTemplate().save(t);
		
	}
	//删除
	@Override
	public void delete(T t) {
		this.getHibernateTemplate().delete(t);
		
		
	}

	//修改
		public void update(T t) {
			this.getHibernateTemplate().update(t);
		}

		//用id查询
		public T findById(Long id) {
			T t =  (T) this.getHibernateTemplate().get(clazz, id);
			if(t != null){
				return t;
			}
			return null;
		}

		//查询所有
		public List<T> findByAll() {
			List<T> list = (List<T>) this.getHibernateTemplate().find("from "+clazz);
			if(list != null && list.size() >0){
				return list;
			}
			return null;
		}
		//分页查询
		public PageBean<T> findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria) {
			PageBean<T> pageBean = new PageBean<>();
			//设置当前页
			pageBean.setPageCode(pageCode);
			//设置每页显示的数量
			pageBean.setPageSize(pageSize);
			
			//设置总记录数
			List<Number> totalCount = (List<Number>) this.getHibernateTemplate().findByCriteria(criteria.setProjection(Projections.rowCount()));
			if(totalCount != null && totalCount.size() >0){
				pageBean.setTotalCount(totalCount.get(0).intValue());
			}
			criteria.setProjection(null);
			
			List<T> list = (List<T>) this.getHibernateTemplate().findByCriteria(criteria, (pageCode-1)*pageSize, pageSize);
			if(list != null && list.size() >0){
				pageBean.setBeanList(list);
				return pageBean;
			}
			return null;
		}

}
