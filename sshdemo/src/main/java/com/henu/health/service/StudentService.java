package com.henu.health.service;

import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.henu.health.dao.StudentDAO;
import com.henu.health.enity.Student;
import com.henu.health.util.Page;

@Service
public class StudentService {

	@Resource
	private StudentDAO studentDAO;
	
	//遍历全部学生
	@Transactional
	public List<Student> findAllStudent(){
		return studentDAO.findAllStudent();
	}
	
	//增添一个学生
	@Transactional
	public void addStudent(Student student){
		studentDAO.add(student);
	}
	
	//通过id删除一个学生
	@Transactional
	public void delStudent(Integer id){
		studentDAO.delStudent(id);
	}
	
	//修改学生的信息
	@Transactional
	public void updateStudent(Student student){
		studentDAO.updateStudent(student);
	}
	
	//根据学生id查询学生
	@Transactional
	public Student findById(Integer id){
		return studentDAO.findById(id);
	}
	
	//查询记录总数
	public Integer getAllRowCount(){
		return  studentDAO.getAllRowCount();
	}
	
	
	/**
	 * 分页查询
	 * @param currentPage  当前页号:现在显示的页数
	 * @param pageSize  每页显示的记录条数
	 * @return 封闭了分页信息(包括记录集list)的Bean
	 */
	@Transactional
	public Page queryForPage(Integer currentPage,Integer pageSize){
		Page page = new Page();
		//总记录数
		Integer allRow = studentDAO.getAllRowCount();
		//当前页开始记录
		Integer offset = page.countOffset(currentPage, pageSize);
		//分页查询结果集
		List<Student> list = studentDAO.queryForPage(offset, pageSize);
		page.setPageNo(currentPage);
		page.setPageSize(pageSize);
		page.setTotalRecords(allRow);
		page.setList(list);
		
		return page;
	} 
	
}
