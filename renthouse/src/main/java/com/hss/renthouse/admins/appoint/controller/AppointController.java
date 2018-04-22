package com.hss.renthouse.admins.appoint.controller;

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
import com.hss.renthouse.admins.appoint.entity.Appoint;
import com.hss.renthouse.admins.appoint.entity.AppointResult;
import com.hss.renthouse.admins.appoint.entity.Join;
import com.hss.renthouse.admins.appoint.service.interfaces.AppointService;
import com.hss.renthouse.utils.BPageBean;
import com.hss.renthouse.utils.BQueryVo;
import com.hss.renthouse.utils.DateUtil;

/**
 * 预约管理控制层
 * @author hss
 *
 */

@Controller
@RequestMapping( value = "/admin")
public class AppointController {
	
	private static final Logger logger = LoggerFactory.getLogger(AppointController.class);
	
	@Autowired
	private AppointService appointService;
	
	/**
	 * 取消预约
	 * @param aid 正在取消的预约
	 * @param appointResult
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping( value = "/cancelAppoint.action")
	@SystemControllerAnnotation(value = "取消预约")
	public String cancelAppoint(String aid, AppointResult appointResult, HttpSession session,
			RedirectAttributesModelMap model){
		
		Admin admin = (Admin) session.getAttribute("admin");
		String msg = "";
		String returnUrl = "";
		
		//取消预约，将该编码的预约从预约表中删除，同时在预约结果表中增加一条结果
		try {
			//设置操作人
			appointResult.setAdid(admin.getAid());
			//设置操作时间
			String date = DateUtil.getNowTime();
			appointResult.setCtime(date);
			appointService.cancelByAid(appointResult, aid);
			msg = "取消预约[" + aid + "]成功";
			//跳转到预约结果页面
			returnUrl = "redirect:/admin/skipAppointResultPage.action";
		} catch (Exception e) {
			msg = e.getMessage();
			//回到原页面
			returnUrl = "redirect:/admin/skipAppointPage.action";
		}
		
		logger.info("{}" + msg + "!", admin.getAname());
		return returnUrl;
	}
	
	/**
	 * 查询所有的预约结果
	 * @param vo
	 * @return
	 */
	@ResponseBody
	@RequestMapping( value = "/queryAllAppointResults.action")
	public BPageBean<AppointResult> queryAllAppointResults(BQueryVo vo) {
		return appointService.queryAllAppointResults(vo);
	}
	/**
	 * 查询所有的业主加盟
	 * @param vo
	 * @return
	 */
	@ResponseBody
	@RequestMapping( value = "/queryAllJoins.action")
	public BPageBean<Join> queryAllJoins(BQueryVo vo) {
		return appointService.queryAllJoins(vo);
	}
	
	/**
	 * 查询所有的预约
	 * @param vo
	 * @return
	 */
	@ResponseBody
	@RequestMapping( value = "/queryAllAppoints.action")
	public BPageBean<Appoint> queryAllAppoints(BQueryVo vo) {
		return appointService.queryAllAppoints(vo);
	}
	
	/**
	 * 跳转到预约结果页面
	 * @return
	 */
	@RequestMapping( value="/skipAppointResultPage.action" )
	public ModelAndView skipAppointResultPage(){
		ModelAndView md = new ModelAndView();
		
		md.setViewName("adminjsps/appointResult");
		return md;
	}
	
	/**
	 * 跳转到业主加盟管理页面
	 * @return
	 */
	@RequestMapping( value="/skipJoinAppointPage.action" )
	public ModelAndView skipJoinAppointPage(){
		ModelAndView md = new ModelAndView();
		
		md.setViewName("adminjsps/join");
		return md;
	}
	
	/**
	 * 跳转到看房预约页面
	 * @return
	 */
	@RequestMapping( value = "/skipAppointPage.action")
	public ModelAndView skipAppointPage(){
		ModelAndView md = new ModelAndView();
		
		md.setViewName("adminjsps/appoint");
		return md;
	}

}
