package kdata.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class SugangSelectTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521", "zook3280", "1234");
			
			String sql = "select stuinfo.snum, stuinfo.sname, subject.subjectname, takeclass.grade "
					+ "from stuinfo inner join takeclass on stuinfo.snum = takeclass.snum "
					+ "inner join subject on subject.subjectcode = takeclass.subjectcode ";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt. executeQuery();
			while(rs.next()) {
				System.out.print(rs.getString("snum") + "\t");
				System.out.print(rs.getString("sname") + "\t");
				System.out.print(rs.getString("subjectname") + "\t");
				System.out.println(rs.getString("grade") + "\t");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (rs != null) {
					rs.close();
				}
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

