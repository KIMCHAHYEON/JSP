package db;

import java.net.http.HttpRequest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.UsrDTO;
import beans.Board_DTO;

public class UsrDB {
	Connection cn = null;
	PreparedStatement ps = null;
	String urs = "jdbc:oracle:thin:@localhost:1521:XE";
	String id = "LHW";
	String pwd = "9894";
	
	public void join(UsrDTO ud) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			cn = DriverManager.getConnection(urs,id,pwd);
			String sql = "insert into Usr values"+"(?,?,?,?,?)";
			
			ps = cn.prepareStatement(sql);
			ps.setString(1, ud.getU_id());
			ps.setString(2, ud.getPwd());
			ps.setString(3, ud.getU_name());
			ps.setString(4, ud.getBirthday());
			ps.setString(5, ud.getPhone());
			ps.executeUpdate();
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		public int login(UsrDTO ud) {
			
			try {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				cn = DriverManager.getConnection(urs,id,pwd);
				String sql = "select * from usr where u_id = ? and pwd = ?";
				
				ps = cn.prepareStatement(sql);
				ps.setString(1, ud.getU_id());
				ps.setString(2, ud.getPwd());
				ResultSet rs = ps.executeQuery();
				
				if(rs.next()) {
					ps.setString(1, ud.getU_id());
					ps.setString(1, ud.getPwd());
					return 1;
				}
				else {
					return 2;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return 0;
		

		}
		
		
	
		
}
