package org.xphase.ActionClass;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.xphase.Bean.DeleteUserBean;
import org.xphase.Bean.RegisterBean;
import org.xphase.Dao.ConnectionFactory;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class DeleteUser extends ActionSupport implements ModelDriven<DeleteUserBean>
{
	private static final long serialVersionUID = 1L;

	DeleteUserBean deleteUser = new DeleteUserBean();
	
	Connection con = null;
	
	PreparedStatement pstmt = null;
	
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
		int status;
		boolean b = false;
		try{
			con = (Connection) ConnectionFactory.getConnection();
			pstmt = (PreparedStatement) con.prepareStatement("DELETE FROM xphase.usercontact WHERE UserName = ?");
			pstmt.setString(1, deleteUser.getUserNameToDelete());
			
			status = pstmt.executeUpdate();
			
			if(status > 0){
				b = true;
			}
			else{
				b = false;
			}
			
		}
		catch(SQLException e){
			b = false;
			e.printStackTrace();
		}
		finally{
			System.out.println();
		}
		if(b){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
	
	public DeleteUserBean getModel() {
		// TODO Auto-generated method stub
		return deleteUser;
	}
	public String ShowAllToUser() throws Exception {
		
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
}