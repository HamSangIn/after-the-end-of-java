package io.day2.b;

import java.io.FileNotFoundException;
import java.io.IOException;

import io.util.FileManager;

public class FileCopy_PrintWriter_test_7 {

	public static void main(String[] args) {  
		
		// "문자로만 이루어진 특정파일" 을 복사를 하고자 한다. 
		try {
			FileManager.charFileCopy_3(args[0], args[1]);
			// args[0] 에 C:/NCS/iotest_data/korea.txt 로 하고,
			// args[1] 에 C:/NCS/iotest_data/korea_copy3.txt 로 하고,
			
			System.out.println(args[0] + "을 " + args[1] + "로 복사완료함!!");
			
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
    C:\NCS\workspace(java)\IO\bin>java io.day2.b.FileCopy_PrintWriter_test_7 C:/NCS/iotest_data/korea.txt C:/NCS/iotest_data/korea_copy3.txt      
    
     >>> 파일복사 완료!! <<<
    C:/NCS/iotest_data/korea.txt을 C:/NCS/iotest_data/korea_copy3.txt로 복사완료함!!

    C:/NCS/iotest_data/korea.txt 파일은 저장시 인코딩을 ANSI 로 해야 한다. 
    
*/


