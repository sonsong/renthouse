package com.hss.renthouse.admins.renter.dao;

import com.hss.renthouse.admins.renter.entity.Renter;

/**
 * 租客模块dao层
 * @author hss
 *
 */
public interface RenterMapper {

	/**
	 * 新增租客
	 * @param renter
	 */
	void addRenter(Renter renter);

}
