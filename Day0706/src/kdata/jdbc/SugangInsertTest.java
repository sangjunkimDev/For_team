package kdata.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class SugangInsertTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("JDBC 드라이버 로드 성공");

			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521", "zook3280", "1234");
			System.out.println("데이터베이스 서버 연결 성공");
		
			Scanner sc = new Scanner(System.in);
			System.out.println("Please input student's number");
			String snum = sc.nextLine();
			System.out.println("Please input subject's number");
			String subjectcode = sc.nextLine();
			System.out.println("Please input student's grade");
			int grade = sc.nextInt();
		
			String sql = "insert into takeclass values(?,?,?,default)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, snum);
			pstmt.setString(2, subjectcode);
			pstmt.setInt(3, grade);
			System.out.println(sql);
			int result;
			result = pstmt.executeUpdate();

		
			if (result ==0) {
				System.out.println("mission fail");
			}
			else System.out.println("mission success");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt!=null) {
					pstmt.close();
				}
				if (con!=null) {
					con.close();
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
				
		}
		
		
	}

}
