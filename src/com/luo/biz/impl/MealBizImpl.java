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
     * 获取指定页的所有菜品
     */
	@Override
	public List getAllMeal(int page) {
		
		return mealDAO.getAllMeal(page);
	}
    /**
     * 获取所有的菜品数量，用来初始化Pager对象，并设置其每页显示数perPagerCount和记录总数RowCount
     */
	@Override
	public Pager getPagerOfMeal() {
		int count = mealDAO.getCountofAllMeal();//获取所有的菜品数量
		Pager pager = new Pager();//使用分页类定义对象
		pager.setPerPageRows(12);//设置每页记录数
		pager.setRowCount(count);//设置记录总数
		return pager;
	}
    /**
     * 根据查询条件，获取指定页的菜品列表
     */
	@Override
	public List getMealByCondition(Meal condition, int page) {
		
		return mealDAO.getMealByCondition(condition, page);
	}
    /**
     * 统计符合查询条件的菜品数量，并初始化分页类对象，设置其每页显示记录数perPagerCOunt和记录总数
     */
	@Override
	public Pager getPagerOfMeal(Meal condition) {
		int count = mealDAO.getCountOfMeal(condition);//获取所有符合查询条件的菜品数量
		Pager pager = new Pager();//使用Pager定义对象
		pager.setPerPageRows(12);
		pager.setRowCount(count);
		return pager;
	}
	/**
	 * 根据菜品编号加载菜品
	 */
	@Override
	public Meal getMealById(int mealId) {		
		return mealDAO.getMealById(mealId);
	}
	/**
	 * 添加菜品
	 */
	@Override
	public void addMeal(Meal meal) {
		mealDAO.addMeal(meal);
	}
	/**
	 * 修改菜品
	 */
	@Override
	public void updateMeal(Meal meal) {
		mealDAO.updateMeal(meal);
	}
	/**
	 * 删除指定编号的菜品
	 */
	@Override
	public void deleteMeal(int mealId) {
		Meal meal = mealDAO.getMealById(mealId);
		mealDAO.deleteMeal(meal);
	}
	/**
	 * 获取所有的标题
	 */
	@Override
	public List getAllTitle() {
		return mealDAO.getAllTitle();
	}
	/**
	 * 根据标题id获取指定分类
	 */
	@Override
	public List getFeileiByTitleId(Feilei condition) {
		
		return mealDAO.getFeileiByTitleId(condition);
	}

}
