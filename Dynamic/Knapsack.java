package Dynamic;

public class Knapsack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] val = {4, 2, 4, 1, 5};
		int[] wt = {5, 4, 3, 2, 4};
		int k = 13;
		System.out.println(profitMax(wt, val, k));
	}

	public static int profitMax(int[] w, int[] p, int k){
		int n = w.length;
		int[][] profit = new int[n+1][k+1];
		int[][] item = new int[n+1][k+1];

		for(int i = 0; i <= n; i++){
			for(int j = 0; j <= k; j++){
				if(i == 0 || j == 0)
					profit[i][j] = 0;
				else if(w[i-1] > j){
					profit[i][j] = profit[i-1][j];
					item[i][j] = 1;
				}
				else{
					//if the profit is max when keep only item till i-1 in the bag
					int x = profit[i-1][j];
					//If includes this item also
					int y = p[i-1] + profit[i-1][j-w[i-1]];
					profit[i][j] = Math.max(x, y);
					item[i][j] = x >y?1:2;
				}
			}
		}
		int j = k;
		for(int i = n; i >= 0;i--){
			if(item[i][j] == 2){
				j = j - w[i-1];
				System.out.println("Item "+i+" ");
			}
		}
		
		return profit[n][k];
	}

}
