package com.henu.health.dao;


import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.henu.health.enity.Student;
import com.henu.health.util.HibernateBaseDAO;

@Repository
public class StudentDAO extends HibernateBaseDAO<Student, Integer>{
	
	//查找全部学生
	@SuppressWarnings("unchecked")
	public List<Student> findAllStudent(){
		String hql="from Student";
		return  this.createQuery(hql).list();
	}
	
	//增添一个学生
	public void addStudent(Student student){
		this.add(student);
	}
	
	//通过id删除一个学生
	public void delStudent(Integer id){
		this.delete(id);
	}
	
	//修改学生的信息
	public void updateStudent(Student student){
		this.update(student);
	}
	
	//根据id查询学生
	public Student findById(Integer id){
		String hql="from Student where id=?";
		return  (Student) queryByHql(hql, new Integer[]{id});
	}	
	
	/**
	 * 分页查询
	 * @param offset  开始记录
	 * @param length  一次查询几条记录
	 * @return    返回查询记录集合
	 */
	@SuppressWarnings("unchecked")
	public List<Student> queryForPage(Integer offset,Integer length){
		List<Student> list=null;
		Query query = getSession().createQuery("from Student");
		
		query.setFirstResult(offset);
		query.setMaxResults(length);
		list = query.list();
		
		return list;
	}
	
	//查询记录总数
	public Integer getAllRowCount(){
		int count = ((Long) getSession().createQuery("select count(*) from Student").iterate().next()).intValue(); 
		return count;
	}
	
	
	
	
}
