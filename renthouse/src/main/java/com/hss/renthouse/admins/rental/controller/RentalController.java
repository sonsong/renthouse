package com.hss.renthouse.admins.rental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hss.renthouse.admins.rental.entity.Rental;
import com.hss.renthouse.admins.rental.service.interfaces.RentalService;
import com.hss.renthouse.utils.BPageBean;
import com.hss.renthouse.utils.BQueryVo;

/**
 * 租金controller
 * 
 * @author hss
 *
 */
@Controller
@RequestMapping( value = "/admin")
public class RentalController {

	@Autowired
	private RentalService rentalService;

	/**
	 * 查询所有的租金
	 * 
	 * @param vo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/queryAllRentals.action")
	public BPageBean<Rental> queryAllRentals(BQueryVo vo) {
		return rentalService.queryAllRenters(vo);
	}

	/**
	 * 跳转到租金管理页面
	 * 
	 * @return
	 */
	@RequestMapping( value = "/skipRMoneyPage.action")
	public ModelAndView skipRMoneyPage() {
		ModelAndView md = new ModelAndView();

		md.setViewName("adminjsps/rental");
		return md;
	}
}
