package com.hss.renthouse.admins.bill.dao;

import java.util.List;

import com.hss.renthouse.admins.bill.entity.Bill;
import com.hss.renthouse.util.BQueryVo;

/**
 * 账单dao
 * @author hss
 *
 */
public interface BillMapper {

	/**
	 * 添加账单信息
	 * @param b
	 */
	void addBill(Bill b);

	/**
	 * 统计账单总数
	 * @return
	 */
	Integer queryBillsTotal();

	/**
	 * 查询所有账单
	 * @param vo
	 * @return
	 */
	List<Bill> queryAllBills(BQueryVo vo);

}
