package 중간고사;

import java.util.Scanner;

public class 첫번째 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String[] names = new String[5];
		int[][] scores = new int[5][3];
		int cnt;

		System.out.println("==========성적관리프로그램==========");
		System.out.print("[1]성적입력 [2]개별확인 [3]전체확인 [4]성적통계 [5]종료 >>");
		int input = sc.nextInt();
		System.out.println("==========성적입력==========");
		System.out.print("1.이름 입력 : ");
		String names_1 = sc.next();
		names[0] = names_1;
		System.out.print("1.DataBase점수 : ");
		int data = sc.nextInt();
		scores[5][0] = data;
		System.out.print("1.Python점수: ");
		int pyth = sc.nextInt();
		scores[5][1] = pyth;
		System.out.print("Java점수 : ");
		int java = sc.nextInt();
		scores[5][2] = java;
		System.out.println("등록이 완료되었습니다.");

	}

}
