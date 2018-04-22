package com.hss.renthouse.utils;

import java.io.Serializable;

/**
 * 查询条件
 * 
 * @author hss
 *
 */
public class BQueryVo implements Serializable{

	private static final long serialVersionUID = 1L;
	// 每页记录数
	private Integer ps;
	// 每页显示数据的开始行号
	private Integer offset;
	// 排序字段
	private String sort;
	// 排序方式
	private String sortOrder;
	// 编码
	private String id;
	// 用户编码
	private String uid;
	
	//日志查询条件
	private String aname;
	private String ltype;
	private String lmethod;
	private String loperateDate;
	private String ltimeout;
	
	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public String getLtype() {
		return ltype;
	}

	public void setLtype(String ltype) {
		this.ltype = ltype;
	}

	public String getLmethod() {
		return lmethod;
	}

	public void setLmethod(String lmethod) {
		this.lmethod = lmethod;
	}

	public String getLoperateDate() {
		return loperateDate;
	}

	public void setLoperateDate(String loperateDate) {
		this.loperateDate = loperateDate;
	}

	public String getLtimeout() {
		return ltimeout;
	}

	public void setLtimeout(String ltimeout) {
		this.ltimeout = ltimeout;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public Integer getPs() {
		return ps;
	}

	public void setPs(Integer ps) {
		this.ps = ps;
	}

	public Integer getOffset() {
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "BQueryVo [ps=" + ps + ", offset=" + offset + ", sort=" + sort + ", sortOrder=" + sortOrder + ", id="
				+ id + ", uid=" + uid + ", aname=" + aname + ", ltype=" + ltype + ", lmethod=" + lmethod
				+ ", loperateDate=" + loperateDate + ", ltimeout=" + ltimeout + "]";
	}
}
