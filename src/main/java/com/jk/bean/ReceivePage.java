/** 
 * <pre>项目名称:ssm 
 * 文件名称:ReceivePage.java 
 * 包名:com.jk.pojo 
 * 创建日期:2018年11月29日下午1:34:34 
 * Copyright (c) 2018, 634369607@qq.com All Rights Reserved.</pre> 
 */  
package com.jk.bean;

/**
 * <pre>项目名称：ssm    
 * 类名称：ReceivePage    

 * @version </pre>    
 */
public class ReceivePage  {
    private Integer page;  //当前第几页
	
    private Integer rows;  //每页几条

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	   
	/**    
	 * <pre>创建一个新的实例 ReceivePage.    
	 *    </pre>    
	 */
	public ReceivePage() {
		super();
		// TODO Auto-generated constructor stub
	}

	   
	/**    
	 * <pre>创建一个新的实例 ReceivePage.    
	 *    
	 * @param page
	 * @param rows</pre>    
	 */
	public ReceivePage(Integer page, Integer rows) {
		super();
		this.page = page;
		this.rows = rows;
	}
    

}
