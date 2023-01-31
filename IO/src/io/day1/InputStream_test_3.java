package io.day1;

import java.io.IOException;

public class InputStream_test_3 {

	public static void main(String[] args) throws IOException {
		
		// 키보드에서 "대한민국서울시홍대입구엔터" 했다라면
		// "대한민국서"  "울시홍대입"  "구엔터"
		//  10byte     10byte     4byte
		
		byte[] dataArr = new byte[10];
		// dataArr 변수의 용도는 빨대(System.in 키보드)에서 흡입할때 단위크기를 10 byte로 하는 것이다. 

		int inputLength = 0;
		// inputLength 변수의 용도는 빨대(System.in 키보드)에서 흡입한 실제 크기를 나타내는 용도임.
		
		int totalByte = 0; // byte 수 누적용도
		int cnt = 0;       // while문의 반복회수를 알기위한것
		
		while( (inputLength = System.in.read(dataArr)) != -1 ) {
			// 키보드로 Ctrl+C(강제종료)를 누르지 않으면 계속실행해라
			
			/*
			   System.in.read(dataArr) 은 
			      입력한 데이터가 "대한민국서울시홍대입구엔터" 이라면
			      입력한 내용에서 배열 dataArr의 크기(지금은 10byte)만큼 읽어들인다.(지금은 "대한민국서") 
			      읽어들인 "대한민국서"을 배열 dataArr 에 저장시키고, 읽어들인 크기(지금은 10byte)를 리턴시켜준다. 
			      
			   반복문의 첫번째 일때
			   dataArr 에는 "대한민국서" 가 들어가고, inputLength 에는 10 이 들어간다.
			    
			   반복문의 두번째 일때
			   dataArr 에는 "울시홍대입" 가 들어가고, inputLength 에는 10 이 들어간다.
			    
			   반복문의 세번째 일때          
			   dataArr 에는 "구엔터" 가 들어가고, inputLength 에는 4 가 들어간다.           
			*/
			
			  System.out.write(dataArr, 0, inputLength);
			  // 배열 dataArr 에 저장된 데이터에서 시작점이 0번째 index 부터(처음부터) inputLength byte 수 만큼 출력해라는 말이다.   
			  
			  System.out.flush();
			  
			  totalByte += inputLength; // 10 + 10 + 4
			  
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
	 
	C:\\Users\\user>cd C:\NCS\workspace(java)\IO\bin
	
	C:\NCS\workspace(java)\IO\bin>java io.day1.InputStream_test_3
	대한민국서울시홍대입구엔터
	대한민국서울시홍대입구
	Ctrl+C 함
	총 : 22byte 입력함
	반복회수 : 3번 반복함 
 
*/




