package io.day2.b;

import java.io.*;

public class InputStreamReader_test_4 {

/*
    소스 -  입력노드 스트림  키보드(System.in) => 1byte기반
    
           브릿지 스트림 InputStreamReader => 1byte 를 2byte 로 변경
            
    목적지 - 출력노드 스트림 FileWriter => 2byte기반
*/	
	
	public static void main(String[] args) {

		InputStreamReader istr = new InputStreamReader(System.in);
		// 키보드에서 입력하는 것은 1byte 기반인데 이것을 2byte 기반으로 변경해주는 것이다. 
	
		try {
			FileWriter fw = new FileWriter("C:/NCS/iotest_data/오늘의날씨.txt");
			
			int input = 0;
			
			while( (input = istr.read()) != -1 ) {
				fw.write(input);
				fw.flush();
			}// end of while------------------
			
			fw.close();
			istr.close();
			
			System.out.println("\n >>> 종료합니다. <<<");
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}// end of main()-----------------------------------

}
/*
	실행은 명령프롬프트에서 아래와 같이 한다.
	C:\\Users\\user>cd C:\NCS\workspace(java)\IO\bin
	
	C:\NCS\workspace(java)\IO\bin>java io.day2.b.InputStreamReader_test_4
	오늘의 날씨는 맑고 기온은 추워요~~

    >>> 종료합니다. <<<
	
*/
