package com.luo.dao;

import java.util.List;

import com.luo.entity.Users;

public interface AdminDao {
	//��ҳ��ȡ���е��û���Ϣ�ں�̨��ʾ
	public List pageuser(int pageIndes,int pageSize);
	//��ȡ���е��û���¼�������ڳ�ʼ����ҳ����Ҷ��
	public Integer getUserCount();
	//����id��ȡ��Ӧ���û���Ϣ
	public Users getUsersById(Integer id);
	//�޸��û���Ϣ
	public void doUpdateUser(Users users);
	//ɾ��ָ���û�
	public void deleteUser(Users users);

}
