package com.luo.biz;

import java.util.List;

import com.luo.entity.Admin;
import com.luo.entity.Users;

public interface UserBiz {
	//��ͨ�û���¼
	public List login(Users condition);
	//����Ա�û���¼
	public List login(Admin condition);
	//�û�ע��
	public void register(Users users);

}
