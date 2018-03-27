package com.luo.action;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.springframework.stereotype.Controller;

import com.luo.biz.MealBiz;
import com.luo.biz.MealSeriesBiz;
import com.luo.entity.Feilei;
import com.luo.entity.Meal;
import com.luo.entity.Pager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
public class MealAction extends ActionSupport implements RequestAware {
	@Resource MealBiz mealBiz;
	@Resource MealSeriesBiz mealSeriesBiz;
	private List<String> data = new ArrayList<String>();

	public List<String> getData() {
		return data;
	}

	public void setData(List<String> data) {
		this.data = data;
	}
	private File doc;//��װ�ϴ��ļ�������
	private String docFileName;//��װ�ϴ��ļ�������
	private String docContentType;//��װ�ϴ��ļ��ĸ�ʽ
	private String type;//��װע���û�����
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public File getDoc() {
		return doc;
	}
	public void setDoc(File doc) {
		this.doc = doc;
	}
	public String getDocFileName() {
		return docFileName;
	}
	public void setDocFileName(String docFileName) {
		this.docFileName = docFileName;
	}
	public String getDocContentType() {
		return docContentType;
	}
	public void setDocContentType(String docContentType) {
		this.docContentType = docContentType;
	}
	//����meal�������ԣ����ڷ�װ��������
	private Meal meal;
	public Meal getMeal() {
		return meal;
	}
	public void setMeal(Meal meal) {
		this.meal = meal;
	}
	private int mealId;
	
	public int getMealId() {
		return mealId;
	}
	public void setMealId(int mealId) {
		this.mealId = mealId;
	}
	//��������������ڷ�װ����
	private Feilei feilei;
	
	
	public Feilei getFeilei() {
		return feilei;
	}
	public void setFeilei(Feilei feilei) {
		this.feilei = feilei;
	}
	//��ҳʵ����
    private	Pager pager ;
    public Pager getPager() {
		return pager;
	}
	public void setPager(Pager pager) {
		this.pager = pager;
	}
	
