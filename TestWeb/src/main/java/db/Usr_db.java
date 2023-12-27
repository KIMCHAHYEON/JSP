package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.BoardDTO;
import beans.UsrDTO;

public class Usr_db {
	
	Connection cn = null;
	PreparedStatement ps = null;
	ResultSet rs = null; //결과의 집합, 
	String urs = "jdbc:oracle:thin:@localhost:1521:XE";
	String id = "LHW";
	String pwd = "9894";
			
	
	public void join(UsrDTO us) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			cn = DriverManager.getConnection(urs,id,pwd);
			
			String sql = "insert into Usr values"+"(?,?,?,?,?)";
			
			
			ps = cn.prepareStatement(sql);
			ps.setString(1,us.getU_id());
			ps.setString(2,us.getPwd());
			ps.setString(3,us.getU_name());
			ps.setString(4,us.getPhone());
			ps.setString(5,us.getBirthday());
			
			ps.executeUpdate();
		
		} catch (ClassNotFoundException e) {
			System.out.println("클래스를 못찾음");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	public int select(UsrDTO us) {
		try {
			
		Class.forName("oracle.jdbc.driver.OracleDriver");
		cn = DriverManager.getConnection(urs,id,pwd);
		
		String sql = "select * from usr where u_id = ? and pwd = ? ";
		

		ps = cn.prepareStatement(sql);
		ps.setString(1, us.getU_id());
		ps.setString(2, us.getPwd());

		ResultSet rs = ps.executeQuery();
	
		if(rs.next()) {	
			us.setU_id(rs.getString("u_id"));
			us.setBirthday(rs.getString("birthday"));
			return 1;
		}else {
			return 2;
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch(ClassNotFoundException e) {
		System.out.println("클래서 못찾음 오류");
	}
	return 0;
	}
	public List<BoardDTO> select2() {
		List<BoardDTO> boards = new ArrayList<BoardDTO>();
		/*
		 * BoardDTO dt = new BoardDTO(); boards.add(dt);
		 */
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			cn = DriverManager.getConnection(urs,id,pwd);
			String sql = "select * from board";
			
			
			ps = cn.prepareStatement(sql);

			rs = ps.executeQuery();//인터너블 타입  결과 값을 하나씩 꺼내올수 있는 타입, 하나씩 값을 담을수 있다, 다음값이 있으면 true 없으면 flase를 반환 
			
			while(rs.next()) {//다음 값이 없을때까지 트루를 반환하므로 없어질떄 까지 돈다. 
				BoardDTO board = new BoardDTO();
				board.setB_id(rs.getString("b_id"));
				board.setB_title(rs.getString("b_title"));
				boards.add(board);
			}
			
			return boards;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return null;

		
		
	}
	public void  boardInsert(BoardDTO bdt) {
		try {
			
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			cn = DriverManager.getConnection(urs,id,pwd);
			String sql = "insert INTO board values(BOARD_SQ.nextval,?,?,?,?)";
			
			ps = cn.prepareStatement(sql);
//			ps.setString(1,bdt.getB_id());
			ps.setString(1,bdt.getB_pwd());
			ps.setString(2,bdt.getB_title());
			ps.setString(3,bdt.getB_text());
			ps.setString(4,bdt.getU_id());
			ps.executeUpdate();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
		
}


