package Dynamic;

public class LevenshteinDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(levensteinDis("a", "ssk"));
	}
	//Convert s to t
	public static int levensteinDis(String s, String t){
		int n = s.length();
		int m = t.length();
		
		int[][] mat = new int[n+1][m+1];
		
		for(int i = 0; i <= n; i++){
			for(int j = 0; j <= m; j++){
				if(i == 0 || j == 0)
					mat[i][j] = i!=0?i:j;
				else if(s.charAt(i-1) == t.charAt(j-1))
					mat[i][j] = mat[i-1][j-1];
			else								
					//i-1 == Delete, j-1 == Insertion, Diagonal = Replace 
					mat[i][j] = Math.min(Math.min(mat[i-1][j], mat[i][j-1]), mat[i-1][j-1]) + 1;
			}
		}
		
		return mat[n][m];
	}

}
