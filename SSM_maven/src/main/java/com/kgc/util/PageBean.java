package com.kgc.util;

import java.util.List;

/**
 * 分页工具组件：
 * 包含若干种分页定位方法
 */
public class PageBean<E> {
	private Integer pageNo=1;//当前页码
	private Integer pageSize = 3;//页容量
	private List<E> list; //当前页的数据
	private Integer totalCount;//进行分页的总记录数
	/**
	 * 上一页
	 * @return 当前页为首页时返回1,不为首页时当前页-1
	 *  ${previous}
	 */
	public Integer getPrevious(){
		 return  this.pageNo==1?1:this.pageNo-1;
		 //return this.pageNo>1?this.pageNo-1:1;
	}
	/**
	 * 下一页
	 * @return 当前页为最后一页,返回尾页，不为尾页返回当前页+1
	 * ${next}
	 */
	public Integer getNext(){
		 return this.pageNo==getLast()?getLast():this.pageNo+1;
	}
	/**
	 * 首页
	 * @return 返回1
	 * ${first}
	 */
	public Integer getFirst(){
		 return 1;
	}
	/**
	 * 尾页
	 * @return 返回总页码
	 * ${last}
	 */
	public Integer getLast(){
		 return getTotalPages();
	}
	/**
	 * 总页数
	 * @return 总记录数对页面容量取余，若为0返回总记录数、页面容量相除之数
	 * 若不为0返回总记录数、页面容量相除的商值+1
	 * ${totalPages}
	 */
	public Integer getTotalPages(){
		return
		  totalCount%pageSize==0?
				  totalCount/pageSize:totalCount/pageSize+1;
	}
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public List<E> getList() {
		return list;
	}
	public void setList(List<E> list) {
		this.list = list;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	
	public PageBean(Integer pageNo, Integer pageSize, List<E> list, Integer totalCount) {
		super();
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.list = list;
		this.totalCount = totalCount;
	}
	
	public PageBean() {
		super();
	}
	
	
}
