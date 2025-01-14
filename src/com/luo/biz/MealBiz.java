package com.luo.biz;

import java.util.List;

import com.luo.entity.Feilei;
import com.luo.entity.Meal;
import com.luo.entity.Pager;

public interface MealBiz {
	//获取指定页显示的菜品列表
	public List getAllMeal(int page);
	//获取所有菜品数量，初始化分页类Pager对象，设置其perPageRows每页记录数，和记录总数Rowcount
	public Pager getPagerOfMeal();
	//根据查询条件，获取指定页显示的菜品列表
	public List getMealByCondition(Meal condition,int page);
	//统计符合查询条件的菜品数量，用来初始化分页类对象,设置其perPageRows每页记录数，和记录总数Rowcount
	public Pager getPagerOfMeal(Meal condition);
	//根据菜品id加载菜品
	public Meal getMealById(int mealId);
	//添加从菜品
	public void addMeal(Meal meal);
	//修改菜品
	public void updateMeal(Meal meal);
	//删除指定编号的菜品
	public void  deleteMeal(int mealId);
	//获取所有的标题
	public List getAllTitle();
	//根据标题查询指定的分类
	public List getFeileiByTitleId(Feilei condition);

}
