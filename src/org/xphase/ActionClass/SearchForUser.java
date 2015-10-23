package org.xphase.ActionClass;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.xphase.Bean.RegisterBean;
import org.xphase.Bean.SearchNameBean;
import org.xphase.Dao.ConnectionFactory;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class SearchForUser extends ActionSupport implements ModelDriven<SearchNameBean> 
{
	
	private static final long serialVersionUID = 1L;
	public static final String SUCCESS = "success";  
	public static final String ERROR = "error";  
	public static final String LOGIN  = "login";  
	public static final String INPUT = "input";  
	public static final String NONE = "none";
	
	HttpServletRequest request;
	
	ArrayList<RegisterBean> list=new ArrayList<RegisterBean>();
	
	public ArrayList<RegisterBean> getList() {  
	    return list;  
	}  
	public void setList(ArrayList<RegisterBean> list) {  
	    this.list = list;  
	}

	SearchNameBean searchName = new SearchNameBean();
	@Override
	public String execute() throws Exception {

		boolean b = false;
		PreparedStatement pstmt = null;
		Connection con = (Connection) ConnectionFactory.getConnection();
		try{
			pstmt = (PreparedStatement) con.prepareStatement("SELECT * FROM xphase.usercontact WHERE UserName like '"+searchName.getIDOrUserName()+"'");
			
			ResultSet rs = pstmt.executeQuery();
			
			while(b = rs.next()){
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
		}
		catch(SQLException e){
			b = false;
			e.printStackTrace();
		}
		if(b == true){
			return "success";
		}
		else{
			return "input";
		}
	}

	public SearchNameBean getModel() {
		return searchName;
	}

}
