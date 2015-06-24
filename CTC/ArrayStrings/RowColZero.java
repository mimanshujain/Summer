package CTC.ArrayStrings;
import java.util.ArrayList;

public class RowColZero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{1,0,3,4},{5,6,0,8},{9,10,11,12},{13,14,15,16}};
		
		for(int i = 0; i < matrix[0].length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
		
		RowColZero test = new RowColZero();
		test.setZero(matrix);
		System.out.println();
		for(int i = 0; i < matrix[0].length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}

	public void setZero(int[][] matrix){
		ArrayList<Integer> rows = new ArrayList<Integer>();
		ArrayList<Integer> cols = new ArrayList<Integer>();
		
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[i].length; j++){
				if(matrix[i][j] == 0){
					rows.add(i);
					cols.add(j);
				}
			}
		}
		
		for(int i : rows){
			for(int j = 0; j < matrix[i].length; j++)
				matrix[i][j] = 0;
		}
		
		for(int j : cols){
			for(int i = 0; i < matrix.length; i++)
				matrix[i][j] = 0;
		}
	}
}
