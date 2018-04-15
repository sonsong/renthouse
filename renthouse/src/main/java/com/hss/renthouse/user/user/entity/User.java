package com.hss.renthouse.user.user.entity;

import java.io.Serializable;

/**
 * 用户实体类
 * 
 * @author hss
 *
 */
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	// 用户编码
	private String uid;
	// 用户名称
	private String uname;
	// 登陆密码
	private String upasswd;
	// 联系方式
	private String utele;
	// 邮件
	private String uemail;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpasswd() {
		return upasswd;
	}

	public void setUpasswd(String upasswd) {
		this.upasswd = upasswd;
	}

	public String getUtele() {
		return utele;
	}

	public void setUtele(String utele) {
		this.utele = utele;
	}

	public String getUemail() {
		return uemail;
	}

	public void setUemail(String uemail) {
		this.uemail = uemail;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", upasswd=" + upasswd + ", utele=" + utele + ", uemail="
				+ uemail + "]";
	}

}
