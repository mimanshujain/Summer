package Dynamic;
import java.util.Random;
import java.util.Stack;
//http://www.geeksforgeeks.org/dynamic-programming-set-3-longest-increasing-subsequence/
//I am using the Bottom to top approach, also know as iterative or Tabulated approach
//O(n^2) Algo
public class LongestIndependentSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random randomGen = new Random();
		int len = 10;
		int[] inp = new int[len];
		
		for(int i = 0; i < len; i++)
			inp[i] = randomGen.nextInt(2*len);
		
		for(int i = 0; i < len; i++)
			System.out.print(inp[i]+" ");
		
		System.out.println();
		System.out.println(lis(inp));
	}
	
	public static int lis(int[] inp){
		int len = inp.length;
		int[] lis = new int[len];
		
		//Initializing 1 for all
		for(int i = 0; i < len; i++)
			lis[i] = 1;
		
		for(int i = 1; i < len; i++){
			for(int j = 0; j < i; j++){
				if(inp[i] > inp[j] && lis[i] < lis[j] + 1)
					lis[i] = lis[j] + 1;
			}
		}
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < len; i++)
			max = Math.max(max, lis[i]);
		
		int temp = max;
		int k = len-1;
		Stack<Integer> stack = new Stack<Integer>();
		while(k >= 0){
			if(lis[k] == temp){
				stack.push(inp[k]);
				temp--;
			}		
			k--;
		}
		while(!stack.isEmpty())
			System.out.print(stack.pop()+" ");
		System.out.println();
		
		return max;
		
	}

}
