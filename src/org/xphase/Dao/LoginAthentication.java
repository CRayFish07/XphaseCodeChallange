package org.xphase.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class LoginAthentication 
{
	public static boolean Login(String uname , String pwd){
		
		PreparedStatement pstmt = null;
		
		boolean b = false;
		
		Connection con = (Connection) ConnectionFactory.getConnection();
		
		try 
		{
			pstmt = (PreparedStatement) con.prepareStatement("SELECT * FROM xphase.usercontact WHERE USERNAME = ? AND USERPWD = ?");
			
			pstmt.setString(1, uname);
			
			pstmt.setString(2, pwd);
			
			ResultSet rs = pstmt.executeQuery();
			
			b = rs.next();
			
			System.out.println(b);
			
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally{
			if(pstmt != null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return b;
	}

}
