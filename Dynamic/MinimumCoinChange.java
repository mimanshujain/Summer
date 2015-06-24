package Dynamic;

public class MinimumCoinChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] coins = {1,5,6,8};
		System.out.println(minimumCoinsNeeded(coins, 15));
	}
	
	public static int minimumCoinsNeeded(int[] coins, int n){
		int count = coins.length;
		int[][] table = new int[count][n+1];//n+1 because we will also consider the total value of 0 also. 0 to n
		
		for(int i=0;i<count;i++)
			table[i][0] = 0;
		
		for(int i=0;i<count;i++){
			for(int j=1;j<=n;j++){
				
				//Minimum of this coin needed (+1 is done for the current coin 
				int x ;//= (j-coins[i]>=0)?table[i][j-coins[i]]+1:0;
				
				//Minimum when this coin is not included. Hence we need to look up previous coins i.e. look to the upper row
				
				int y ;//= (i>=1)?table[i-1][j]:Integer.MAX_VALUE;
				if(j-coins[i]>=0){
					x = table[i][j-coins[i]]+1;
					y = (i>=1)?table[i-1][j]:Integer.MAX_VALUE;
				}
				else if(i >= 1){
					x = Integer.MAX_VALUE;
					y = table[i-1][j];
				}
				else{//When this is the top row and cant take value from above also since top row.
					//So we made both zero coz if this condition not present, and we make any zero then that value will be picked up in Min fucntion
					x = 0;
					y = 0;
				}
					
				
				table[i][j] = Math.min(x, y);
			}
		}
		
		return table[count-1][n];
	}

}
