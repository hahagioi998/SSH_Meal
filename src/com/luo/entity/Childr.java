package com.luo.entity;

import java.io.Serializable;

public class Childr implements Serializable{
	private Integer id;
	private String picture;
	private String name;
	private String sumprice;
	private String menu;//��������
	private String fumenu;//��������
	private String chuju;//��������
	private String teppicture1;//��������ͼ1
	private String tepfont1;//������������1
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSumprice() {
		return sumprice;
	}
	public void setSumprice(String sumprice) {
		this.sumprice = sumprice;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public String getFumenu() {
		return fumenu;
	}
	public void setFumenu(String fumenu) {
		this.fumenu = fumenu;
	}
	public String getChuju() {
		return chuju;
	}
	public void setChuju(String chuju) {
		this.chuju = chuju;
	}
	public String getTeppicture1() {
		return teppicture1;
	}
	public void setTeppicture1(String teppicture1) {
		this.teppicture1 = teppicture1;
	}
	public String getTepfont1() {
		return tepfont1;
	}
	public void setTepfont1(String tepfont1) {
		this.tepfont1 = tepfont1;
	}
	
	

}
