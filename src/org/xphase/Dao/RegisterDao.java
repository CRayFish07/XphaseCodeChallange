package org.xphase.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class RegisterDao 
{
	public static boolean registerUserNameExist(String UserName){
		
		ResultSet status = null;
		
		PreparedStatement pstmt = null;
		
		Connection con = (Connection) ConnectionFactory.getConnection();
		
		try{
			pstmt = (PreparedStatement) con.prepareStatement("SELECT * FROM xphase.userContact where UserName = ?");
			
			pstmt.setString(1, UserName);
			
			status = pstmt.executeQuery();
			
			con.commit();
			
		}
		catch (SQLException e){
			System.out.println("Error happened !!!");
			e.printStackTrace();
		}
		finally{
			if(pstmt != null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println(status+"Register dao file o/p");
		//return status != null;
		return true;
	}
	
	public static boolean register(org.xphase.Bean.RegisterBean regBean){
		System.out.println("public static boolean register(RegisterBean rb)");
		java.sql.PreparedStatement pstmt = null;
		
		boolean b = false;
		
		int status = 0;
		
		Connection con = (Connection) ConnectionFactory.getConnection();
		
		try 
		{
			pstmt = con.prepareStatement("INSERT INTO xphase.UserContact(UserName,UserPwd,First_Name,Middle_Name,Last_Name,Email_ID,Mobile_Num,Address,city) VALUES(?,?,?,?,?,?,?,?,?)");
			
			pstmt.setString(1, regBean.getUserName());
			pstmt.setString(2, regBean.getUserPwd());
			pstmt.setString(3, regBean.getFirst_Name());
			pstmt.setString(4, regBean.getMiddle_Name());
			pstmt.setString(5, regBean.getLast_Name());
			pstmt.setString(6, regBean.getEmail_ID());
			pstmt.setString(7, regBean.getMobile_Num());
			pstmt.setString(8, regBean.getAddress());
			pstmt.setString(9, regBean.getCity());
			
			
			status = pstmt.executeUpdate();
			
			if(status > 0){
				b = true;
			}
			else{
				b = false;
			}
			
		}
		catch (SQLException e) 
		{
			System.out.println("Error happened !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			e.printStackTrace();
		}
		finally{
			if(pstmt != null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}	
		return b;
	}
}
//create TABLE xphase.UserContact(User_ID int(12) , UserName varchar(255),UserPwd varchar(255),First_Name varchar(255),Middle_Name varchar(255),Last_Name varchar(255),Email_ID varchar(255),Mobile_Num varchar(255),Address varchar(255),city varchar(255))