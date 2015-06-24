package HackerRank;

import java.util.Scanner;

public class WhiteFalcon {

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		int[] arr= new int[num];
		for(int i = 0; i < num; i++)
			arr[i] = scan.nextInt();

		int[][] mat = new int[num][num];
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < num; i++){
			for(int j = i+1; j < num; j++){                
				mat[i][j] = arr[i]*arr[j];
				int single = mat[i][j];
				max = Math.max(single, max);

				for(int k = 1; k < i+1; k++){
					if(j+k >= num) break;

					single = single + mat[i-k][k+j];
					max = Math.max(single, max);
					
//					for(int l = 1; l <= k-1; l++){
//						try{
//							single = single + mat[i-l][l+j];
//							max = Math.max(single, max);
//						}
//						catch(Exception ex){
//							ex.printStackTrace();
//						}
//					}
				}
			}
		}

		System.out.print(max);
		scan.close();
	}

}
