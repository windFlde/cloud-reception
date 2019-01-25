/** 
 * <pre>项目名称:ssm 
 * 文件名称:SendPage.java 
 * 包名:com.jk.pojo 
 * 创建日期:2018年11月29日下午1:37:02 
 * Copyright (c) 2018, 634369607@qq.com All Rights Reserved.</pre> 
 */  
package com.jk.bean;

import java.util.List;

/** 
 * <pre>项目名称：ssm    
 * 类名称：SendPage    
 * 类描述：    

 * @version </pre>    
 */
public class SendPage {
    private Integer total;  //总条数
	
	private List rows;  //分页后的数据
	
   
	   
	public Integer getTotal() {
		return total;
	}



	public void setTotal(Integer total) {
		this.total = total;
	}



	public List getRows() {
		return rows;
	}



	public void setRows(List rows) {
		this.rows = rows;
	}
    


	/**    
	 * <pre>创建一个新的实例 SendPage.    
	 *    
	 * @param total
	 * @param rows</pre>    
	 */
	public SendPage(Integer total, List rows) {
		super();
		this.total = total;
		this.rows = rows;
	}


	   
	/**    
	 * <pre>创建一个新的实例 SendPage.    
	 *    </pre>    
	 */
	public SendPage() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}