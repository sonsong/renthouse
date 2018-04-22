package com.hss.renthouse.admins.rental.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hss.renthouse.admins.rental.dao.RentalMapper;
import com.hss.renthouse.admins.rental.entity.Rental;
import com.hss.renthouse.admins.rental.service.interfaces.RentalService;
import com.hss.renthouse.utils.BPageBean;
import com.hss.renthouse.utils.BQueryVo;

/**
 * 租金service层实现
 * 
 * @author hss
 *
 */

@Service
public class RentalServiceImpl implements RentalService {

	@Autowired
	private RentalMapper rentalMapper;

	@Override
	public BPageBean<Rental> queryAllRenters(BQueryVo vo) {
		// 得到合同的总记录数
		Integer total = rentalMapper.queryRentalsTotal();
		// 按条件查询用户
		List<Rental> rentals = rentalMapper.queryAllRentals(vo);

		BPageBean<Rental> pb = new BPageBean<>();
		pb.setTotal(total);
		pb.setRows(rentals);
		return pb;
	}

}
