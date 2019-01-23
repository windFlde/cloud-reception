/** 
 * <pre>项目名称:10-17 
 * 文件名称:MyPage.java 
 * 包名:com.jk.xjw.pojo 
 * 创建日期:2018-10-17下午5:23:36 
 * Copyright (c) 2018, All Rights Reserved.</pre> 
 */  
package com.jk.utils;

import java.util.List;


/** 
 * <pre>项目名称：10-17    
 * 类名称：MyPage    
 * 类描述：    
 * 创建人：薛嘉伟   
 * 创建时间：2018-10-17 下午5:23:36    
 * 修改人：薛嘉伟      
 * 修改时间：2018-10-17 下午5:23:36    
 * 修改备注：       
 * @version </pre>    
 */
public class PageUtil {
	//当前页数
	private Integer pageNow;
	//每页的条数
	private Integer pageSize;
	//总页数
	private Integer countPage;
	//总条数
	private Integer countItem;
	
	private List data;

	//TODO
	public Integer getPageNow() {
		return pageNow;
	}
	public PageUtil() {
		super();
	}
	public PageUtil(Integer pageNow, Integer pageSize, Integer countItem) {
		super();
//		<!-- 如果当前页数没有值，默认为1
		this.pageNow = pageNow==null ? 1: pageNow;
//		<!-- 如果总页数没有值，默认为3 -->
		if(pageSize==null){
			this.pageSize=3;
		}else{
			this.pageSize=pageSize;
		}
		this.countItem = countItem;
		// 计算页数
				int countPageTemp = countItem / this.pageSize;
				
				// 判断有没有余数 如果有余数 页数就加1
				if (countItem % this.pageSize > 0) {
					countPageTemp = countPageTemp + 1;
				}
		
		//当前页数的总页数
		this.countPage=countPageTemp;
	}
	//用来计算分页开始的条数
	public Integer getBeginItem(){
		int start=(pageNow-1)*pageSize;
		return start;
	}


	public void setPageNow(Integer pageNow) {
		this.pageNow = pageNow;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getCountPage() {
		return countPage;
	}

	public void setCountPage(Integer countPage) {
		this.countPage = countPage;
	}

	public Integer getCountItem() {
		return countItem;
	}

	public void setCountItem(Integer countItem) {
		this.countItem = countItem;
	}

	public Object getUclass() {
		return null;
	}

	public Object getMajor() {
		return null;
	}

	public Object getName() {
		return null;
	}
	public List getData() {
		return data;
	}
	public void setData(List data) {
		this.data = data;
	}
	




	
	

}
