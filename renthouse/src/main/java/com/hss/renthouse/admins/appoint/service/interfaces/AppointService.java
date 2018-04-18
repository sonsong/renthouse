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
	 * @param aid 正在取消的预约
	 */
	void cancelByAid(AppointResult appointResult, String aid);

	/**
	 * 查询所有预约结果
	 * @param vo
	 * @return
	 */
	BPageBean<AppointResult> queryAllAppointResults(BQueryVo vo);

}
