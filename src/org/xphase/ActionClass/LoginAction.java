package org.xphase.ActionClass;


import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.xphase.Bean.LoginBean;
import org.xphase.Dao.LoginAthentication;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends ActionSupport implements ModelDriven<LoginBean> {
	
	public static final String SUCCESS = "success";  
	public static final String ERROR = "error";  
	public static final String LOGIN  = "login";  
	public static final String INPUT = "input";  
	public static final String NONE = "none";  	
	
	String b;
	
	//Session holding objects
	private SessionMap<String,Object> sessionMap;  
	
	public SessionMap<String, Object> getSessionMap() {
		return sessionMap;
	}
	public void setSessionMap(SessionMap<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
	private static final long serialVersionUID = 1L;
	LoginBean loginbean = new LoginBean();
	public LoginBean getModel() {
		return loginbean;
	}  
	@Override
	public String execute() throws Exception {
		clearActionErrors();
		//call database authentication 
		if(LoginAthentication.Login(loginbean.getUname(), loginbean.getUpwd())){
			
			Map session = ActionContext.getContext().getSession();
			//session.setAttribute("","");
			session.put("userName", loginbean.getUname());
			
			session.put("logged-in","true");
			
			b = SUCCESS;
		}
		else{
			b = ERROR;
		}	
		return b;
	}
	public String logout() throws Exception {

		  Map session = ActionContext.getContext().getSession();
		  session.remove("logged-in");
		  return SUCCESS;
	}	  
}