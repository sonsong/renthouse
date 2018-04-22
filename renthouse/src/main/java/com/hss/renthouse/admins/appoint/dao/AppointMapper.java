package com.hss.renthouse.admins.appoint.dao;

import java.util.List;

import com.hss.renthouse.admins.appoint.entity.Appoint;
import com.hss.renthouse.admins.appoint.entity.AppointResult;
import com.hss.renthouse.admins.appoint.entity.Join;
import com.hss.renthouse.utils.BQueryVo;

/**
 * 预约dao层接口
 * @author hss
 *
 */

public interface AppointMapper {

	/**
	 * 查询预约总数
	 * @return
	 */
	Integer queryAppointTotal();

	/**
	 * 查询所有的预约
	 * @param vo
	 * @return
	 */
	List<Appoint> queryAllAppoints(BQueryVo vo);

	/**
	 * 查询所有的加盟
	 * @param vo
	 * @return
	 */
	List<Join> queryAllJoins(BQueryVo vo);

	/**
	 * 查询业主加盟总数
	 * @return
	 */
	Integer queryJoinsTotal();

	/**
	 * 删除预约单
	 * @param aid
	 * @return
	 */
	int delAppointByAid(String aid);

	/**
	 * 新增预约结果
	 * @param appointResult
	 * @return
	 */
	int addAppointResult(AppointResult appointResult);

	/**
	 * 查询预约结果总数
	 * @return
	 */
	Integer queryAppointResultsTotal();

	/**
	 * 查询所有预约结果
	 * @param vo
	 * @return
	 */
	List<AppointResult> queryAllAppointResults(BQueryVo vo);

	/**
	 * 查询指定预约单
	 * @param aid 预约单编码
	 * @return
	 */
	Appoint getAppointByAid(String aid);

}
