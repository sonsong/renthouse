package com.hss.renthouse.admins.contract.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import com.hss.renthouse.admins.Log.annotation.SystemControllerAnnotation;
import com.hss.renthouse.admins.admin.entity.Admin;
import com.hss.renthouse.admins.contract.entity.Contract;
import com.hss.renthouse.admins.contract.service.interfaces.ContractService;
import com.hss.renthouse.user.house.entity.House;
import com.hss.renthouse.user.house.service.interfaces.HouseService;
import com.hss.renthouse.util.BPageBean;
import com.hss.renthouse.util.BQueryVo;

/**
 * 合同controller层
 * @author hss
 *
 */
@Controller
@RequestMapping( value="/admin" )
public class ContractController {

	private static final Logger logger = LoggerFactory.getLogger(ContractController.class);
	
	@Autowired
	private ContractService contractService;
	@Autowired
	private HouseService houseService;
	
	/**
	 * 查询所有的合同
	 * @param vo
	 * @return
	 */
	@ResponseBody
	@RequestMapping( value = "/queryAllContract.action")
	public BPageBean<Contract> queryAllContract(BQueryVo vo) {
		return contractService.queryAllContract(vo);
	}
	
	/**
	 * 生成合同
	 * @param aid 预约编码
	 * @param con 合同
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping( value= "/addContract.action" )
	@SystemControllerAnnotation( value="生成合同" )
	public String addContract(String aid, Contract con, HttpSession session, 
			RedirectAttributesModelMap model){
		
		Admin admin = (Admin) session.getAttribute("admin");
		String msg = "";
		String returnUrl = "";
		
		//判断改房源是否出租了，防止多个预约租用用一个房源
		House house = houseService.queryHouseByHid(con.getHid());
		if("1".equals(house.getHstate())){
			//房子出租了
			returnUrl = "redirect:/admin/skipAppointPage.action";
			model.addFlashAttribute("msg", "该预约的房源已经租出去啦，请及时通知该客户");
			return returnUrl;
		}
		//生成合同成功后，需要将预约中的该条预约删除，同时在预约结果中加入一条记录
		try {
			//设置操作者
			con.setAdid(admin.getAid());
			contractService.addContract(con, aid);
			msg = "签约成功";
			returnUrl = "redirect:/admin/skipCustomPage.action";
		} catch (Exception e) {
			msg = e.getMessage();
			model.addFlashAttribute("contract", con);
			//回到看房预约页面
			returnUrl = "redirect:/admin/skipAppointPage.action";
		}
		
		model.addFlashAttribute("msg", msg);
		logger.info("{}" + msg + "!", admin.getAname());
		return returnUrl;
	}
	
	/**
	 * 跳转到房客合同管理页面
	 * @return
	 */
	@RequestMapping( value="/skipRenterPage.action" )
	public ModelAndView skipRenterPage(){
		ModelAndView md = new ModelAndView();
		
		md.setViewName("adminjsps/contract");
		return md;
	}
}
