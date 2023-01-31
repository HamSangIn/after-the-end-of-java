package io.day1;

import java.io.IOException;

public class InputStream_test_4 {

	public static void main(String[] args) throws IOException {
		
		// 키보드에서 "대한민국서울시홍대입구엔터" 했다라면
		// "대한민국서"  "울시홍대입"  "구엔터"
		//  10byte     10byte     4byte
		
		int input = 0;
		int totalByte = 0; // byte 수 누적용도
		int cnt = 0;       // while문의 반복회수를 알기위한것
		
		while( (input = System.in.read()) != -1 ) {
			// 키보드로 Ctrl+C(강제종료)를 누르지 않으면 계속실행해라
			
			  System.out.write(input);
			  System.out.flush();
			  
			  totalByte++; 
			  cnt++;
		}// end of while----------------------
		
		System.out.println("총 : " + (totalByte-2) + "byte 입력함"); // 엔터크기를 빼려고 -2 를 한것임.
		System.out.println("반복회수 : " + cnt +"번 반복함");
		
		System.in.close();  // 입력노드(키보드)연결 닫기
		System.out.close(); // 출력노드(모니터)연결 닫기 
		
	}// end of main()-----------------------

}
/*
	== 실행은 아래와 같이 명령프롬프트를 띄워서 한다. ==
	 
	C:\\Users\\user>cd C:\NCS\workspace\IO\bin
	
	C:\NCS\workspace\IO\bin>java io.day1.InputStream_test_4
	대한민국서울시홍대입구엔터
	대한민국서울시홍대입구
	Ctrl+C 함
	총 : 22byte 입력함
	반복회수 : 24번 반복함 
*/




