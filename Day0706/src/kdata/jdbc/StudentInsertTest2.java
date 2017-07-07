package kdata.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentInsertTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		1.JDBC 드라이버 로드 
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//동적으로 바뀌는것이기때문에 import 시키지 않고 전체경로를 입력.
			System.out.println("JDBC 드라이버 로드 성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("JDBC 드라이버 로드 실패");
		}
//		2.데이터베이스 서버 연결
		//드라이버 로딩하면 매니저를 쓸수 있음. 거기에 getConnection쓸수 있음.
		Connection con = null;//선언 위치에 따라 try문 안에 쓰면 밑에서 쓸수 없음.
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521", "zook3280", "1234");
			System.out.println("데이터베이스 서버 연결 성공");
			//실행되면 sql developer 접속한것과 같음.
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("데이터베이스 서버 연결 실패");
		}
		
		//3.statement 객체 생성
		Scanner sc = new Scanner(System.in);
		System.out.println("Please input student's number");
		String snum = sc.nextLine();
		System.out.println("Please input student's name");
		String sname = sc.nextLine();
		System.out.println("Please input student's gender");
		String gender = sc.nextLine();
		System.out.println("Is it right?" + snum +"  " +sname +"  " +gender);
		String sql = "insert into stuinfo values(?,?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//4. sql문 전송
		int result =0;
		try {
			pstmt.setString(1, snum);
			pstmt.setString(2, sname);
			pstmt.setString(3, gender);
			
			result = pstmt.executeUpdate();
		//	pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		5. 결과 처리
		if(result ==0) {
			System.out.println("mission fail");
		}
		else {
			System.out.println("mission success");
		}
		
//		6. 데이터베이스 서버 연결 해제
		try {
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
