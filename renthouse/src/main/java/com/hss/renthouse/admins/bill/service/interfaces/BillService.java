package com.hss.renthouse.admins.bill.service.interfaces;

import java.util.List;

import com.hss.renthouse.admins.bill.entity.Bill;
import com.hss.renthouse.utils.BPageBean;
import com.hss.renthouse.utils.BQueryVo;

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

	/**
	 * 查询我的账单
	 * @param uid 用户编码
	 * @return 
	 */
	List<Bill> queryBillByUid(String uid);

	/**
	 * 修改账单状态为已支付
	 * @param bid
	 * @param state
	 */
	void updateStatus(String bid, Integer state);

}
