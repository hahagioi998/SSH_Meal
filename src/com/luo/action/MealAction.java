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
	private File doc;//封装上传文件的属性
	private String docFileName;//封装上传文件的名称
	private String docContentType;//封装上传文件的格式
	private String type;//封装注销用户类型
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
	//定义meal类型属性，用于封装表单参数
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
	//定义分类属性用于封装参数
	private Feilei feilei;
	
	
	public Feilei getFeilei() {
		return feilei;
	}
	public void setFeilei(Feilei feilei) {
		this.feilei = feilei;
	}
	//分页实体类
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
    //获取指定页码，符合查询条件的菜品列表，再转到菜品显示页show.jsp
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
		data.add("心好塞");
		int curPage = 1;
		if(pager!=null)
			curPage = pager.getCurPage();
		List mealList = null;
		if(meal!=null){//meal不为空，表示表单中输入了查询条件
			//此时获取符合查询条件的，指定页码的菜品列表
			mealList = mealBiz.getMealByCondition(meal, curPage);
			//统计符合查询条件的菜品数量，初始化分页类，设置其每页显示数，和总数
			pager = mealBiz.getPagerOfMeal(meal);
			//将查询条件保存到request中,将作为分页超链接的参数值
			if((meal.getMealseries()!=null)&&(meal.getMealseries().getSeriesId()!=null))
				request.put("seriesId", new Integer(meal.getMealseries().getSeriesId()));
			if((meal.getMealName()!=null)&& !meal.getMealName().equals(""))
				request.put("mealName", meal.getMealName());
			
		}else{
			//meal为空，表示没有指定查询条件，此时将获取指定页码的菜品列表
			mealList = mealBiz.getAllMeal(curPage);
			//用获取到的所有菜品数量来初始化分页类pager对象,并设置其每页记录数和总记录数
			pager = mealBiz.getPagerOfMeal();
			
		}
		pager.setCurPage(curPage);
		request.put("mealList", mealList);
		List mealSeriesList = mealSeriesBiz.getMealSeries();
		request.put("mealSeriesList", mealSeriesList);
		List headtitle = mealBiz.getAllTitle();//获取所有的title
		request.put("headtitle", headtitle);
		
		return "toShowMeal";
	}
	/**
	 * 先获取菜系列表，在转到菜品添加页
	 * @return
	 * @throws Exception
	 */
	public String toAddMeal()throws Exception{
		List mealSeriesList = mealSeriesBiz.getMealSeries();
		request.put("mealSeriesList", mealSeriesList);
		return "addMeal";
	}
	/**
	 * //重命名上传文件    
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
	 * 上传菜品图片 ，菜品信息再转到菜品菜品显示页
	 * @return
	 * @throws Exception
	 */
	public String addMeal()throws Exception{
		if(docFileName!=null){//判断是否上传了文件
			//得到项目下所在图片文件夹的绝对路劲，没有则会创建
			String targetDirectory = ServletActionContext.getServletContext().getRealPath("/mealimages");
			//重命名上传文件名
			String targetFileName = generateFileName(docFileName);
			//在指定目录创建文件夹
			File target = new File(targetDirectory,targetFileName);
			FileUtils.copyFile(doc, target);
			meal.setMealImage(targetFileName);
			mealBiz.addMeal(meal);
		}
		return "doShowMeal";
	}
	/**
	 * 管理菜品
	 * @return
	 * @throws Exception
	 */
	public String toManageMeal()throws Exception{
		int curPage = 1;
		if(pager!=null)
			curPage = pager.getCurPage();
		List mealList = null;
		if(meal!=null){//meal不为空，表示表单中输入了查询条件
			//此时获取符合查询条件的，指定页码的菜品列表
			mealList = mealBiz.getMealByCondition(meal, curPage);
			//统计符合查询条件的菜品数量，初始化分页类，设置其每页显示数，和总数
			pager = mealBiz.getPagerOfMeal(meal);
			//将查询条件保存到request中,将作为分页超链接的参数值
			if((meal.getMealseries()!=null)&&(meal.getMealseries().getSeriesId()!=null))
				request.put("seriesId", new Integer(meal.getMealseries().getSeriesId()));
			if((meal.getMealName()!=null)&& !meal.getMealName().equals(""))
				request.put("mealName", meal.getMealName());
			
		}else{
			//meal为空，表示没有指定查询条件，此时将获取指定页码的菜品列表
			mealList = mealBiz.getAllMeal(curPage);
			//用获取到的所有菜品数量来初始化分页类pager对象,并设置其每页记录数和总记录数
			pager = mealBiz.getPagerOfMeal();
			
		}
		pager.setCurPage(curPage);
		request.put("mealList", mealList);
		List mealSeriesList = mealSeriesBiz.getMealSeries();
		request.put("mealSeriesList", mealSeriesList);
		return "manageMeal";
	}
	/**
	 * 先获取指定修改的菜品，在转到菜品修改页
	 * @return
	 * @throws Exception
	 */
	public String toUpdateMeal()throws Exception{
		//根据菜名id获取菜品
		Meal updateMeal = mealBiz.getMealById(meal.getMealId());
		request.put("updateMeal", updateMeal);
		//获取菜系
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
		//更新菜品
		mealBiz.updateMeal(meal);
		return "toShowMeal";
	}
	/**
	 * 删除菜品
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
	 * 先根据id获取食品详情，再转到食品详情页
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
	 * 菜系管理
	 * @return
	 * @throws Exception
	 */
	public String mealseriesmanager()throws Exception{
		List mealseriesmanagerlist = mealSeriesBiz.getMealSeries();
		request.put("mealseriesmanagerlist", mealseriesmanagerlist);
		return "mealseriesmanager";
	}
}
