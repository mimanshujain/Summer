package Dynamic;

public class MatrixMultiplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] p = {40, 20, 30, 10, 30}  ;
		System.out.println(matrixMul(p));
	}

	public static int matrixMul(int[] p){
		int n = p.length;
		int[][] mat = new int[n][n];

		//All Diagonal elements are zero since minimum scalar multiplication with the same matrix is 0
		for(int i=0, j=0;i<n&&j<n;i++,j++){
			mat[i][j] = 0;
			mat[0][j] = 0; //1st Row all zero
			mat[i][0] = 0; //1st Col all zero		
		}

		//Now iterate diagonal by diagonal
		//Starting from 2nd column and 1st row
		//		int i = 1;
		//		int j = n;
		for(int L = 2; L < n; L++){
			for(int i=1;i<=n-L;i++){
				int j = i+L-1;
				int min = Integer.MAX_VALUE;
				for(int k=i;k<j;k++){
					try{
						int cost = mat[i][k] + mat[k+1][j] + p[i-1]*p[k]*p[j];
						min = Math.min(min, cost);
					}
					catch(Exception ex){
						System.out.println(i+" "+j+" "+k+" "+n+" "+L);
						ex.printStackTrace();
					}
				}
				mat[i][j] = min;
			}
		}

		return mat[1][n-1];
	}

}
