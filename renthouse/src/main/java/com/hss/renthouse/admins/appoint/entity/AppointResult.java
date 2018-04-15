package com.hss.renthouse.admins.appoint.entity;

import java.io.Serializable;

import com.hss.renthouse.admins.admin.entity.Admin;

/**
 * 预约结果实体
 * 
 * @author hss
 *
 */
public class AppointResult implements Serializable {

	private static final long serialVersionUID = 1L;

	// 编码
	private String rid;
	// 是否联系
	private Integer isConnect;
	// 结果
	private Integer result;
	// 理由
	private String reason;
	// 操作人
	private String adid;
	// 预约编码
	private String aid;

	private Admin admin;
	private Appoint appoint;

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public Integer getIsConnect() {
		return isConnect;
	}

	public void setIsConnect(Integer isConnect) {
		this.isConnect = isConnect;
	}

	public Integer getResult() {
		return result;
	}

	public void setResult(Integer result) {
		this.result = result;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getAdid() {
		return adid;
	}

	public void setAdid(String adid) {
		this.adid = adid;
	}

	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Appoint getAppoint() {
		return appoint;
	}

	public void setAppoint(Appoint appoint) {
		this.appoint = appoint;
	}

	@Override
	public String toString() {
		return "AppointResult [rid=" + rid + ", isConnect=" + isConnect + ", result=" + result + ", reason=" + reason
				+ ", adid=" + adid + ", aid=" + aid + ", admin=" + admin + ", appoint=" + appoint + "]";
	}

}
