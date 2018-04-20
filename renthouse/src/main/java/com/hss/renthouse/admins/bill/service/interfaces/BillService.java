package com.hss.renthouse.admins.bill.service.interfaces;

import com.hss.renthouse.admins.bill.entity.Bill;
import com.hss.renthouse.util.BPageBean;
import com.hss.renthouse.util.BQueryVo;

/**
 * 账单service接口
 * @author hss
 *
 */
public interface BillService {

	/**
	 * 查询所有账单
	 * @param vo
	 * @return
	 */
	BPageBean<Bill> queryAllBills(BQueryVo vo);

}
