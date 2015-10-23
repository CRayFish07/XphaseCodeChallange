package org.xphase.ActionClass;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.xphase.Bean.RegisterBean;
import org.xphase.Bean.UserNameRegistrationBean;
import org.xphase.Dao.ConnectionFactory;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserNameInRegistration extends ActionSupport implements ModelDriven<UserNameRegistrationBean> 
{
	private static final long serialVersionUID = 1L;
	
	UserNameRegistrationBean modify = new UserNameRegistrationBean();
	RegisterBean otherModifyingValues = new RegisterBean();
	Connection con = null;
	
	PreparedStatement pstmt = null;
	
	ResultSet rs =  null;
	
	public UserNameRegistrationBean getModel() {
		// TODO Auto-generated method stub
		return modify;
	}
	@Override
	public String execute() throws Exception {
		
		String b = "input" ;
		try{
			con = (Connection) ConnectionFactory.getConnection();
			
			pstmt = (PreparedStatement) con.prepareStatement("UPDATE xphase.usercontact set UserPwd = ? , First_Name = ? , Middle_Name = ? , Last_Name = ? ,Email_ID = ? , Mobile_no = ? , Address = ? , City = ? where UserName = '"+modify.getUserNameForModify()+"' ");
			//pstmt.setString(2, otherModifyingValues.get);
			pstmt.setString(1, otherModifyingValues.getUserPwd());
			pstmt.setString(2, otherModifyingValues.getFirst_Name());
			pstmt.setString(3, otherModifyingValues.getMiddle_Name());
			pstmt.setString(4, otherModifyingValues.getLast_Name());
			pstmt.setString(5, otherModifyingValues.getEmail_ID());
			pstmt.setString(6, otherModifyingValues.getMobile_Num());
			pstmt.setString(7, otherModifyingValues.getAddress());
			pstmt.setString(8, otherModifyingValues.getCity());
			
			if(pstmt.execute()){
				b =  SUCCESS;
			}
			else{
				b =  ERROR;
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			pstmt.close();
			con.close();
		}
		return b;
	}
}