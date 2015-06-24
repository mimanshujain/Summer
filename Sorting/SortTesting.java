package Sorting;

import java.util.Random;

public class SortTesting {

	public static void main(String[] args) {
		
		int size = 150000;
		int[] numbers = new int[size];
		Random randomGenerator = new Random();
		for(int i = 0; i < size;i++)
			numbers[i] = randomGenerator.nextInt(4*size);
		
		long startTime = 0;
		long endTime = 0;
		
		System.out.println("Insertion Sort Starts");
		Insertion insSort = new Insertion(numbers.clone());
//		insSort.print();
//		System.out.println();
		startTime= System.currentTimeMillis();
		insSort.sort();
		endTime = System.currentTimeMillis();
		System.out.println("Total Time taken: "+(endTime - startTime) + " milisec");
//		insSort.print();
		insSort.isSorted();
		System.out.println();
		
		System.out.println("Merge Sort Starts");
		Merge mergeSort = new Merge(numbers.clone());
//		mergeSort.print();
//		System.out.println();
		startTime = System.currentTimeMillis();
		mergeSort.sort(0, numbers.length - 1, new int[size]);
		endTime = System.currentTimeMillis();
		System.out.println("Total Time taken: "+(endTime - startTime) + " milisec");
//		mergeSort.print();
		mergeSort.isSorted();
		System.out.println();
		
		System.out.println("Quick Sort Starts");
		Quick quickSort = new Quick(numbers.clone());
//		quickSort.print();
//		System.out.println();
		startTime = System.currentTimeMillis();
		quickSort.sort(0, numbers.length - 1);
		endTime = System.currentTimeMillis();
		System.out.println("Total Time taken: "+(endTime - startTime) + " milisec");
//		quickSort.print();
		quickSort.isSorted();
		System.out.println();
		
		System.out.println("Randomized Quick Sort Starts");
		quickSort = new Quick(numbers.clone());
//		quickSort.print();
//		System.out.println();
		startTime = System.currentTimeMillis();
		quickSort.sortRandom(0, numbers.length - 1);
		endTime = System.currentTimeMillis();
		System.out.println("Total Time taken: "+(endTime - startTime) + " milisec");
//		quickSort.print();
		quickSort.isSorted();
		System.out.println();
		
		System.out.println("Selection Sort Starts");
		SelectionSort selectSort = new SelectionSort(numbers.clone());
//		quickSort.print();
//		System.out.println();
		startTime = System.currentTimeMillis();
		selectSort.sort();
		endTime = System.currentTimeMillis();
		System.out.println("Total Time taken: "+(endTime - startTime) + " milisec");
//		quickSort.print();
		selectSort.isSorted();
		System.out.println();
		
		System.out.println("Bubble Sort Starts");
		Bubble bubbleSort = new Bubble(numbers.clone());
//		quickSort.print();
//		System.out.println();
		startTime = System.currentTimeMillis();
		bubbleSort.sort();
		endTime = System.currentTimeMillis();
		System.out.println("Total Time taken: "+(endTime - startTime) + " milisec");
//		quickSort.print();
		bubbleSort.isSorted();
		System.out.println();
	}

}
