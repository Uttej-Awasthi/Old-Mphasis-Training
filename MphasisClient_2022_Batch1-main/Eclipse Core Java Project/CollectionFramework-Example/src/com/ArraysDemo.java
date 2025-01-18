package com;
import java.io.File;
import java.util.Arrays;
public class ArraysDemo {
	public static void main(String[] args) {
//		File ff = new File("C:\\user\akash");
//		ff.
		int num[]= {2,1,7,3,5,6,9};
		System.out.println("Before sort ");
		for(int n:num) {
			System.out.print(n+" ");
		}
		System.out.println();
		Arrays.sort(num);
		System.out.println("After sort ");
		for(int n:num) {
			System.out.print(n+" ");
		}
		System.out.println();
		System.out.println(Arrays.binarySearch(num, 2));
		System.out.println(Arrays.binarySearch(num, 10));
		if(Arrays.binarySearch(num, 10)>0) {
			System.out.println("present");
		}else {
			System.out.println("not present");
		}
	}

}
