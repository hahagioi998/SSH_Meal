package com.luo.entity;

import java.util.HashSet;
import java.util.Set;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * �ӷ���ʵ���࣬�������һ�Զ�Ĺ�ϵ
 * @author Administrator
 *
 */
public class SonFeilei {
	private Integer id;//�ӷ�����
	private String name;
	private Feilei feilei;
	private Set titleMeal = new HashSet(0);
	
 	public Set getTitleMeal() {
		return titleMeal;
	}
	public void setTitleMeal(Set titleMeal) {
		this.titleMeal = titleMeal;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Feilei getFeilei() {
		return feilei;
	}
	public void setFeilei(Feilei feilei) {
		this.feilei = feilei;
	}
	

}
