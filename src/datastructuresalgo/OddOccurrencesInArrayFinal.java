package datastructuresalgo;

import java.util.Arrays;

/**
 * @author ANUP
 * 
 *         Image result for what are odd numberbrilliant.org An odd number is an
 *         integer which is not a multiple of two. If it is divided by two the
 *         result is a fraction. One is the first odd positive number. The next
 *         four bigger odd numbers are three, five, seven, and nine. ... An
 *         integer that is not an odd number is an even number.
 *
 */

public class OddOccurrencesInArrayFinal {

	public static void main(String[] args) {

		// int[] intArray = { 27, 29, 31, 1, 1, 5, 5, 7, 7, 3, 9, 9, 17, 17 };

		//int[] intArray = { 1, 1, 5, 5, 7, 7, 3, 3, 9, 9, 17, 17, 18 };

		// int[] intArray = { 9, 3, 9, 3, 9, 7, 9 };

		 int[] intArray = {9, 3, 9};

		System.out.println("\nInput Array");
		printArray(intArray);
		Arrays.sort(intArray);
		System.out.println("\nSorted Array");
		printArray(intArray);

		System.out.println("Sorted Array intArray size " + intArray.length);

		int index = 0;

		for (int i = 0; i <= intArray.length -1 ; i++) {

			if (i == intArray.length-1) {
				System.out.println("UnPared Element =  " + intArray[i] + " at Index = " + i);
			}else if (intArray[i] != intArray[i + 1]) {
				System.out.println("UnPared Element =  " + intArray[i] + " at Index = " + i);
				// unpared = A[i];
				break;
			} else {
				i++;
			}
			System.out.println("Counter i =  " + i);
		}

	}

	/** A utility function to print array of size n */
	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public int solution(int[] A) {

		int unpared = 0;

		System.out.println("this is a debug message");

		System.out.println("\nInput Array");
		printArray(A);
		Arrays.sort(A);
		System.out.println("\nSorted Array");
		printArray(A);

		System.out.println("Sorted Array A size " + A.length);

		for (int i = 1; i <= A.length - 1; i++) {
			if (i == A.length - 1) {
				/** Last Element then only compare left side **/
				if (A[i] != A[i - 1]) {
					System.out.println("UnPared Element =  " + A[i] + " at Index = " + i);
					unpared = A[i];
					break;
				}
			} else if (A[i] != A[i - 1] && A[i] != A[i + 1]) {
				System.out.println("UnPared Element =  " + A[i] + " at Index = " + i);
				unpared = A[i];
				break;
			}
			System.out.println("Counter i =  " + i);
		}

		return unpared;
	}

}
