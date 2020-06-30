package 중간고사;

import java.util.Scanner;

public class team {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String[] names = new String[5];
		int[][] scores = new int[5][3];
		int cnt = 0;
		int data = 0;
		int pyth = 0;
		int java = 0;
		int input = 0;

		while (input != 5) {
			System.out.println("==========성적관리프로그램==========");
			System.out.print("[1]성적입력 [2]개별확인 [3]전체확인 [4]성적통계 [5]종료 >>");
			input = sc.nextInt();

			if (input == 1) {
				if (cnt < 5) {
					System.out.println("==========성적입력==========");
					System.out.print("1.이름 입력 : ");
					String names_1 = sc.next();
					names[cnt] = names_1;
					System.out.print("1.DataBase점수 : ");
					data = sc.nextInt();
					scores[cnt][0] = data;
					System.out.print("1.Python점수: ");
					pyth = sc.nextInt();
					scores[cnt][1] = pyth;
					System.out.print("Java점수 : ");
					java = sc.nextInt();
					scores[cnt][2] = java;
					System.out.println("등록이 완료되었습니다.");
					cnt++;

				} else {
					System.out.println("==========성적입력==========");
					System.out.println("더 이상 등록이 불가능 합니다!");

				}
			}

			if (input == 2) {
				// 박민지, 김설아

				System.out.print("확인하고싶은 학생의 이름을 입력하세요: ");
				String names_1 = sc.next();

				for (int i = 0; i < scores.length; i++) {
					if (names[i].equals(names_1)) {
						System.out.println("Database : " + scores[i][0]);
						System.out.println("python : " + scores[i][1]);
						System.out.println("java : " + scores[i][2]);
						int sum = scores[i][0] + scores[i][1] + scores[i][2];
						float mean = (float) sum / 3;
						System.out.println("평균 :" + mean);
						System.out.print("학점 : ");
						if (mean >= 96) {
							System.out.println("A+");
						} else if (mean >= 86) {
							System.out.println("B+");
						} else if (mean >= 76) {
							System.out.println("c+");
						} else {
							System.out.println("F");
						}
						break;

					} else if (i == 4) {
						System.out.println("찾으려는 학생이 존재하지 않습니다. ");
					}

				}
				
			}

			if (input == 3) {

				// 최웅식

				int t_score = 0;

				System.out.println("==========전체확인==========");
				int p_score = 100;
				for (int j = 0; j < 10; j++) {
					if (p_score > 0) {
						System.out.print(p_score + "\t");
						for (int i = 0; i < names.length; i++) {
							t_score = 0;
							for (int k = 0; k < 3; k++) {
								t_score += scores[i][k];
							}
							if (t_score / 3 >= p_score) {
								System.out.print("*\t");
							} else {
								System.out.print("\t");
							}
						}

						p_score -= 10;
						System.out.println();
					}
				}

				System.out.print("\t");
				for (String i : names) {
					System.out.print(i + "\t");
				}
				System.out.println();
			}

			if (input == 4) {
				// 김평강
				System.out.println("==========성적 관리 프로그램 ==========");
				int result_score = 0;
				double scores_total;
				float total_scores = 0;

				for (int i = 0; i < 3; i++) {
					scores_total = 0;
					if (i == 0) {
						System.out.print("DataBase 평균 : ");
					} else if (i == 1) {
						System.out.print("Python 평균 : ");
					} else if (i == 2) {
						System.out.print("Java 평균 : ");
					}
					for (int j = 0; j < scores.length; j++) {
						scores_total += scores[j][i];

					}
					scores_total = scores_total / 5.0;
					double aa = (int) (scores_total * 100) / 100.0;
					System.out.println(aa);
					total_scores += scores_total;

				}
				total_scores = total_scores / 3;
				double aa = (int) (total_scores * 100) / 100.0;
				System.out.println("전체" + aa);
			}
		}
		System.out.println("프로그램 종료");
	}

}
