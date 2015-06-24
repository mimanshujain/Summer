package Sorting;

public class Insertion {

	int[] numbers;
	
	public Insertion(int[] numbers)
	{
		this.numbers = numbers;
	}
	
	public void sort()
	{
		for(int i = 1; i < numbers.length; i++)
		{
			int k = i;
			for(int j = i-1; j >= 0; j--)
			{
				if(numbers[k] < numbers[j])
					swap(k,j);
				else break;
				k = j;
			}
		}
	}
	
	public void swap(int i, int j)
	{
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
	
	public void print()
	{
		for(int i = 0;i < numbers.length;i++)
		System.out.print(numbers[i]+",");
	}
	
	public void isSorted()
	{
		boolean isSort = true;
		for(int i = 1;i < numbers.length;i++)
		{
			if(numbers[i] < numbers[i-1])
			{
				isSort = false;
				break;
			}			
		}
		if(isSort)
			System.out.println("Sorted");
		else
			System.out.println("Not Sorted");
	}	
}
