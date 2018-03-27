package com.luo.Ajaxaction;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller
public class ShowTimeAction extends ActionSupport implements SessionAware {
	private String message;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String execute() throws Exception {
		long currentTime=System.currentTimeMillis();	//��ȡ��ǰʱ��
		//��ȡ��ʼʱ��
		Long startTime = (Long) session.get("startTime"); 
		if (startTime==null) {	//��һ�η���
			startTime=currentTime;
			session.put("startTime", startTime);
		}
		long usedTime=(currentTime-startTime)/1000/60;	//�Է����������ʵ�ʱ��
		if (usedTime>60) {
			this.setMessage("���Ѿ�����ϵͳ��"+usedTime+" ���ӣ���ע����Ϣ��");
		}else if (usedTime==0) {
			this.setMessage("���տ�ʼ����ϵͳ��ף����죡");
		}else{
			this.setMessage("���Ѿ�����ϵͳ��"+usedTime+"���ӡ�");
		}
		return super.execute();	//����"success"�ַ���
	}	
   private Map session;
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
		
	}

}
