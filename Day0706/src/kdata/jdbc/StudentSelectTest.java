package kdata.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentSelectTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521", "zook3280", "1234");
			
			String sql = "select * from stuinfo";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt. executeQuery();
			while(rs.next()) {
				System.out.print(rs.getString("snum") + "\t");
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
