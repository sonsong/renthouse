package com.hss.renthouse.admins.rental.dao;

import com.hss.renthouse.admins.rental.entity.Rental;

/**
 * 租金dao层
 * @author hss
 *
 */
public interface RentalMapper {

	/**
	 * 新增租金记录
	 * @param rental
	 */
	void addRental(Rental rental);

}
