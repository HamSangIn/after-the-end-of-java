package io.day2.b;

import java.io.FileNotFoundException;
import java.io.IOException;

import io.util.FileManager;

public class FileReader_test_2 {

	public static void main(String[] args) {  
		
		// "문자로만 이루어진 특정파일명" 에 해당하는 내용을 읽어다가 화면에 출력하고자 한다. 
		String str;
		
		try {
			str = FileManager.reading_2(args[0]);
			// args[0] 에 C:/NCS/iotest_data/korea.txt 로 할 것이다.
			
			System.out.println(str);
			
		} catch (FileNotFoundException e) {
			System.out.println("파일 "+ args[0] + " 이 존재하지 않습니다.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("파일 "+ args[0] + " 이 손상되었습니다.");
			e.printStackTrace();
		}
		
	}

}
/*
    실행은 명령프롬프트에서 아래와 같이 한다.
    C:\\Users\\user>cd C:\NCS\workspace(java)\IO\bin
    
    실행은 명령프롬프트에서 아래와 같이 한다.
    C:\NCS\workspace(java)\IO\bin>java io.day2.b.FileReader_test_2 C:/NCS/iotest_data/korea.txt
    동해물과 백두산이 마르고 닳도록 하느님이 보우하사 우리나라 만세
    무궁화 삼천리 화려강산 대한사람 대한으로 길이 보전하세

    C:/NCS/iotest_data/korea.txt 파일은 저장시 인코딩을 ANSI 로 해야 한다. 
    
*/


