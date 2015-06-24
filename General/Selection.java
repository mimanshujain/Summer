package General;
import java.util.Arrays;
import java.util.Random;

public class Selection {

	public static void main(String[] args) {
		Random randomGenerator = new Random();
		int size = 10;
		int[] num = new int[size];

		for(int i = 0;i < size; i++)
			num[i] = randomGenerator.nextInt(2*size);
		int pos = 4;
		print(num.clone());
		System.out.println();
		System.out.println("The selected num is : "+selection(0,size-1,num,pos));
	}

	private static int selection(int start, int end, int[] num, int k)
	{
		if(start >= end) 
			return num[start];

		int pIndex = partition(start, end, num);
		int partLength = pIndex - start;
		int pos = partLength + 1;

		if(pos == k) return num[pIndex];

		else if(pos > k) return selection(start, pIndex - 1, num, k);

		else return selection(pIndex + 1, end, num, k - (pIndex - start) - 1);

	}

	private static int partition(int start, int end, int[] num)
	{
		if(end < num.length)
		{
			int wall = start;
			int pivot = num[end];
			for(int i = start;i < end; i++)
			{
				if(num[i] < pivot)
				{
					swap(num,i,wall);
					wall++;
				}
			}
			swap(num, wall,end);
			return wall;
		}
		return -1;
	}

	private static void swap(int[] num, int i, int j)
	{
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}

	public static void print(int[] numbers)
	{
		Arrays.sort(numbers);
		for(int i = 0;i < numbers.length;i++)
			System.out.print(numbers[i]+",");
	}
}