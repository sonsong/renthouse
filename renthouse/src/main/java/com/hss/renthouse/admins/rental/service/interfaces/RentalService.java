package com.hss.renthouse.admins.rental.service.interfaces;

import com.hss.renthouse.admins.rental.entity.Rental;
import com.hss.renthouse.utils.BPageBean;
import com.hss.renthouse.utils.BQueryVo;

/**
 * 租金service层
 * @author hss
 *
 */
public interface RentalService {

	/**
	 * 查询所有的租金单
	 * @param vo
	 * @return
	 */
	BPageBean<Rental> queryAllRenters(BQueryVo vo);

}
