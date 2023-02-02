package io.day2.b;

import java.io.*;

public class OutputStreamWriter_test_5 {

/*
    소스 -  입력노드 스트림  파일(C:/NCS/iotest_data/오늘의날씨.txt) 
           FileReader => 2byte기반
            
    목적지 - 출력노드 스트림 System.out => 1byte기반
           브릿지 스트림 OutputStreamWriter => 1byte 를 2byte 로 변경 
*/	
	
	public static void main(String[] args) {

		try {
			String src_file_name = "C:/NCS/iotest_data/오늘의날씨.txt";
			FileReader fr = new FileReader(src_file_name);
			// fr 은 2byte 기반임
		
			OutputStreamWriter ostw = new OutputStreamWriter(System.out);
		    // 모니터에 출력되는 것은 1byte 기반인데 이것을 2byte 기반으로 변경해주는 것이다. 
			
			int input = 0;
			
			while( (input = fr.read()) != -1 ) {
				ostw.write(input);
				ostw.flush();
			}// end of while------------------
			
			ostw.close();
			fr.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}// end of main()-----------------------------------

}
/*
	실행은 명령프롬프트에서 아래와 같이 한다.
	C:\\Users\\user>cd C:\NCS\workspace(java)\IO\bin
	
	C:\NCS\workspace(java)\IO\bin>java io.day2.b.OutputStreamWriter_test_5
	오늘의 날씨는 맑고 기온은 추워요~~
	
*/
