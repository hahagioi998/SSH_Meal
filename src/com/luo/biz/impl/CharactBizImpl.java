package com.luo.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luo.biz.CharactBiz;
import com.luo.dao.CharactDAO;
@Service@Transactional
public class CharactBizImpl implements CharactBiz {
    @Resource CharactDAO charactDAO;
    /**
     * ���ظ�����ɫ���� ��Ʒ
     */
	@Override
	public List getAllChariac() {
		return charactDAO.getAllChariac();
		
	}

}
