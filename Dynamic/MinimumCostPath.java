package Dynamic;

import java.util.Random;

public class MinimumCostPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random randomGen = new Random();
		int len = 10;
		int[][] inp = new int[len][len+1];
		
		for(int i = 0; i < len; i++){
			for(int j = 0; j <= len; j++)
				inp[i][j] = randomGen.nextInt(2*len);
		}
			
		
		for(int i = 0; i < len; i++){
			for(int j = 0; j <= len; j++)
				System.out.print(inp[i][j]+" ");
			System.out.println();
		}
		
		System.out.println();
		System.out.println(minCost(inp, 2,2));
	}
	
	public static int minCost(int[][] inp, int n, int m){
		//Since m and n are indexes, so for ex. for a 3X3 array, we can have input 2,2 for last index.
		int[][] cost = new int[n+1][m+1];
		cost[0][0] = inp[0][0];
		//First Column can only come from down operation
		for(int i=1;i<=n;i++)
			cost[i][0] = cost[i-1][0] + inp[i][0];	
		
		//First row can only come from right operation
		for(int j=1;j<=m;j++)
			cost[0][j] = cost[0][j-1] + inp[0][j];
		
		for(int i=1;i<=n;i++){
			for(int j=1;j<=m;j++){
				cost[i][j] = Math.min(cost[i-1][j-1], Math.min(cost[i-1][j], cost[i][j-1])) + inp[i][j];
			}
		}
		
		return cost[n][m];
	}

}
