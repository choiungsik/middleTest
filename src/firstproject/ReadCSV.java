package firstproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadCSV {

	public ArrayList<MaleVO> getList() {

		ArrayList<MaleVO> list = new ArrayList<MaleVO>();

		// 1. 파일이 존재하는 위치와 정보를 담는 객체 생성
		File file = new File("C:\\Users\\SMHRD\\Desktop\\모임정보데이터.csv");

		// 2. 파일객체를 읽어들여서 값을 꺼내는 Input 스트림 생성
		try {
			Scanner sc = new Scanner(file);
			sc.nextLine();
//			System.out.println(sc.hasNext());
//			System.out.println(sc.nextLine());
//			System.out.println(sc.nextLine());	
			while (sc.hasNext()) {
				String line = sc.nextLine();
				String[] value = line.split(",");
				String id = value[0];
				String sex = value[1];
				int age = Integer.parseInt(value[2]);
				String meet_id = value[3];
				MaleVO vo = new MaleVO(id, sex, age, meet_id);
				list.add(vo);
//				System.out.print(value[0]+" ");
//				System.out.print(value[1]+" ");
//				System.out.println(value[2]);
				// , 를 제거하고 출력하세요
				// 행정 1100 1~4
				// 교육 2044 1~4

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;

	}

}
