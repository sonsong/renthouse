package com.hss.renthouse.admins.appoint.service.interfaces;

import com.hss.renthouse.admins.appoint.entity.Appoint;
import com.hss.renthouse.admins.appoint.entity.AppointResult;
import com.hss.renthouse.admins.appoint.entity.Join;
import com.hss.renthouse.util.BPageBean;
import com.hss.renthouse.util.BQueryVo;

/**
 * 预约管理service层接口
 * @author hss
 *
 */
public interface AppointService {

	/**
	 * 查询所有的看房预约
	 * @param vo
	 * @return
	 */
	BPageBean<Appoint> queryAllAppoints(BQueryVo vo);

	/**
	 * 查询所有的业主加盟
	 * @param vo
	 * @return
	 */
	BPageBean<Join> queryAllJoins(BQueryVo vo);

	/**
	 * 取消预约单
	 * @param appointResult
	 */
	void cancelByAid(AppointResult appointResult);

}
