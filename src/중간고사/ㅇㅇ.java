package 중간고사;

import java.util.Scanner;

public class ㅇㅇ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String[] names = new String[5];
		int[][] scores = new int[5][3];
		int cnt = 0;

		System.out.println("==========성적관리프로그램==========");
		System.out.print("[1]성적입력 [2]개별확인 [3]전체확인 [4]성적통계 [5]종료 >>");
		int input = sc.nextInt();

		for (int i = 0; i < scores.length; i++) {
			System.out.println("==========성적입력==========");
			System.out.print("1.이름 입력 : ");
			String names_1 = sc.next();
			names[i] = names_1;
			System.out.print("1.DataBase점수 : ");
			int data = sc.nextInt();
			scores[i][0] = data;
			System.out.print("1.Python점수: ");
			int pyth = sc.nextInt();
			scores[i][1] = pyth;
			System.out.print("Java점수 : ");
			int java = sc.nextInt();
			scores[i][2] = java;
			System.out.println("등록이 완료되었습니다.");
			cnt++;
		}
		if (cnt >= 5) {
			System.out.println("==========성적입력==========");
			System.out.println("더 이상 등록이 불가능 합니다!");
		}

		int t_score = 0;

		System.out.println("==========전체확인==========");
		int p_score = 100;

		for (int j = 0; j < names.length; j++) {
			for (int i = 0; i < scores.length; i++) {
				System.out.print(p_score + "\t");
				for (int k = 0; k < 3; k++) {
					t_score += scores[i][k];
				}
				if (t_score / 3 >= p_score) {
					System.out.print("*");
				} else {
					System.out.print("\t");
				}
				p_score -= 10;
				System.out.println();
			}
		}

		System.out.print("\t");
		for (String i : names) {
			System.out.print(i + "\t");
		}
	}

}
