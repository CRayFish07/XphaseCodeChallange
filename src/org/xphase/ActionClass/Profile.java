package org.xphase.ActionClass;

import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.xphase.Bean.RegisterBean;
import org.xphase.Dao.ConnectionFactory;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.opensymphony.xwork2.ActionSupport;

public class Profile extends ActionSupport implements ServletRequestAware
{
	private static final long serialVersionUID = -5573911603201107602L;
	
	HttpServletRequest request;
	ArrayList<RegisterBean> list=new ArrayList<RegisterBean>();
	public ArrayList<RegisterBean> getList() {  
	    return list;  
	}  
	public void setList(ArrayList<RegisterBean> list) {  
	    this.list = list;  
	}  
	@Override
	public String execute() throws Exception {
		
		Connection con  = (Connection) ConnectionFactory.getConnection();
		PreparedStatement pstmt = (PreparedStatement) con.prepareStatement("SELECT * FROM xphase.usercontact");
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()){
			RegisterBean showData = new RegisterBean();
			showData.setId(rs.getInt(1));
			showData.setUserName(rs.getString(2));
			showData.setFirst_Name(rs.getString(4));
			showData.setMiddle_Name(rs.getString(5));
			showData.setLast_Name(rs.getString(6));
			showData.setEmail_ID(rs.getString(7));
			showData.setMobile_Num(rs.getString(8));
			showData.setAddress(rs.getString(9));
			showData.setCity(rs.getString(10));
			list.add(showData);
		}
		return super.execute();
	}

	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		
	}
}
