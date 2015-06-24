package HackerRank;

import java.util.Scanner;

public class DancePairs {

	public static void main(String[] args) {
		//* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		int diff = scan.nextInt();
		int[] boys = new int[num];
		int[] girls = new int[num];
		for(int i=0;i<num;i++){
			boys[i] = scan.nextInt();
		}
		for(int i=0;i<num;i++){
			girls[i] = scan.nextInt();
		}
		boolean[][] mat = new boolean[num][num];
		for(int i=0;i<num;i++){
			for(int j=0;j<num;j++){
				mat[i][j] = Math.abs(boys[i]-girls[j]) <= diff;
			}
		}
		int max = Integer.MIN_VALUE;
		for(int i=num-1;i>=0;i--){
			int row = i;
			int count = 0;
			try{
			for(int col=0;col<num-i;col++){
				if(mat[row][col]) count++;
				row++;
			}
			max = Math.max(count,max);
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
		}
		for(int i=1;i<num;i++){
			int row = 0;
			int count = 0;
			for(int col=i;col<num;col++){
				if(mat[row][col]) count++;
				row++;
			}
			max = Math.max(count,max);
		}
		
//		for(int i=0;i<num;i++){
//			for(int j=0;j<num;j++){
//				System.out.print(mat[i][j]+" ");
//			}
//			System.out.println();
//		}

		System.out.println(max);
	}

}