    Map<String, Object>request;
	@Override
	public void setRequest(Map<String, Object> request) {
		this .request = request;
	}
    //��ȡָ��ҳ�룬���ϲ�ѯ�����Ĳ�Ʒ�б�����ת����Ʒ��ʾҳshow.jsp
	public String toShowMeal()throws Exception{
		data.add("admin1");
		data.add("admin2");
		data.add("admin3");
		data.add("admin14");
		data.add("apple");
		data.add("byte");
		data.add("cname");
		data.add("city");
		data.add("admin8");
		data.add("admin10");
		data.add("�ĺ���");
		int curPage = 1;
		if(pager!=null)
			curPage = pager.getCurPage();
		List mealList = null;
		if(meal!=null){//meal��Ϊ�գ���ʾ�����������˲�ѯ����
			//��ʱ��ȡ���ϲ�ѯ�����ģ�ָ��ҳ��Ĳ�Ʒ�б�
			mealList = mealBiz.getMealByCondition(meal, curPage);
			//ͳ�Ʒ��ϲ�ѯ�����Ĳ�Ʒ��������ʼ����ҳ�࣬������ÿҳ��ʾ����������
			pager = mealBiz.getPagerOfMeal(meal);
			//����ѯ�������浽request��,����Ϊ��ҳ�����ӵĲ���ֵ
			if((meal.getMealseries()!=null)&&(meal.getMealseries().getSeriesId()!=null))
				request.put("seriesId", new Integer(meal.getMealseries().getSeriesId()));
			if((meal.getMealName()!=null)&& !meal.getMealName().equals(""))
				request.put("mealName", meal.getMealName());
			
		}else{
			//mealΪ�գ���ʾû��ָ����ѯ��������ʱ����ȡָ��ҳ��Ĳ�Ʒ�б�
			mealList = mealBiz.getAllMeal(curPage);
			//�û�ȡ�������в�Ʒ��������ʼ����ҳ��pager����,��������ÿҳ��¼�����ܼ�¼��
			pager = mealBiz.getPagerOfMeal();
			
		}
		pager.setCurPage(curPage);
		request.put("mealList", mealList);
		List mealSeriesList = mealSeriesBiz.getMealSeries();
		request.put("mealSeriesList", mealSeriesList);
		List headtitle = mealBiz.getAllTitle();//��ȡ���е�title
		request.put("headtitle", headtitle);
		
		return "toShowMeal";
	}
	/**
	 * �Ȼ�ȡ��ϵ�б�����ת����Ʒ����ҳ
	 * @return
	 * @throws Exception
	 */
	public String toAddMeal()throws Exception{
		List mealSeriesList = mealSeriesBiz.getMealSeries();
		request.put("mealSeriesList", mealSeriesList);
		return "addMeal";
	}
	/**
	 * //�������ϴ��ļ�    
	 * @param fileName
	 * @return
	 */
    public String generateFileName(String fileName){          
    	String formatDate = new SimpleDateFormat("yyMMddHHmmss").format(new Date());          
    	int random = new Random().nextInt(10000);          
    	int position = fileName.lastIndexOf(".");          
    	String extension = fileName.substring(position);           
    	return formatDate + random + extension;      
    }    
	/**
	 * �ϴ���ƷͼƬ ����Ʒ��Ϣ��ת����Ʒ��Ʒ��ʾҳ
	 * @return
	 * @throws Exception
	 */
	public String addMeal()throws Exception{
		if(docFileName!=null){//�ж��Ƿ��ϴ����ļ�
			//�õ���Ŀ������ͼƬ�ļ��еľ���·����û����ᴴ��
			String targetDirectory = ServletActionContext.getServletContext().getRealPath("/mealimages");
			//�������ϴ��ļ���
			String targetFileName = generateFileName(docFileName);
			//��ָ��Ŀ¼�����ļ���
			File target = new File(targetDirectory,targetFileName);
			FileUtils.copyFile(doc, target);
			meal.setMealImage(targetFileName);
			mealBiz.addMeal(meal);
		}
		return "doShowMeal";
	}
	/**
	 * ������Ʒ
	 * @return
	 * @throws Exception
	 */
	public String toManageMeal()throws Exception{
		int curPage = 1;
		if(pager!=null)
			curPage = pager.getCurPage();
		List mealList = null;
		if(meal!=null){//meal��Ϊ�գ���ʾ�����������˲�ѯ����
			//��ʱ��ȡ���ϲ�ѯ�����ģ�ָ��ҳ��Ĳ�Ʒ�б�
			mealList = mealBiz.getMealByCondition(meal, curPage);
			//ͳ�Ʒ��ϲ�ѯ�����Ĳ�Ʒ��������ʼ����ҳ�࣬������ÿҳ��ʾ����������
			pager = mealBiz.getPagerOfMeal(meal);
			//����ѯ�������浽request��,����Ϊ��ҳ�����ӵĲ���ֵ
			if((meal.getMealseries()!=null)&&(meal.getMealseries().getSeriesId()!=null))
				request.put("seriesId", new Integer(meal.getMealseries().getSeriesId()));
			if((meal.getMealName()!=null)&& !meal.getMealName().equals(""))
				request.put("mealName", meal.getMealName());
			
		}else{
			//mealΪ�գ���ʾû��ָ����ѯ��������ʱ����ȡָ��ҳ��Ĳ�Ʒ�б�
			mealList = mealBiz.getAllMeal(curPage);
			//�û�ȡ�������в�Ʒ��������ʼ����ҳ��pager����,��������ÿҳ��¼�����ܼ�¼��
			pager = mealBiz.getPagerOfMeal();
			
		}
		pager.setCurPage(curPage);
		request.put("mealList", mealList);
		List mealSeriesList = mealSeriesBiz.getMealSeries();
		request.put("mealSeriesList", mealSeriesList);
		return "manageMeal";
	}
	/**
	 * �Ȼ�ȡָ���޸ĵĲ�Ʒ����ת����Ʒ�޸�ҳ
	 * @return
	 * @throws Exception
	 */
	public String toUpdateMeal()throws Exception{
		//���ݲ���id��ȡ��Ʒ
		Meal updateMeal = mealBiz.getMealById(meal.getMealId());
		request.put("updateMeal", updateMeal);
		//��ȡ��ϵ
		List mealSeriesList = mealSeriesBiz.getMealSeries();
		request.put("mealSeriesList", mealSeriesList);
		return "updateMeal";
	}
	public String doUpdateMeal()throws Exception{
		if(docFileName!=null){
			String targetDirectory = ServletActionContext.getServletContext().getRealPath("/mealimages");
			String targetFileName = generateFileName(docFileName);
			File target = new File(targetDirectory,targetFileName);
			FileUtils.copyFile(doc, target);
			meal.setMealImage(targetFileName);
		}
		//���²�Ʒ
		mealBiz.updateMeal(meal);
		return "toShowMeal";
	}
	/**
	 * ɾ����Ʒ
	 * @return
	 * @throws Exception
	 */
	public String deleteMeal()throws Exception{
		mealBiz.deleteMeal(meal.getMealId());
		return "toManageMeal";
	}
	public String getTitle()throws Exception{
		List feileilist = mealBiz.getFeileiByTitleId(feilei);
		request.put("feileilist", feileilist);
		return "title";
	}
	public String logout()throws Exception{
		if(type.equals("userlogout")){
			 ActionContext.getContext().getSession().remove("user");
		}if(type.equals("adminlogout")){
			ActionContext.getContext().getSession().remove("admin");
		}
	   
		return "out";
	}
	/**
	 * �ȸ���id��ȡʳƷ���飬��ת��ʳƷ����ҳ
	 * @return
	 * @throws Exception
	 */
	public  String tomealdetail()throws Exception{
		Meal meal = mealBiz.getMealById(mealId);
		List mealseriesList = mealSeriesBiz.getMealSeries();
		request.put("mealseriesList", mealseriesList);
		request.put("meal", meal);
		return "mealdetail";
	}
	/**
	 * ��ϵ����
	 * @return
	 * @throws Exception
	 */
	public String mealseriesmanager()throws Exception{
		List mealseriesmanagerlist = mealSeriesBiz.getMealSeries();
		request.put("mealseriesmanagerlist", mealseriesmanagerlist);
		return "mealseriesmanager";
	}
}