package ex;

import java.io.*;
import java.util.*;

public class FileInputOutput {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		int check;
		String id, name, tel, email, search;
		Scanner sc = new Scanner(System.in);
		// 파일 쓰기 다양한 방법 중 상대적으로 편리한 PrintWriter 클래스 이용
		PrintWriter pw = new PrintWriter(new FileWriter("test.txt"));
		
		while(true) {
			System.out.println("종료 : 0, 입력 : 1");
			check = sc.nextInt();
			if(check == 0) break;
			
			System.out.print("사용자 번호 입력 : ");
			id = sc.next();
			System.out.print("사용자 이름 입력 : ");
			name = sc.next();
			System.out.print("사용자 전화번호 입력 : ");
			tel = sc.next();
			System.out.print("사용자 이메일 입력 : ");
			email = sc.next();
			// 다른 쓰기 클래스들과 달리 println 메소드를 이용하면 자동으로 개행 이뤄진다.
			pw.println(id + " " + name + " " + tel + " " + email);
			pw.flush();
			System.out.println();
		}
		
		System.out.print("\n검색할 사용자 id : ");
		search = sc.next();
		sc = new Scanner(new BufferedReader(new FileReader("test.txt")));
		sc.useDelimiter(" ");
		while(sc.hasNext()) {
			id = sc.next();
			name = sc.next();
			tel = sc.next();
			email = sc.nextLine();
			if(id.equals(search))
				System.out.println("사용자 번호 " + id + "의 전화번호는 " + tel);
		}
		pw.close();
		sc.close();
	}
}