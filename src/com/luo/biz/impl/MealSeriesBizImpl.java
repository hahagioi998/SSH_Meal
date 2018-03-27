package com.luo.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luo.biz.MealSeriesBiz;
import com.luo.dao.MealSeriesDAO;
@Service@Transactional
public class MealSeriesBizImpl implements MealSeriesBiz {
   @Resource MealSeriesDAO mealSeriesDAO;
   /**
    * ��ȡ��ϵ�б�
    */
	@Override
	public List getMealSeries() {		
		return mealSeriesDAO.getMealSeries();
	}

}
