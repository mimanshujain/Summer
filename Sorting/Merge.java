package Sorting;

public class Merge {

	int[] numbers;
	
	public Merge(int[] numbers)
	{
		this.numbers = numbers;
	}
	
	//aux array should be passed when called sort
	public void sort(int low, int high, int[] aux)
	{
		if(high > low)
		{
			int mid = (high + low)/2; //mid = lo + (hi-lo)/2 can also be used
			sort(low,mid,aux);
			sort(mid+1,high,aux);
			merge(low,mid,high,aux);
		}		
	}
	
	//Got confused how to use aux array hence changed this way.
	//Copy all into aux first then update the main array.
	public void merge(int low, int mid, int high, int[] aux)
	{
		int i = low;
		int j = mid + 1;
		 
		for(int k = low; k <= high; k++)
			aux[k] = numbers[k];
		
		//This is the most important part.
		for(int k = low; k <= high; k++)
		{
			if(i > mid) numbers[k] = aux[j++];
			else if(j > high) numbers[k] = aux[i++];
			else if(aux[i] < aux[j]) numbers[k] = aux[i++];
			else numbers[k] = aux[j++];
		}
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
