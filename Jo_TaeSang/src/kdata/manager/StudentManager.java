package kdata.manager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

//학생 정보를 관리하는 Class
//list는 1개만 생성되도록
public class StudentManager {
	private static List<Student> list;

	public StudentManager() {
		if (list == null) {
			list = new ArrayList<>();
		}
	}

	// 학생 정보 추가 메소드
	public void add(Student std) {

	}

	public void add(int num, String name) {
		// list.get(new Student(num, name));//??
	}

	public void add() {
		boolean duplicated = false;
		Scanner sc = new Scanner(System.in);
		System.out.println("1-1) 학생이름입력");
		String name = sc.nextLine();

		System.out.println("1-2) 학번입력");
		try {
			int num = sc.nextInt();
			for (Student student : list) {
				if (student.equals(new Student(num, name)) || student.getNum() == num) {
					duplicated = true;
					System.out.println("학생정보가 중복됩니다.");
				}
			}
			if (duplicated == false) {
				list.add(new Student(num, name));
			}
		} catch (Exception e) {
			System.out.println("숫자를 입력하세요");
		}
		System.out.println("1-3) 학생입력이 완료되었습니다.");
	}

	// 학생 리스트 출력 메소드
	public void pirnt() {
		// 학번 이름
		// --------------
		// for문
		System.out.println("학번 이름 주소 전화번호 국어 영어 수학 총점 평균");
		System.out.println("------------------------");
		Collections.sort(list);
		Iterator<Student> std = list.iterator();
		while (std.hasNext()) {
			Student s = std.next();
			System.out.println(s.getNum() + "\t\t" + s.getName());
		}

	}

	public void end() {
	}

}
