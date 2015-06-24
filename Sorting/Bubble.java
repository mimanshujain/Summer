package Sorting;

public class Bubble {

	int[] numbers;
	public Bubble(int[] numbers)
	{
		this.numbers = numbers;
	}

	public void sort()
	{
		int last = numbers.length - 2;
		while(last != 0)
		{
			for(int i = 0; i <= last; i++)
			{
				if(numbers[i] > numbers[i+1])
					swap(i,i+1);
			}
			last--;
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
