package kdata.subject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentManager{

	
	private static Connection conn=null;
	StudentManager(){
		String url="jdbc:oracle:thin:@localhost:1521";
		String user="chkrdp";
		String password="1234";
		
		try {
			conn=DriverManager.getConnection(url, user, password);
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	public static void insert(){
		
		
		
	}
	public void selectAll(){
		
	}
	
	
	
	public static void selectByName(String name){
		
		PreparedStatement pstmt=null;
		ResultSet result=null;
		
		try {
			
			String sql="select * from student where sname like '%"+name+"%'";
			pstmt=conn.prepareStatement(sql);
			
			
			result=pstmt.executeQuery();
			//학번 이름 과목명 성적
			while(result.next()){
				System.out.print(result.getString("stuno").trim() + "\t"
						+result.getString("sNAME").trim() + "\t"
						+result.getString("gender").trim() +"\n");
			
				
			}
			
		} catch ( SQLException e) {
			// TODO Auto-generated catch block
		
			e.printStackTrace();
			System.out.println("JDBC 드라이버 로드 실패");
		}
		
	}


	

}
