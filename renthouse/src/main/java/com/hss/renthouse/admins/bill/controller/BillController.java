package com.hss.renthouse.admins.bill.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hss.renthouse.admins.bill.entity.Bill;
import com.hss.renthouse.admins.bill.service.interfaces.BillService;
import com.hss.renthouse.utils.BPageBean;
import com.hss.renthouse.utils.BQueryVo;

/**
 * 账单controller
 * @author hss
 *
 */
@Controller
@RequestMapping( value = "/admin" )
public class BillController {

	@Autowired
	private BillService billService;
	
	/**
	 * 查询所有的租客
	 * @param vo
	 * @return
	 */
	@ResponseBody
	@RequestMapping( value = "/queryAllBills.action")
	public BPageBean<Bill> queryAllBills(BQueryVo vo) {
		return billService.queryAllBills(vo);
	}
	
	/**
	 * 跳转到租客管理页面
	 * @return
	 */
	@RequestMapping( value = "/skipBillManagePage.action")
	public ModelAndView skipBillManagePage(){
		ModelAndView md = new ModelAndView();
		
		md.setViewName("adminjsps/bill");
		return md;
	}
	
}
