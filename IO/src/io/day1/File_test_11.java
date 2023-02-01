package io.day1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class File_test_11 {

	/*
	    >>> File 클래스 <<<
	      자바에서 File 클래스의 객체라함은 파일 및 폴더(디렉토리)를 다 포함한다. 
	 */
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("탐색기에 존재하는 파일명을 입력하세요 : ");
		String file_name = sc.nextLine();
		// C:/NCS/iotest_data/원본/_JDK-8u333설치매뉴얼.zip
		
		File file_1 = new File(file_name);
		
		System.out.println("파일명만 : " + file_1.getName() );
		// file_1.getName(); 은 파일명만 알려주는 것이다.
		// 파일명만 : _JDK-8u333설치매뉴얼.zip
		
		long file_1_size = file_1.length();
		System.out.println("파일크기 : " + file_1_size + " byte");
		// 파일크기 : 6291383 byte
		
		String absolutePath = file_1.getAbsolutePath();
		System.out.println("경로명을 포함한 파일명1 : " + absolutePath);
		// 경로명을 포함한 파일명1 : C:\NCS\iotest_data\원본\_JDK-8u333설치매뉴얼.zip
		
		String path_file_name = file_1.getPath();
		System.out.println("경로명을 포함한 파일명2 : " + path_file_name);
		// 경로명을 포함한 파일명2 : C:\NCS\iotest_data\원본\_JDK-8u333설치매뉴얼.zip

		// [퀴즈]
		String path_name = path_file_name.substring(0, path_file_name.indexOf(file_1.getName()) );  
		
		System.out.println("경로명만 : " + path_name);
		// 경로명만 : C:\NCS\iotest_data\원본\
		
		
		System.out.println("\n================================\n");
		
		System.out.println(">>> 디렉토리(폴더) 생성하기 <<<");
		
		File dir = new File("C:/NCS/iotest_data/MyDir");
		
		if( !dir.exists() ) {
			// 해당 디렉토리(폴더)가 없으면 
			
			boolean bool = dir.mkdir(); // 해당 디렉토리(폴더)를 생성해라.
			String result = bool?"디렉토리(폴더) 생성 성공^^":"디렉토리(폴더) 생성 실패ㅜㅜ";
			System.out.println("C:/NCS/iotest_data/MyDir " + result);
		}
		
		// >> File dir 이 디렉토리(폴더)인지 알아보기 <<
		if(dir.isDirectory()) {
			System.out.println("C:/NCS/iotest_data/MyDir 은 디렉토리(폴더) 입니다.");
		}
		// C:/NCS/iotest_data/MyDir 은 디렉토리(폴더) 입니다.
		
		
		System.out.println("\n================================\n");
		
		System.out.println(">>> 파일 생성하기 <<<");
		
		File file_2 = new File("C:/NCS/iotest_data/MyDir/테스트1.txt");
		
		if( !file_2.exists() ) {
			// 해당 파일이 존재하지 않으면
			
			try {
				boolean bool = file_2.createNewFile(); // 파일 생성하기
				String result = bool?"파일 생성 성공^^":"파일 생성 실패ㅜㅜ";
				System.out.println("C:/NCS/iotest_data/MyDir/테스트1.txt " + result); 
				
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
		
		// >> File file_2 가 파일인지 알아보기 <<
		if(file_2.isFile()) {
			System.out.println("C:/NCS/iotest_data/MyDir/테스트1.txt 은 파일 입니다.");
		}
		// C:/NCS/iotest_data/MyDir/테스트1.txt 은 파일 입니다.
		
		
		System.out.println("\n================================\n");
		
		System.out.println(">>> 파일 삭제하기 <<<");
		
		boolean bool = file_2.delete(); // 파일 삭제하기
		String result = bool?"파일 삭제 성공^^":"파일 삭제 실패ㅜㅜ";
		System.out.println("C:/NCS/iotest_data/MyDir/테스트1.txt " + result); 
		// C:/NCS/iotest_data/MyDir/테스트1.txt 파일 삭제 성공^^
		
		System.out.println("\n================================\n");
		
		System.out.println(">>> 텅빈 디렉토리(폴더) 삭제하기 <<<");
		
		if(dir.exists()) {
			bool = dir.delete(); // 텅빈 디렉토리(폴더) 삭제하기
			result = bool?"디렉토리(폴더) 삭제 성공^^":"디렉토리(폴더) 삭제 실패ㅜㅜ";
			System.out.println("C:/NCS/iotest_data/MyDir " + result); 
		}
		// C:/NCS/iotest_data/MyDir 디렉토리(폴더) 삭제 성공^^
		
		System.out.println("\n================================\n");
		
		System.out.println(">>> 내용물이 들어있는 디렉토리(폴더) 삭제하기 <<<");
		// 먼저 아래의 실습을 하기 위해서는 C:/NCS/iotest_data/myData 라는 폴더를 만들고
		// myData 폴더속에 아무런 파일을 몇개를 넣어준 후 실습을 하도록 한다. 
		
		File myData_dir = new File("C:/NCS/iotest_data/myData");
		
		// 1. 내용물이 들어있는 디렉토리(폴더)내에 존재하는 내용물을 파악한다.
		File[] file_arr = myData_dir.listFiles();
		
		for(int i=0; i<file_arr.length; i++) {
			System.out.println(file_arr[i].getPath());
		}// end of for------------------
		/*
		 	C:\NCS\iotest_data\myData\korea.txt
			C:\NCS\iotest_data\myData\result.txt
			C:\NCS\iotest_data\myData\result_2.txt
			C:\NCS\iotest_data\myData\_JDK-8u333설치매뉴얼.zip
			C:\NCS\iotest_data\myData\대한민국.txt
			C:\NCS\iotest_data\myData\원본이미지.png 
		 */
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		for(int i=0; i<file_arr.length; i++) {
			file_arr[i].delete();
		}// end of for------------------
		
		if(myData_dir.exists()) {
			bool = myData_dir.delete(); // 텅빈 디렉토리(폴더) 삭제하기
			result = bool?"디렉토리(폴더) 삭제 성공^^":"디렉토리(폴더) 삭제 실패ㅜㅜ";
			System.out.println("C:/NCS/iotest_data/myData " + result); 
		}
		// C:/NCS/iotest_data/myData 디렉토리(폴더) 삭제 성공^^
		
		sc.close();
		
	}// end of main()----------------------------

}
