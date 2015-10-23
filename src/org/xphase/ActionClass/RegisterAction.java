package org.xphase.ActionClass;

import org.xphase.Bean.RegisterBean;
import org.xphase.Dao.RegisterDao;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class RegisterAction extends ActionSupport implements ModelDriven<RegisterBean> 
{
	private static final long serialVersionUID = 1L;
	public static final String SUCCESS = "success";  
	public static final String ERROR = "error";  
	public static final String LOGIN  = "login";  
	public static final String INPUT = "input";  
	public static final String NONE = "none";
	
	private RegisterBean RegBean = new RegisterBean();
	
	public void setRegBean(RegisterBean regBean) {
		this.RegBean = regBean;
	}

	public RegisterBean getModel() {	
		return RegBean;
	}
	@Override
	public void validate() {
		 
		if(RegisterDao.registerUserNameExist(RegBean.getUserName())== false){
			addFieldError("UserName", "User Name exist please chose other !!!");
		}
		
		
		
		super.validate();
	}
	@Override
	public String execute() throws Exception {
		if(RegisterDao.register(RegBean))
		{
			return SUCCESS;
		}
		else
		{
			return ERROR;
		}
	}
}