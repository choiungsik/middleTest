package �߰����;

import java.util.Scanner;

public class ���� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String[] names = new String[5];
		int[][] scores = new int[5][3];
		int cnt = 0;

		System.out.println("==========�����������α׷�==========");
		System.out.print("[1]�����Է� [2]����Ȯ�� [3]��üȮ�� [4]������� [5]���� >>");
		int input = sc.nextInt();

		for (int i = 0; i < scores.length; i++) {
			System.out.println("==========�����Է�==========");
			System.out.print("1.�̸� �Է� : ");
			String names_1 = sc.next();
			names[i] = names_1;
			System.out.print("1.DataBase���� : ");
			int data = sc.nextInt();
			scores[i][0] = data;
			System.out.print("1.Python����: ");
			int pyth = sc.nextInt();
			scores[i][1] = pyth;
			System.out.print("Java���� : ");
			int java = sc.nextInt();
			scores[i][2] = java;
			System.out.println("����� �Ϸ�Ǿ����ϴ�.");
			cnt++;
		}
		if (cnt >= 5) {
			System.out.println("==========�����Է�==========");
			System.out.println("�� �̻� ����� �Ұ��� �մϴ�!");
		}

		int t_score = 0;

		System.out.println("==========��üȮ��==========");
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
