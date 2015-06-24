package Sorting;

public class Quick {
	int[] numbers;

	public Quick(int[] numbers)
	{
		this.numbers = numbers;
	}
	
	public void sort(int start, int end)
	{
		if(start >= end) return;
		int pIndex = partition(start,end);
		sort(start,pIndex-1);
		sort(pIndex+1,end);		
	}
	
	public void sortRandom(int start, int end)
	{
		if(start >= end) return;
		int rIndex = Integer.parseInt(System.nanoTime()%(end-start) + start+"");
		swap(rIndex,end);
		int pIndex = partition(start,end);
		sort(start,pIndex-1);
		sort(pIndex+1,end);		
	}
	
	private int partition(int start, int end)
	{
		int pivot = numbers[end];
		int wall = start;
		for(int i = start; i < end; i++)
		{
			if(pivot > numbers[i]) 
			{
				swap(wall,i);
				wall++;
			}
		}
		
		swap(wall,end);		
		
		return wall;
	}
	
	private void swap(int i, int j)
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
