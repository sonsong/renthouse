package com.hss.renthouse.admins.bill.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hss.renthouse.admins.bill.dao.BillMapper;
import com.hss.renthouse.admins.bill.entity.Bill;
import com.hss.renthouse.admins.bill.service.interfaces.BillService;
import com.hss.renthouse.util.BPageBean;
import com.hss.renthouse.util.BQueryVo;

/**
 * 账单service实现
 * 
 * @author hss
 *
 */
@Service
public class BillServiceImpl implements BillService {

	@Autowired
	private BillMapper billMapper;

	@Override
	public BPageBean<Bill> queryAllBills(BQueryVo vo) {
		// 得到合同的总记录数
		Integer total = billMapper.queryBillsTotal();
		// 按条件查询用户
		List<Bill> bills = billMapper.queryAllBills(vo);

		BPageBean<Bill> pb = new BPageBean<>();
		pb.setTotal(total);
		pb.setRows(bills);
		return pb;
	}

}
