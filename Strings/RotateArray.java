package Strings;
import General.GCD;
import java.util.Random;

//http://www.geeksforgeeks.org/array-rotation/
//Time complexity: O(n)
//Auxiliary Space: O(1)
public class RotateArray {

	public static void main(String[] args) {
		int size = 7;
		int[] numbers = new int[size];
		Random randomGenerator = new Random();
		for(int i = 0; i < size;i++)
			numbers[i] = randomGenerator.nextInt(4*size);
		
		RotateArray rotate = new RotateArray();
		rotate.print(numbers);
		rotate.leftRotate(numbers, 3);
		System.out.println();
		rotate.print(numbers);
	}
	
	//d = number by which rotation has to be done.
	public void leftRotate(int[] num, int d)
	{
		if(d == 0) return;
		int len = num.length;
		int setCount = new GCD().gcd(len, d);
		
		for(int i = 0; i < setCount; i++)
		{
			int temp = num[i];
			int j = i;
			int k = j + d;
			
			while(true)
			{
				//When k gets bigger than length, then decrease it
				if(k >= len) k = k - len;				
				//Break when the k equal to the current position index
				if(k == i) break;
				
				num[j] = num[k];
				j = k;
				k = j + d;
			}
			num[j] = temp;
		}
	}

	public void swap(int[] numbers, int i, int j)
	{
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
	
	public void print(int[] numbers)
	{
		for(int i = 0;i < numbers.length;i++)
		System.out.print(numbers[i]+",");
	}
	
}


