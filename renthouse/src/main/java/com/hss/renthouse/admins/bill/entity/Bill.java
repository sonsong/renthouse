package com.hss.renthouse.admins.bill.entity;

import java.io.Serializable;

import com.hss.renthouse.user.user.entity.User;

/**
 * 账单实体
 * 
 * @author hss
 *
 */
public class Bill implements Serializable {

	private static final long serialVersionUID = 1L;

	// 账单编码
	private String bid;
	// 生成时间
	private String btime;
	// 账单金额
	private String bprice;
	// 事由
	private String bdue;
	// 账户状态
	private String bstate;
	// 用户编码
	private String uid;

	private User user;

	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	public String getBtime() {
		return btime;
	}

	public void setBtime(String btime) {
		this.btime = btime;
	}

	public String getBprice() {
		return bprice;
	}

	public void setBprice(String bprice) {
		this.bprice = bprice;
	}

	public String getBdue() {
		return bdue;
	}

	public void setBdue(String bdue) {
		this.bdue = bdue;
	}

	public String getBstate() {
		return bstate;
	}

	public void setBstate(String bstate) {
		this.bstate = bstate;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Bill [bid=" + bid + ", btime=" + btime + ", bprice=" + bprice + ", bdue=" + bdue + ", bstate=" + bstate
				+ ", uid=" + uid + ", user=" + user + "]";
	}

}
