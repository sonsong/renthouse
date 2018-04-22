package com.hss.renthouse.admins.rental.dao;

import java.util.List;

import com.hss.renthouse.admins.rental.entity.Rental;
import com.hss.renthouse.utils.BQueryVo;

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

	/**
	 * 查询租金总数
	 * @return
	 */
	Integer queryRentalsTotal();

	/**
	 * 查询所有租金记录
	 * @param vo
	 * @return
	 */
	List<Rental> queryAllRentals(BQueryVo vo);

}
