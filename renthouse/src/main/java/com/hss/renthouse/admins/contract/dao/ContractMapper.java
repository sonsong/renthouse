package com.hss.renthouse.admins.contract.dao;

import com.hss.renthouse.admins.contract.entity.Contract;

/**
 * 合同dao层接口
 * @author hss
 *
 */
public interface ContractMapper {

	/**
	 * 生成合同
	 * @param con
	 * @return
	 */
	public int addContract(Contract con);

}
