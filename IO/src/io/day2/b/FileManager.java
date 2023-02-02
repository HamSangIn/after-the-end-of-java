package io.util;

import java.io.*;


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
	
	
	public static String reading_2(String file_name) throws FileNotFoundException, IOException {
		
		// 해당 파일에 노드 연결 생성(빨대꽂기)
		FileReader fr = new FileReader(file_name);
		
		char[] dataArr = new char[10];
		int dataLength = 0;
		
		StringBuilder sb = new StringBuilder();
			
		do {
			dataLength = fr.read(dataArr);
		/*
		    fr 파일로 부터 	dataArr 배열의 크기(char 10개)만큼 읽어들임.
		    읽어들인 글자는 dataArr 배열에 저장시킨후 
		    실제로 읽어들인 글자수(길이)는 dataLength 에 저장시킨다.
		    그런데 fr 파일이 손상되었을시 IOException 이 발생된다.   
		*/
		    if(dataLength != -1) {
		    	String str = new String(dataArr, 0, dataLength);
		    /*
		    	new String(dataArr, 0, dataLength) 은
		    	char[] 타입의 배열인 dataArr 에서 0 번째 인덱스 글자부터
		    	dataLength 개수만큼 뽑아서 String 타입으로 만드는 것이다.  
		    */
		    	sb.append(str);
		    }	
		    
		    else {
		    	break;
		    }
		    
		} while(true);
		// end of do~while-------------------------
		
		fr.close(); // 빨대제거
		
		return sb.toString();
		
	}// end of public static String reading_2(String file_name)------
	
	
	
	public static void charFileCopy(String src_file_name, String target_file_name) throws FileNotFoundException, IOException { 
		
		// 해당 소스파일에 노드 연결 생성(빨대꽂기)
		FileReader fr = new FileReader(src_file_name);
		
		// 해당 타겟파일에 노드 연결 생성(빨대꽂기)
		FileWriter fw = new FileWriter(target_file_name);
		
		char[] dataArr = new char[10];
		int dataLength = 0;
			
		do {
			dataLength = fr.read(dataArr);
		/*
		    fr 파일로 부터 	dataArr 배열의 크기(char 10개)만큼 읽어들임.
		    읽어들인 글자는 dataArr 배열에 저장시킨후 
		    실제로 읽어들인 글자수(길이)는 dataLength 에 저장시킨다.
		    그런데 fr 파일이 손상되었을시 IOException 이 발생된다.   
		*/
		    if(dataLength != -1) {
		    	fw.write(dataArr, 0, dataLength);
		    	fw.flush();
		    }	
		    
		    else {
		    	break;
		    }
		    
		} while(true);
		// end of do~while-------------------------
		
		fr.close(); // 빨대제거
		fw.close(); // 빨대제거
		
	}// end of public static void charFileCopy(String src_file_name, String target_file_name)------

	
	public static void charFileCopy_2(String src_file_name, String target_file_name) throws FileNotFoundException, IOException { 
		
		// 해당 소스파일에 노드 연결 생성(빨대꽂기) - 입력노드스트림
		FileReader fr = new FileReader(src_file_name);
		
		// 입력노드스트림에 입력필터스트림(보조스트림, 오리발) 달아주기
		BufferedReader bfr = new BufferedReader(fr, 1024);
		
		
		// 해당 타겟파일에 노드 연결 생성(빨대꽂기) - 출력노드스트림
		FileWriter fw = new FileWriter(target_file_name);
		
		// 출력노드스트림에 출력필터스트림(보조스트림, 오리발) 달아주기
		BufferedWriter bfw = new BufferedWriter(fw, 1024);
		
		String strLine = null;
		
		while( (strLine = bfr.readLine()) != null ) {
			
		/*
			bfr.readLine() 메소드는 1줄 단위로 읽어와서
			읽어온 내용은 String 타입이므로 strLine 변수에 넣어준다.
			1줄을 읽어오되 엔터전까지 읽어온다.  
		*/
			bfw.write(strLine);
			bfw.newLine(); // 줄바꿈을 해야 한다.
			
			bfw.flush();
		}// end of while----------------------
		
		System.out.println("\n >>> 파일복사 완료!! <<<");
		
		// 제거는 항상 필터(보조)스트림 부터 먼저해야 한다.
		bfw.close();
		fw.close(); // 빨대제거
		
		bfr.close();
		fr.close(); // 빨대제거
		
	}// end of public static void charFileCopy_2(String src_file_name, String target_file_name)------	

	
	public static void charFileCopy_3(String src_file_name, String target_file_name) throws FileNotFoundException, IOException { 
		
		// 해당 소스파일에 노드 연결 생성(빨대꽂기) - 입력노드스트림
		FileReader fr = new FileReader(src_file_name);
		
		// 입력노드스트림에 입력필터스트림(보조스트림, 오리발) 달아주기
		BufferedReader bfr = new BufferedReader(fr, 1024);
		
		
		// 해당 타겟파일에 노드 연결 생성(빨대꽂기) - 출력노드스트림
		FileWriter fw = new FileWriter(target_file_name);
		
		// 출력노드스트림에 출력필터스트림(보조스트림, 오리발) 달아주기
		PrintWriter ptw = new PrintWriter(fw, true);
		/*
		    new PrintWriter(fw, true); 에서
		    두번째 파라미터인 값에 true 를 주면 개행문자(엔터)를 만날때 마다
		    자동으로 flush()메소드가 작동한다는 말이다. 
		 */
		
		String strLine = null;
		
		while( (strLine = bfr.readLine()) != null ) {
			
		/*
			bfr.readLine() 메소드는 1줄 단위로 읽어와서
			읽어온 내용은 String 타입이므로 strLine 변수에 넣어준다.
			1줄을 읽어오되 엔터전까지 읽어온다.  
		*/
			ptw.println(strLine);
			
		}// end of while----------------------
		
		System.out.println("\n >>> 파일복사 완료!! <<<");
		
		// 제거는 항상 필터(보조)스트림 부터 먼저해야 한다.
		ptw.close();
		fw.close(); // 빨대제거
		
		bfr.close();
		fr.close(); // 빨대제거
		
	}// end of public static void charFileCopy_3(String src_file_name, String target_file_name)------	
	
	
}
