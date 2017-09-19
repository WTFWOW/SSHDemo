package com.henu.health.util;

import java.util.List;
import com.henu.health.enity.Student;

/**
 * 分页
 * @author Zkx
 *
 * @param
 */
public class Page {
	
	//结果集
	private List<Student> list;
	
	//查询记录总数
	private Integer totalRecords;
	
	//每页多少条记录
	private Integer pageSize;
	
	//第几页
	private Integer pageNo;
	
	/**
	 * @return 总页数
	 */
	public Integer getTotalPages(){
		return  (totalRecords+pageSize-1)/pageSize;
	}
	

	/**
	 * 计算当前页面开始记录
	 * @param currentPage
	 * @param pageSize
	 * @return 当前页开始记录号
	 */
	public Integer countOffset(Integer currentPage,Integer pageSize){
		
		Integer offset=pageSize*(currentPage-1);
		return  offset;
	} 
	
	/**
	 * @return 首页
	 */
	public Integer getTopPageNo(){
		return 1;
	}
	
	/**
	 * @return 尾页
	 */
	public Integer getBottomPageNo(){
		return getTotalPages();
	}
	
	
	/** 
	 * @return 上一页
	 */
	public Integer getPreviousPageNo(){
		if(pageNo<=1){
			return 1;
		}
		return  pageNo-1;
	}
	
	
	/**
	 * @return 下一页
	 */
	public Integer getNextPageNo(){
		if(pageNo>=getBottomPageNo()){
			return getBottomPageNo();
		}
		return pageNo+1;
	}


	public List<Student> getList() {
		return list;
	}


	public void setList(List<Student> list) {
		this.list = list;
	}


	public Integer getTotalRecords() {
		return totalRecords;
	}


	public void setTotalRecords(Integer totalRecords) {
		this.totalRecords = totalRecords;
	}


	public Integer getPageSize() {
		return pageSize;
	}


	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}


	public Integer getPageNo() {
		return pageNo;
	}


	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	
	
	
	
}
