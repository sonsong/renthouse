package com.hss.renthouse.admins.contract.dao;

import java.util.List;

import com.hss.renthouse.admins.contract.entity.Contract;
import com.hss.renthouse.util.BQueryVo;

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

	/**
	 * 查询合同的总数
	 * @return
	 */
	public Integer queryContractsTotal();

	/**
	 * 查询所有合同
	 * @param vo
	 * @return
	 */
	public List<Contract> queryAllContracts(BQueryVo vo);

}
