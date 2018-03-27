package com.luo.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luo.biz.MealBiz;
import com.luo.dao.MealDAO;
import com.luo.entity.Feilei;
import com.luo.entity.Meal;
import com.luo.entity.Pager;
@Service@Transactional
public class MealBizImpl implements MealBiz {
    @Resource MealDAO mealDAO;
    /**
     * ��ȡָ��ҳ�����в�Ʒ
     */
	@Override
	public List getAllMeal(int page) {
		
		return mealDAO.getAllMeal(page);
	}
    /**
     * ��ȡ���еĲ�Ʒ������������ʼ��Pager���󣬲�������ÿҳ��ʾ��perPagerCount�ͼ�¼����RowCount
     */
	@Override
	public Pager getPagerOfMeal() {
		int count = mealDAO.getCountofAllMeal();//��ȡ���еĲ�Ʒ����
		Pager pager = new Pager();//ʹ�÷�ҳ�ඨ�����
		pager.setPerPageRows(12);//����ÿҳ��¼��
		pager.setRowCount(count);//���ü�¼����
		return pager;
	}
    /**
     * ���ݲ�ѯ��������ȡָ��ҳ�Ĳ�Ʒ�б�
     */
	@Override
	public List getMealByCondition(Meal condition, int page) {
		
		return mealDAO.getMealByCondition(condition, page);
	}
    /**
     * ͳ�Ʒ��ϲ�ѯ�����Ĳ�Ʒ����������ʼ����ҳ�����������ÿҳ��ʾ��¼��perPagerCOunt�ͼ�¼����
     */
	@Override
	public Pager getPagerOfMeal(Meal condition) {
		int count = mealDAO.getCountOfMeal(condition);//��ȡ���з��ϲ�ѯ�����Ĳ�Ʒ����
		Pager pager = new Pager();//ʹ��Pager�������
		pager.setPerPageRows(12);
		pager.setRowCount(count);
		return pager;
	}
	/**
	 * ���ݲ�Ʒ��ż��ز�Ʒ
	 */
	@Override
	public Meal getMealById(int mealId) {		
		return mealDAO.getMealById(mealId);
	}
	/**
	 * ���Ӳ�Ʒ
	 */
	@Override
	public void addMeal(Meal meal) {
		mealDAO.addMeal(meal);
	}
	/**
	 * �޸Ĳ�Ʒ
	 */
	@Override
	public void updateMeal(Meal meal) {
		mealDAO.updateMeal(meal);
	}
	/**
	 * ɾ��ָ����ŵĲ�Ʒ
	 */
	@Override
	public void deleteMeal(int mealId) {
		Meal meal = mealDAO.getMealById(mealId);
		mealDAO.deleteMeal(meal);
	}
	/**
	 * ��ȡ���еı���
	 */
	@Override
	public List getAllTitle() {
		return mealDAO.getAllTitle();
	}
	/**
	 * ���ݱ���id��ȡָ������
	 */
	@Override
	public List getFeileiByTitleId(Feilei condition) {
		
		return mealDAO.getFeileiByTitleId(condition);
	}

}