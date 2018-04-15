package com.hss.renthouse.user.user.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import com.hss.renthouse.user.house.entity.House;
import com.hss.renthouse.user.house.service.interfaces.HouseService;
import com.hss.renthouse.user.user.entity.User;
import com.hss.renthouse.user.user.service.interfaces.UserService;
import com.hss.renthouse.util.MD5Util;
import com.hss.renthouse.util.Message;

/**
 * 用户控制层 包含登陆注册
 * 
 * @author hss
 *
 */
@Controller
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private HouseService houseService;

	/**
	 * 更新用户信息
	 * 
	 * @param newPasswd
	 *            新密码
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/user/updateUser.action")
	public String updateUser(String newPasswd, User user, 
			HttpSession session, RedirectAttributesModelMap model) {

		String msg = null;
		if (newPasswd != null && newPasswd.trim().length() > 0) {
			// 赋值新密码
			try {
				String saltpass = MD5Util.EncoderByMd5(newPasswd + user.getUtele() + "huangss");
				user.setUpasswd(saltpass);
			} catch (NoSuchAlgorithmException e) {
				msg = "更新用户信息失败";
			} catch (UnsupportedEncodingException e) {
				msg = "更新用户信息失败";
			}
		}

		try {
			userService.updateUser(user);
			session.setAttribute("user", user);
			msg = "更新用户信息成功";

		} catch (Exception e) {
			msg = e.getMessage();
		}

		model.addFlashAttribute("msg", msg);
		return "redirect:/skipPersonInfoPage.action";
	}

	/**
	 * 校验旧密码是否输入正确
	 * 
	 * @param upasswd
	 *            旧密码
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/checkUpasswd.action")
	public Message checkUpasswd(String upasswd, HttpSession session) {
		Message mess = null;

		// 得到当前用户
		User user = (User) session.getAttribute("user");
		// 给密码进行加盐处理
		String saltpass = "";
		try {
			saltpass = MD5Util.EncoderByMd5(upasswd + user.getUtele() + "huangss");
		} catch (NoSuchAlgorithmException e) {
			mess = new Message("您输入的旧密码不正确，请重新输入", "false");
		} catch (UnsupportedEncodingException e) {
			mess = new Message("您输入的旧密码不正确，请重新输入", "false");
		}

		// 进行校验
		if (user.getUpasswd().equals(saltpass)) {
			mess = new Message("", "true");
		} else {
			mess = new Message("您输入的旧密码不正确，请重新输入", "false");
		}

		return mess;
	}

	/**
	 * 退出登陆
	 * 
	 * @return
	 */
	@RequestMapping(value = "/user/exit.action")
	public String exit(HttpSession session) {
		// 注销session, 返回到首页
		session.invalidate();
		return "redirect:/skipIndexPage.action";
	}

	/**
	 * 登陆
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/login.action")
	public String login(User user, HttpSession session, String requri,
			HttpServletResponse resp, RedirectAttributesModelMap model) {

		String msgErr = "";
		String url = "";

		if (user != null) {
			String newpass = null;

			// 对密码进行加密处理，加盐
			try {
				newpass = MD5Util.EncoderByMd5(user.getUpasswd() + user.getUtele() + "huangss");
			} catch (NoSuchAlgorithmException e) {
				msgErr = "电话号码\\密码错误";
			} catch (UnsupportedEncodingException e) {
				msgErr = "电话号码\\密码错误";
			}

			// 登陆
			try {
				user.setUpasswd(newpass);
				user = userService.login(user);

				// 登陆成功，将用户信息存入session中
				session.setAttribute("user", user);
				// 将用户信息出入cookie中
				Cookie c = new Cookie("utele", user.getUtele());
				c.setMaxAge(60 * 60 * 24);
				resp.addCookie(c);

				if(requri != null && !StringUtils.isEmpty(requri)){
					url = "redirect:" + requri;
				}else{
					url = "redirect:/skipIndexPage.action";
				}
				// 重定向到url
				return url;
			} catch (Exception e) {
				msgErr = e.getMessage();
			}

		} else {
			msgErr = "电话号码\\密码错误";
		}

		// 返回登陆页面
		model.addFlashAttribute("msg", msgErr);
		model.addFlashAttribute("utele", user.getUtele());
		return "redirect:/skipLoginPage.action";
	}

	/**
	 * 用户注册
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/regist.action")
	public String regist(User user, RedirectAttributesModelMap model) {
		try {

			// 对密码进行加密处理，加盐
			String newpass = MD5Util.EncoderByMd5(user.getUpasswd() + user.getUtele() + "huangss");
			user.setUpasswd(newpass);

			userService.regist(user);

			// 注册成功的话，跳转到登陆页面
			model.addFlashAttribute("msg", "恭喜你您呐，注册成功啦，快去登陆吧");
			return "redirect:/skipLoginPage.action";
		} catch (Exception e) {
			// 注册失败，返回注册页面，给出提示
			model.addFlashAttribute("msgErr", e.getMessage());
		}

		// 将用户填写的信息返回给用户
		model.addFlashAttribute("userinput", user);
		return "redirect:/skipRegistPage.action";
	}

	/**
	 * 校验验证码的正确性
	 * 
	 * @param vcode
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/checkVcode.action")
	public Message checkVcode(String vcode, HttpSession session) {
		Message mess = null;

		// 得到session中存储的验证码
		String code = (String) session.getAttribute("vCode");
		// 判断
		if (vcode == null || !(vcode.equalsIgnoreCase(code))) {
			mess = new Message("验证码输入错误", "false");
		} else {
			mess = new Message("", "true");
		}

		return mess;
	}

	/**
	 * 判断电话号码是否被注册 注册进行的判断，注册了需要提示
	 * 
	 * @param utele
	 *            登陆的电话号码
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/checkUteleIsExist.action")
	public Message checkUteleIsExist(String utele) {
		Message mess = null;

		try {
			userService.checkUteleIsExist(utele);
			mess = new Message("", "true");
		} catch (Exception e) {
			mess = new Message(e.getMessage(), "false");
		}

		return mess;
	}

	/**
	 * 判断电话号码是否被注册 登陆进行的判断，未注册需要提示
	 * 
	 * @param utele
	 *            登陆的电话号码
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/checkTelephoneIsExist.action")
	public Message checkTelephoneIsExist(String utele) {
		Message mess = null;

		try {
			userService.checkTelephoneIsExist(utele);
			mess = new Message("", "true");
		} catch (Exception e) {
			mess = new Message(e.getMessage(), "false");
		}

		return mess;
	}

	/**
	 * 跳转到个人中心
	 * 
	 * @return
	 */
	@RequestMapping(value = "/user/skipPersonInfoPage.action")
	public ModelAndView skipPersonInfoPage() {
		ModelAndView md = new ModelAndView();

		md.setViewName("userjsps/personInfo");
		return md;
	}

	/**
	 * 跳转到注册页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/skipRegistPage.action")
	public ModelAndView skipRegistPage() {
		ModelAndView md = new ModelAndView();

		md.setViewName("userjsps/regist");
		return md;
	}

	/**
	 * 跳转到主页
	 * 
	 * @return
	 */
	@RequestMapping(value = "/skipIndexPage.action")
	public ModelAndView skipIndexPage() {
		ModelAndView md = new ModelAndView();

		//获得展示房源
		List<House> hs = houseService.queryHouses();
		
		md.addObject("hs", hs);
		md.setViewName("userjsps/index");
		return md;
	}

	/**
	 * 跳转到登陆页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/skipLoginPage.action")
	public ModelAndView skipLoginPage() {
		ModelAndView md = new ModelAndView();

		md.setViewName("userjsps/login");
		return md;
	}
}
