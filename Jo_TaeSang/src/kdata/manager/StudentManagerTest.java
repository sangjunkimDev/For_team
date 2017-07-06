package kdata.manager;

import java.util.Scanner;
import java.util.stream.Stream;

public class StudentManagerTest {

	public static void main(String[] args) {
		//1. 학생정보 추가
		//2. 학생 리스트 이름으로 오름차순
		//3. 검색
		//4. 삭제
		//5. 전체 총점
		//6. 최고점수
		//7. 최저점수
		//8. 종료
		
		//managerClass에서 출력문 제거하도록 mvc
		
		

		// TODO Auto-generated method stub
		// 1. 학생 정보 추가
		// 키보드 1번을 누를때 마다 Student객체 생성
		// 키보드 1번을 누르면 StudentManager객체의 add사용 + while(true){}사용 + 3번누르면 break;

		// 2. 학생 리스트 이름으로 오름차순 정렬 후 출력
		// 키보드 2번을 누르면 정렬??

		// 3. 종료
		// 키보드 3번을 누르면 종료
		// 종료하는 방법?

		// sc.nextLine(); 1줄의 문자열 읽기
		// sc.next(); 1단어의 문자열 읽기
		// sc.nextInt(); int형 읽기

		// 조건문(if, switch)으로 1,2,3 확인
		// +@ : Student상속받아서 학과 구분할수도 있음??
		// +@ : 이름으로 검색, 번호로 검색
		// +@ : 필드값(학생이름)으로 정렬
		

		StudentManager studentManager = new StudentManager();
		Scanner sc = new Scanner(System.in);

		int num = 0;
		while (num != 3) {
			System.out.println("1.학생추가\t\t 2.학생정보출력\t\t 3.종료");
			try {
				num = Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				System.out.println("숫자 1,2,3중 하나를 입력해주세요");
				// TODO: handle exception
			}
			if (num == 1) {
				System.out.println("1.학생정보를 입력합니다.");
				studentManager.add();
			} else if (num == 2) {
				System.out.println("2.학생정보를 출력합니다.");
				studentManager.pirnt();
			} else if (num == 3) {
				System.out.println("3.프로그램을 종료합니다.");
				studentManager.end();
			}

		}
		sc.close();
	}

}

// Scanner는 main메소드에서만 만들기->mvc, 객체에서 필요한 데이터는 매개변수로 전달.

// Stream<T> a = new Stream<T>();//StreamApi 찾아보기
