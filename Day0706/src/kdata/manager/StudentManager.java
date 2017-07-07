package kdata.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentManager {
	static Connection con = null;
	static PreparedStatement pstmt = null;
	
	StudentManager(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521", "zook3280", "1234");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int insert(Student stu){
		int result=0;
		try {
			String sql = "insert into stuinfo values (?,?,?)";
			pstmt = this.con.prepareStatement(sql);
			System.out.println(sql);
			pstmt.setString(1, stu.getSnum());
			pstmt.setString(2, stu.getSname());
			pstmt.setString(3, stu.getSex());
			
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
