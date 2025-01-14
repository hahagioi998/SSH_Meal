package com.luo.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luo.biz.UserBiz;
import com.luo.dao.UserDAO;
import com.luo.entity.Admin;
import com.luo.entity.Users;
@Service@Transactional
public class UserBizImpl implements UserBiz {
	@Resource UserDAO userDAO;
    /**
     * 普通用户登录
     */
	@Override
	public List login(Users condition) {
        return userDAO.search(condition);
	}
    /**
     * 管理员登录
     */
	@Override
	public List login(Admin condition) {
		return userDAO.search(condition);
	}
	/**
	 * 用户注册
	 */
	@Override
	public void register(Users users) {
		userDAO.register(users);
	}

}
