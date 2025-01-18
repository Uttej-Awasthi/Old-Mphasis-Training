package com;

public class CustomSortingExample {
	public static void selectionSort(int num[], int size) {
		for(int i=0;i<size-1;i++) {
			int min = i;
				for(int j=i+1;j<size;j++) {
					if(num[j]>num[min]) {
						min = j;
					}
				}
				int temp = num[i];
				num[i]=num[min];
				num[min]=temp;
		}
	}	
	public static void bubbleSort(int num[], int size) {
		for(int i=0;i<size-1;i++) {
				for(int j=0;j<size-1-i;j++) {
					if(num[j] < num[j+1]) {
					int temp = num[j];
					num[j]=num[j+1];
					num[j+1]=temp;
				}
				
			}
		}
	}
	public static int linearSearch(int num[], int size, int searchElement) {
				for(int i=0;i<size;i++) {
					if(num[i]==searchElement) {
						return i;
					}
				}
				return -1;
	}
	public static void main(String[] args) {
		String str = "Abc";
		
		int num[]= {3,1,6,4,9,7,6};
		int i = linearSearch(num, num.length, 6);
		if(i>=0) {
			System.out.println("Element found  at position "+i);
		}else {
			System.out.println("Element is not present ");
		}
//		System.out.println("Before sort");
//		for(int n:num) {
//			System.out.print(n+" ");
//		}
		//CustomSortingExample.selectionSort(num, num.length);
//		CustomSortingExample.bubbleSort(num, num.length);
//		System.out.println();
//		System.out.println("After sort");
//		for(int n:num) {
//			System.out.print(n+" ");
//		}
	}

}
