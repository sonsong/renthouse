package com.hss.renthouse.admins.contract.service.interfaces;

import com.hss.renthouse.admins.contract.entity.Contract;
import com.hss.renthouse.util.BPageBean;
import com.hss.renthouse.util.BQueryVo;

/**
 * 合同service层接口
 * @author hss
 *
 */
public interface ContractService {

	/**
	 * 生成合同
	 * @param con
	 * @param aid 预约编码
	 */
	void addContract(Contract con, String aid);

	/**
	 * 查询所有的合同
	 * @param vo
	 * @return
	 */
	BPageBean<Contract> queryAllContract(BQueryVo vo);

}
