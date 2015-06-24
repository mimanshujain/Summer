package Dynamic;

//http://www.geeksforgeeks.org/dynamic-programming-set-4-longest-common-subsequence/
//Dynamic Bottom up iterative solution, better than recursive.
public class LongestCommonSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lcs("AGGTAB", "GXTXAYB"));
	}
	
	public static String lcs(String s, String t){
		int m = s.length();
		int n = t.length();
		if(m == 0 || n == 0)
			return "";
		
		int[][] mat = new int[m+1][n+1];
		
		for(int i = 0; i <= m; i++){
			for(int j = 0; j <= n; j++){
				if(i == 0 || j == 0)
					mat[i][j] = 0;
				else if(s.charAt(i-1) == t.charAt(j-1)){
//					System.out.println(s.charAt(i-1));
					mat[i][j] = 1 + mat[i-1][j-1];
				}
				else
					mat[i][j] = Math.max(mat[i-1][j], mat[i][j-1]);
			}
		}
		int len = mat[m][n];
		System.out.println("Length of longest common subsequence is: "+len);
		char[] sequence = new char[len];
		int i = m;
		int j = n;
		while(i > 0 && j > 0){
			if(s.charAt(i-1) == t.charAt(j-1)){
				sequence[len-1] = s.charAt(i-1);
				i--;j--;len--;
			}
			else if(mat[i-1][j] > mat[i][j-1])
				i--;
			else
				j--;
			
		}
		
		return new String(sequence);
	}

}
