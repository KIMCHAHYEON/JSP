package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Board_DTO;

public class BoardDB {
	Connection cn = null;
	PreparedStatement ps = null;
	String urs = "jdbc:oracle:thin:@localhost:1521:XE";
	String id = "LHW";
	String pwd = "9894";
	ResultSet rs = null;
	

	public List<Board_DTO> viewText(){
		List<Board_DTO> boards = new ArrayList<Board_DTO>();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			cn = DriverManager.getConnection(urs,id,pwd);
			String sql = "select * from board order by b_id desc";
			
			ps = cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
				
			while(rs.next()) {
				
				Board_DTO bdt = new Board_DTO();
				bdt.setB_id(rs.getString("b_id"));
				bdt.setB_title(rs.getString("b_title"));
				boards.add(bdt);
				
				
				
				
			}
			
			return boards;
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		return null;
	}
	
	public void boardInsert(Board_DTO bdt) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			cn = DriverManager.getConnection(urs,id,pwd);
			
			ps = cn.prepareStatement("insert INTO board values(Board_SQ.nextval,?,?,?,?)");
			ps.setString(1, bdt.getB_pwd());
			ps.setString(2, bdt.getB_title());
			ps.setString(3, bdt.getB_text());
			ps.setString(4, bdt.getU_id());
			int rs = ps.executeUpdate();
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	public void detail(Board_DTO bdt) {
		System.out.println("여기가db임 ㅋㅋ : " + bdt);
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			cn = DriverManager.getConnection(urs,id,pwd);
			String sql = "select * from board where b_id = ?";
			
			ps = cn.prepareStatement(sql);
			ps.setString(1, bdt.getB_id());
			rs = ps.executeQuery();
			
			
			if(rs.next()) {
				 bdt.setB_title(rs.getString("B_title"));
				 bdt.setB_text(rs.getString("B_text"));
				 
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

	
	
	
}
