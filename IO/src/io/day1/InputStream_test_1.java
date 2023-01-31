package io.day1;

import java.io.IOException;

public class InputStream_test_1 {

/*
    ※ Data Source (키보드, 파일, 내컴퓨터)
      : 데이터의 근원
      
    ※ Data Destination (모니터, 파일, 서버컴퓨터)   
      : 데이터가 최종적으로 도착하는 곳 
      
      
    Data Source o========> 프로그램 ========>o Data Destination
                입력스트림                   출력스트림 
                InputStream               OutputStream
  	
  	
  	>>>>> System.in :
             부모클래스가 추상클래스 InputStream(기본 입력 스트림) 타입인 것으로서 
             접속점(빨대)이 키보드인 입력 스트림이다.
             
    -- Node(접속점)가 키보드인 입력스트림이다.
    -- 1 byte 기반 스트림이다.
    -- 주요메소드 :
          public int read() throws IOException
          ==> 1byte 씩 데이터를 읽어서
              1byte 씩 반환하고
              입력받은 키보드가 Ctrl+C(윈도우), Ctrl+D(유닉스,리눅스,맥) 이라면 -1 을 반환해주는 메소드이다.
              read() 메소드의 리턴타입은 byte 가 아니라 int 이다.
              데이터 입력의 끝을 나타내는 것으로 -1 을 사용하는데
              Ctrl+C(윈도우), Ctrl+D(유닉스,리눅스,맥)을 사용하면 된다.
                          
              또한 IOException 이 발생할수도 있으므로 반드시 예외처리를 꼭 해주어야 한다.              
              그래서 현재 우리는 윈도우를 사용하고 있으므로 InputStream 작업을 
              강제로 종료하려면  Ctrl+C(윈도우) 하면 된다.
    
    
  >>>>> System.out :
              부모클래스가 추상클래스인 OutputStream(기본 출력 스트림) 타입인 것으로서
              접속점(빨대)이 콘솔화면(모니터)인 출력 스트림(PrintStream)이다.
                   
    -- Node(접속점)가 콘솔화면(모니터)인 출력스트림이다.
    -- 1byte 기반 스트림이다.
    -- 주요 메소드 : println(String str),
                  print(String str),
                  write(int b)
  	
*/
	
	public static void main(String[] args) throws IOException {
		
		System.out.println(">> 영문자를 입력하세요 [종료하려면 x를 입력하세요] <<"); 
		
		int input = 0;
		int totalByte = 0;
		
		while(true) {
			
			input = System.in.read(); // abcd엔터
			// System.in 은 키보드 
			// 키보드에서 입력한 문자열중 글자 1개씩(char)만 읽어들여 char 에 해당하는 int 타입으로 반환해주는 것이다.
			// System.in.read() 는 1byte 씩 읽어온다.
						
			// 엔터는 \r\n 인데 \r(carriage return) 이 13 이고, \n(new line)이 10 인 것이다.
			if(input != 13 && input != 10) {

				if( (char)input == 'x' || (char)input == 'X' )
					 break;
				
				totalByte++;
				System.out.println("▷ 글자1개 : " + (char)input);
			}

		}// end of while-------------------------

		System.out.println(">> 입력받은 byte 수 : " + totalByte + "byte"); 

	}// end of main()--------------------------------

}
