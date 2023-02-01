package io.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileManager {

	public static String reading(String file_name) {
		
		// 해당 파일에 노드 연결 생성(빨대꽂기)
		try {
			FileReader fr = new FileReader(file_name);
			
			StringBuilder sb = new StringBuilder();
			
			do {
			    int data = fr.read(); // 파일로 부터 글자(char)1개(2byte)씩 읽어들임. 
			                          // 파일로 부터 읽어들일 글자(char)가 없으면 -1 을 리턴시켜줌.
			    if(data != -1)
			    	sb.append((char)data);
			    else
			    	break;
			    
			} while(true);
			// end of do~while-------------------------
			
			fr.close(); // 빨대제거
			
			return sb.toString();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return file_name + " 이라는 파일은 없습니다.!!";
		} catch (IOException e) {
			e.printStackTrace();
			return file_name + " 이 손상되었습니다.!!";
		}
		
	}// end of public static String reading(String file_name)------

}
