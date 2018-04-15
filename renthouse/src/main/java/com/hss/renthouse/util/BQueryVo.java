package com.hss.renthouse.util;

/**
 * 查询条件
 * 
 * @author hss
 *
 */
public class BQueryVo {

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
				+ id + "]";
	}
}
