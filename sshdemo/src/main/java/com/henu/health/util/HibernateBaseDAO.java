package com.henu.health.util;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HibernateBaseDAO<T extends Object,ID extends Serializable> {

	@Resource
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return  sessionFactory.getCurrentSession();
	}
	
	public Query createQuery(String hql){
		return this.getSession().createQuery(hql);
	}
	
	public Query createSQLQuery(String sql){
		return this.getSession().createSQLQuery(sql);
	}
	
	/**
	 * 获得实体类
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Class<T> getEnityClass(){
		ParameterizedType pt=(ParameterizedType) this.getClass().getGenericSuperclass();
		return (Class<T>) pt.getActualTypeArguments()[0];
	}
	
	
	/**
	 * 取得实体的名字
	 * 
	 * @return
	 */
	public String getEnityName(){
		return this.getEnityClass().getName();
	}
	
	//增加
	public void add(T t){
		this.getSession().save(t);
	}
	
	//删除对象
	public void delete(T t){
		this.getSession().delete(t);
	}
	
	@SuppressWarnings("unchecked")
	public T load(ID id){
		return (T) this.getSession().load(getEnityClass(), id);
	}
	
	@SuppressWarnings("unchecked")
	public T get(ID id){
		return (T) this.getSession().get(getEnityClass(), id);
	}
	
	//通过id删除对象
	public void delete(ID id){
		T t = this.load(id);
		this.getSession().delete(t);
	}
	
	//更改
	public void update(T t){
		this.getSession().update(t);
	}
	
	/**
	 * HQL查询一条数据,参数为数组
	 * @param hql
	 * @param args
	 * @return
	 */
	public Object queryByHql(String hql,Object[] args){
		Query q = setParameterQuery(hql, args);
		q.setMaxResults(1);
		return q.uniqueResult();
	}
	
	
	private Query setParameterQuery(String hql,Object[]args){
		Query q=this.getSession().createQuery(hql);
		if(args!=null && args.length>0){
			for(int i=0;i<args.length;i++){
				q.setParameter(i, args[i]);
			}
		}
		return q;
	}
	
	
}
