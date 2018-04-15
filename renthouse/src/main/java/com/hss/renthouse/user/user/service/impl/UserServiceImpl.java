package com.hss.renthouse.user.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hss.renthouse.user.user.dao.UserMapper;
import com.hss.renthouse.user.user.entity.User;
import com.hss.renthouse.user.user.service.interfaces.UserService;
import com.hss.renthouse.util.UUIDUtil;

/**
 * 用户模块service实现类
 * @author hss
 *
 */

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public void checkTelephoneIsExist(String utele) {
		
		Integer count = userMapper.checkTelephoneIsExist(utele);
		if(count == 0){
			throw new RuntimeException("该号码还没有注册，请先注册");
		}
	}

	@Override
	public User login(User user) {
		user = userMapper.getUserByUteleAndUpasswd(user);
		
		if(user == null){
			throw new RuntimeException("电话号码\\密码错误");
		}
		
		return user;
	}

	@Override
	public void checkUteleIsExist(String utele) {
		Integer count = userMapper.checkTelephoneIsExist(utele);
		if(count > 0){
			throw new RuntimeException("该号码已经注册过啦，不能再次注册呢，去登陆吧");
		}
	}

	@Override
	@Transactional
	public void regist(User user) {
		
		//设置用户编码
		String uid = UUIDUtil.getUuid();
		user.setUid(uid);
		
		Integer count = userMapper.regist(user);
		if(count != 1){
			throw new RuntimeException("不好意思啦，注册失败了，反思ing-..-");
		}
	}

	@Override
	@Transactional
	public void updateUser(User user) {
		int count = userMapper.updateUser(user);
		
		if(count != 1){
			throw new RuntimeException("更新用户信息失败");
		}
	}
}
