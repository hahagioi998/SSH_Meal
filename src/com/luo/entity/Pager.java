package com.luo.entity;
/**
 * ��ҳʵ����
 * @author Administrator
 *
 */
public class Pager {
	private int curPage;//����ʾҳ
	private int perPageRows;//һҳ��ʾ��¼��
	private int rowCount;//��¼����
	private int pageCount;//�� ҳ��
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getPerPageRows() {
		return perPageRows;
	}
	public void setPerPageRows(int perPageRows) {
		this.perPageRows = perPageRows;
	}
	public int getRowCount() {
		return rowCount;
	}
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}
	public int getPageCount() {
		return (rowCount+perPageRows-1)/perPageRows;
	}

}
