package 중간고사;

public class ㅇㄹㄴㄹ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = new int[5][5];
		int alp = 65;
		for (int i = 0; i < arr.length; i++) {
			for(int j=0; j< arr.length; j++) {
				switch(i) {
				case 0:
					arr[i][j]=alp;
					alp++;
					break;
				case 1:
					if(j>1&&j<=4){
						
						arr[i][j]=alp;
						alp++;
						break;
					}
				case 2:
					if(j==2&&j<3) {
						arr[i][j]=alp;
						alp++;
						break;
					}
				
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			for(int j=0; j< arr.length; j++) {
				System.out.print((char)arr[i][j]+" "); 
			}System.out.println();
		}

	}

}
