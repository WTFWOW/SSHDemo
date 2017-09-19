package com.henu.health.controller;


import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import com.henu.health.enity.Student;
import com.henu.health.service.StudentService;
import com.henu.health.util.Page;

@Controller
public class StudentController {
	@Resource
	private StudentService studentService;
	
	
	//查询到所有的记录并实现了分页
	@RequestMapping("login.html")
	public String login(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap){
		String pageNo = request.getParameter("pageNo");
		if(pageNo==null){
			pageNo="1";
		}
		Page page = studentService.queryForPage(Integer.valueOf(pageNo),5);
		request.setAttribute("page", page);
		List<Student> list = page.getList();
		modelMap.addAttribute("student", list);
		return "login";
	}
	
	
	//跳转到增加学生页面
	@RequestMapping("studentAdd.html")
	public String ToAddStudent(){
		return "add";
	}
	
	//增加学生
	@RequestMapping("studentAdd.do")
	public String AddStudent(Student student){
		studentService.addStudent(student);
		return "redirect:login.html";
	}
	
	//跳转到修改页面
	@RequestMapping("studentEdit.html")
	public String ToEditStudent(Integer id,ModelMap modelMap){
		System.out.println(id);
		Student student = studentService.findById(id);
		modelMap.addAttribute("student", student);
		return "edit";
	}
	
	//修改学生信息
	@RequestMapping("studentEdit.do")
	public String  EditStudent(Student student){
		studentService.updateStudent(student);
		return "redirect: login.html";
	}
	
	//删除学生信息
	@RequestMapping("studentDel.do")
	public String DelStudent(Integer id){
		studentService.delStudent(id);
		return "redirect: login.html";
	}
	
	
	
	
	
	
	
}
