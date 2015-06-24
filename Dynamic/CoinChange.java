package Dynamic;

public class CoinChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] coins = {1,2,3};
		int n = 5;
		System.out.println(totalCombinations(coins, n));
	}
	
	//n = amount to be made.
	public static int totalCombinations(int[] coins, int n){
		//Extra n+1 column for the zero value
		int[][] mat = new int[coins.length][n+1];
		
		for(int i=0;i<coins.length;i++)
			mat[i][0] = 1;
		
		for(int i=0;i<coins.length;i++){
			for(int j=1;j<n+1;j++){
//				int index = j-coins[i];
//				int previous = 0;
//				if(index >= 0)
//					previous = mat[i][index];
				
				//When this coin can be included
				//j = total value now to be made. j-coins[i] = if the current coin can be used to make this amount.
				int x = (j-coins[i]>=0)?mat[i][j-coins[i]]:0;
				
				//When this coin is not included.
				//Like number of previous coins which are needed to make this combination i
				int y = (i >= 1)?mat[i-1][j]:0;
				
				//Total coin needed for this denomination
				mat[i][j] = x + y;
			}
		}
		
		return mat[coins.length-1][n];
	}

}
