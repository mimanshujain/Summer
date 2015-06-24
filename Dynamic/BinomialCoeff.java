package Dynamic;

public class BinomialCoeff {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(binomialCoeff(6, 2));
	}
	
	public static int binomialCoeff(int n, int k){
		int[][] table = new int[n+1][k+1];
		
		for(int i = 0; i <= n; i++){
			for(int j = 0; j <= Math.min(i, k); j++){
				if(j == 0 || j == i)
					table[i][j] = 1;
				else
					table[i][j] = table[i-1][j-1] + table[i-1][j];
			}
		}
		
		return table[n][k];
	}

}
