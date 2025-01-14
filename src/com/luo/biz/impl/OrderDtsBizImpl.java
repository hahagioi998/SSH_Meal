package com.luo.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luo.biz.OrderDtsBiz;
import com.luo.dao.OrderDtsDAO;
import com.luo.entity.Orderdts;
@Service @Transactional
public class OrderDtsBizImpl implements OrderDtsBiz {
	@Resource OrderDtsDAO orderDtsDAO;
    /**
     * 生成订单子表
     */
	@Override
	public void addOrderDts(Orderdts dts) {
		orderDtsDAO.addOrderDts(dts);
	}
	/**
	 * 根据订单主编号获取订单的详细信息
	 */
	@Override
	public List getOrderDtsByOid(int oId) {
		
		return orderDtsDAO.getOrderDtsByOid(oId);
	}

}
