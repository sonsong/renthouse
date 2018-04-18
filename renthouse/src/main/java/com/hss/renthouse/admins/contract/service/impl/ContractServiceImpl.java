package com.hss.renthouse.admins.contract.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hss.renthouse.admins.appoint.dao.AppointMapper;
import com.hss.renthouse.admins.appoint.entity.Appoint;
import com.hss.renthouse.admins.appoint.entity.AppointResult;
import com.hss.renthouse.admins.contract.dao.ContractMapper;
import com.hss.renthouse.admins.contract.entity.Contract;
import com.hss.renthouse.admins.contract.service.interfaces.ContractService;
import com.hss.renthouse.user.house.dao.HouseMapper;
import com.hss.renthouse.util.DateUtil;
import com.hss.renthouse.util.UUIDUtil;

/**
 * 合同service层实现
 * @author hss
 *
 */

@Service
public class ContractServiceImpl implements ContractService {

	@Autowired
	private ContractMapper contractMapper;
	@Autowired
	private AppointMapper appointMapper;
	@Autowired
	private HouseMapper houserMapper;
	
	@Override
	@Transactional
	public void addContract(Contract con, String aid) {
		//设置合同编码
		con.setCid(UUIDUtil.getUuid());
		//生成合同
		int count = contractMapper.addContract(con);
		
		if(count != 1){
			throw new RuntimeException("签约失败");
		}else{
			//修改房源为已出租
			houserMapper.updateHouseStateByHid(con.getHid());
			//生成预约结果单
			AppointResult ar = new AppointResult();
			//得到该预约单
			Appoint app = appointMapper.getAppointByAid(aid);
			//生成预约结果编码
			ar.setRid(UUIDUtil.getUuid());
			ar.setState(1);
			ar.setResult(1);
			ar.setReason("");
			ar.setAdid(con.getAdid());
			ar.setName(app.getAname());
			ar.setAtele(app.getAtele());
			ar.setAntime(app.getAntime());
			ar.setCtime(DateUtil.getNowTime());
			
			count = appointMapper.addAppointResult(ar);
			
			if(count != 1){
				throw new RuntimeException("签约失败");
			}else{
				//删除预约单
				count = appointMapper.delAppointByAid(aid);
				if(count != 1){
					throw new RuntimeException("签约失败");
				}
			}
		}
	}
}
