package Sorting;

public class SelectionSort {
	int[] num;
	public SelectionSort(int[] num)
	{
		this.num = num;
	}
	public void sort()
	{
		for(int i = 0; i < num.length-1; i++)
		{
			int min = i;
			for(int j = i+1; j < num.length; j++)
			{
				if(num[min] > num[j])
					min = j;
			}
			if(min != 0) swap(min,i);
		}
	}
	
	private void swap(int i, int j)
	{
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}
	
	public void print()
	{
		for(int i = 0;i < num.length;i++)
			System.out.print(num[i]+",");
	}
	
	public void isSorted()
	{
		boolean isSort = true;
		for(int i = 1;i < num.length;i++)
		{
			if(num[i] < num[i-1])
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
