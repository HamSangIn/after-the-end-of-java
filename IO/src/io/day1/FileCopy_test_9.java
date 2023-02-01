package io.day1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/*
	※ Data Source (키보드, 파일, 내컴퓨터)
	  : 데이터의 근원
	  
	※ Data Destination (모니터, 파일, 서버컴퓨터)   
	  : 데이터가 최종적으로 도착하는 곳 
	  
	  
	Data Source o========> 프로그램 ========>o Data Destination
	            입력스트림                   출력스트림 
	            InputStream               OutputStream
		
		== 파일로 부터 입력받은 것을 파일에 기록(출력)하기로 한다. == 
		
		1. 데이터소스   : 파일로 부터 읽어들임 (노드스트림 : FileInputStream)
		2. 데이터목적지 : 결과물을 특정 파일에 출력 (노드스트림 : FileOutputStream)
	
*/	

public class FileCopy_test_9 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print(">> 복사할 원본파일명(절대경로) 입력 => ");
		String src_fileName = sc.nextLine();
		// C:/NCS/iotest_data/원본/원본이미지.png
		
		System.out.print(">> 목적 파일명(절대경로) 입력 => ");
		String target_fileName = sc.nextLine();
		// C:/NCS/iotest_data/복사본/복사본이미지.png
		
		byte[] dataArr = new byte[1024]; // 1024 byte == 1kb 
		int inputLength = 0; 
		int totalByte = 0; // byte 수 누적용도
		int cnt = 0; // 반복회수
		
		try {
			FileInputStream fist = new FileInputStream(src_fileName);
			// FileInputStream 생성 : 접속점이 파일인 것으로 특정 파일에 빨대를 꽂아 파일의 내용물을 1byte 기반으로 빨아들이는 입력노드 스트림이다.       
			
			FileOutputStream fost = new FileOutputStream(target_fileName);
			// FileOutputStream 생성 : 접속점이 파일인 것으로 특정 파일에 빨대를 꽂아 파일의 내용물을 1byte 기반으로 기록해주는(써주는) 출력노드 스트림이다.  
			
			while( (inputLength = fist.read(dataArr)) != -1 ) {
				
				fost.write(dataArr, 0, inputLength); // 파일에 쓰기
				fost.flush();
				
				totalByte += inputLength;
				
				cnt++; // 반복회수
			}// end of while--------------------------
			
			fost.close();
			fist.close();
			
			System.out.println(target_fileName + "에 쓰기 완료!! " + totalByte + "byte 복사됨." ); 
			System.out.println("반복회수 : " + cnt + "번 반복함.");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		sc.close();
		
	}// end of main()--------------------------
	
}
