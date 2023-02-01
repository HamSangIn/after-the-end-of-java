package io.day1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStream_test_8 {

/*
    ※ Data Source (키보드, 파일, 내컴퓨터)
      : 데이터의 근원
      
    ※ Data Destination (모니터, 파일, 서버컴퓨터)   
      : 데이터가 최종적으로 도착하는 곳 
      
      
    Data Source o========> 프로그램 ========>o Data Destination
                입력스트림                   출력스트림 
                InputStream               OutputStream
  	
  	== 키보드로 부터 입력받은 것을 파일(C:\NCS\iotest_data\result.txt)에 기록(출력)하기로 한다. == 
  	
  	1. 데이터소스   : 키보드로 부터 읽어들임 (노드스트림 : System.in)
  	2. 데이터목적지 : 결과물을 특정 파일에 출력 (노드스트림 : FileOutputStream)
  	
*/	
	
	public static void main(String[] args) {
		
		System.out.println(">> 내용을 입력하세요[입력하신 내용은 C:\\NCS\\iotest_data\\result_2.txt 파일에 저장됨] <<"); 
		
		String fileName = "C:/NCS/iotest_data/result_2.txt";
		boolean append = true;
		
		byte[] dataArr = new byte[10];
		
		int inputLength = 0;
		int totalByte = 0; // byte 수 누적용도
		int cnt = 0; // 반복회수
		
		try {
			FileOutputStream fost = new FileOutputStream(fileName, append);
			/*
		       만약에 탐색기에서 
		       C:/NCS/iotest_data/result.txt 파일이 없다라면
		       파일을 자동으로 생성해준다.
		       단, 탐색기에서 C:/NCS/iotest_data 폴더는 존재해야 한다.
		    
		       두번째 파라미터인 append 가 true 인 경우는
		       첫번째 파라미터인 해당파일에 이미 내용물이 적혀 있는 경우일때
		       기존내용물은 그대로 두고 기존내용뒤에 새로운 내용을 덧붙여 추가하겠다는 말이다. 
		       
		       두번째 파라미터인 append 가 false 인 경우는
		       첫번째 파라미터인 해당파일에 이미 내용물이 적혀 있는 경우일때
		       기존내용물은 싹 지우고 새로운 내용을 새롭게 처음부터 쓰겠다는 말이다.
		     
		       그런데 만약에 두번째 파라미터를 생략하면    
		       즉, FileOutputStream fost = new FileOutputStream(filename); 이라면
		       자동적으로 false 로 인식한다. 즉, filename 의 기존내용물은 싹 지우고 새로운 내용을 새롭게 처음부터 쓰겠다는 말이다.    
	   */
			
			while( (inputLength = System.in.read(dataArr)) != -1 ) {
				
				fost.write(dataArr, 0, inputLength);
				fost.flush();
				
				totalByte += inputLength;
				
				cnt++; // 반복회수
			}// end of while----------------------
			
			fost.close();
			
			System.out.println(fileName + "에 쓰기 완료!! " + totalByte + "byte 씀.");
			System.out.println("반복회수 : " + cnt + "번 반복함.");
			System.out.close();
			
		} catch (FileNotFoundException e) {
			System.out.println(fileName + " 파일이 없습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}// end of main()------------------------------

}
/*
 C:\NCS\workspace(java)\IO\bin>java io.day1.FileOutputStream_test_8
 >> 내용을 입력하세요[입력하신 내용은 C:\NCS\iotest_data\result.txt 파일에 저장됨] <<
 동해물과 백두산이 마르고 닳도록 하느님이 보우하사엔터
 우리나라 만세~~엔터
 java oracle엔터
 Ctrl + C 함
 C:/NCS/iotest_data/result_2.txt에 쓰기 완료!! 81byte 씀.
 반복회수 : 10번 반복함. 
*/


