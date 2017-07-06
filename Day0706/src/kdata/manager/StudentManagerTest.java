package kdata.manager;

import java.util.Scanner;


public class StudentManagerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1.학생 정보 추가
		//스캐너통해서 입력을 받으면 매개변수로 학생개체? 생성?
		//2.학생 리스트 출력
		//3.학생 이름 검색
		StudentManager m1 = new StudentManager();
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("1: 추가, 2: 출력, 3: 검색");
			switch(sc.nextInt()) {
			case 1:
				sc.nextLine(); 
				System.out.println("학생의 학번을 입력하세요");
				String snum = sc.nextLine(); 
				System.out.println("학생의 이름을 입력하세요");
				String sname = sc.nextLine();
				System.out.println("학생의 성별을 입력하세요");
				String gender = sc.nextLine();
				if(m1.insert(new Student(snum, sname, gender))==1) {
					System.out.println("됫다");
				}else System.out.println("안됫다");
				
				break;
			
			default : System.out.println("다시 입력"); break;
			}
		}
		
	}
}
