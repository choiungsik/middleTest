package �߰����;

import java.util.Scanner;

public class ù��° {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String[] names = new String[5];
		int[][] scores = new int[5][3];
		int cnt;

		System.out.println("==========�����������α׷�==========");
		System.out.print("[1]�����Է� [2]����Ȯ�� [3]��üȮ�� [4]������� [5]���� >>");
		int input = sc.nextInt();
		System.out.println("==========�����Է�==========");
		System.out.print("1.�̸� �Է� : ");
		String names_1 = sc.next();
		names[0] = names_1;
		System.out.print("1.DataBase���� : ");
		int data = sc.nextInt();
		scores[5][0] = data;
		System.out.print("1.Python����: ");
		int pyth = sc.nextInt();
		scores[5][1] = pyth;
		System.out.print("Java���� : ");
		int java = sc.nextInt();
		scores[5][2] = java;
		System.out.println("����� �Ϸ�Ǿ����ϴ�.");

	}

}
