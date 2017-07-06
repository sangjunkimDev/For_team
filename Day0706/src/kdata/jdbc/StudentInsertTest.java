package kdata.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StudentInsertTest {

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
//		3. statement 객체 생성
		//statement 도움말 보면 callable statement가 있는데 이는 db 함수를 호출해 올때 사용.
		Statement st = null;
		try {
			st = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		4. SQL문 전송
		Scanner sc = new Scanner(System.in);
		
		int result=0;
		try {
			System.out.println("학번 입력하세여");
			String snum = sc.nextLine();
			System.out.println("이름입력하세요");
			String sname = sc.nextLine();
			System.out.println("성별입력");
			String gender = sc.nextLine();
//			String sql = "insert into stuinfo values ('20157562','유재석','남')";
			String sql = "insert into stuinfo values ('"+snum+"','"+sname+
					"','"+gender+"')";
			System.out.println("입력하실래요? 응 1 아니 2");
			switch(sc.nextInt()){
			case 1:
				result = st.executeUpdate(sql);//자동커밋
				break;
			default : System.out.println("bye");
			}
			//해킹이 너무 많이당해서 PreparedStatement로 바꿔 하기
			
//			st.executeQuery(sql);
			System.out.println(result);
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
			st.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
