package datastructuresalgo;

public class MyQuickSortFinal {

	private int array[];
	private int length;

	public void sort(int[] inputArr) {

		if (inputArr == null || inputArr.length == 0) {
			return;
		}
		this.array = inputArr;
		length = inputArr.length;
		quickSort(0, length - 1);
	}

	private void quickSort(int lowerIndex, int higherIndex) {
		System.out.println("\n*******************************START OF quickSort*******************************");

		int leftPointer = lowerIndex;
		int rightPointer = higherIndex;

		/** Calculate pivot number, I am taking pivot as middle index number **/
		int pivotIndex = (leftPointer + (higherIndex - leftPointer) / 2);
		int pivotValue = array[pivotIndex];

		System.out.println("\nI(leftPointer) = " + leftPointer);
		System.out.println("\nJ(rightPointer) = " + rightPointer);
		System.out.println("\nP(pivotIndex) = " + pivotIndex);
		System.out.println("\nPV(pivotValue) = " + pivotValue);

		System.out.println("\nPrint Array BEFORE Partition Pass");
		printArray(array);

		// Divide into two arrays
		while (leftPointer <= rightPointer) {
			System.out.println("\n*******************************START OF PARTITION*******************************");

			System.out.println("\nPrint Array AT START OF PARTITION ");
			printArray(array);

			System.out.println("\nLEFT_POINTER = " + leftPointer);
			System.out.println("\nRIGHT_POINTER = " + rightPointer);
			System.out.println("\nPIVOT_VALUE  = " + pivotValue);

			/**
			 * In each iteration, we will identify a number from left side which
			 * is greater then the pivot value, and also we will identify a
			 * number from right side which is less then the pivot value. Once
			 * the search is done, then we exchange both numbers.
			 */

			/** Loop **/
			while (array[leftPointer] < pivotValue) {
				leftPointer++;
			}

			while (array[rightPointer] > pivotValue) {
				rightPointer--;
			}

			System.out.println("\nIdentify LEFT_POINTER = " + leftPointer);
			System.out.println("\nIdentify RIGHT_POINTER = " + rightPointer);
			System.out.println("\nLEFT_POINTER_VALUE = " + array[leftPointer]);
			System.out.println("\nRIGHT_POINTER_VALUE = " + array[rightPointer]);

			System.out.println(
					"\nIF LEFT_POINTER is SMALLER than or EQUAL RIGHT_POINTER then try to SWAP them if both values are diff");

			if (leftPointer <= rightPointer) {

				/**
				 * Swap only if both values are diff , if both values are same
				 * no sense to swap them
				 **/
				if (array[leftPointer] != array[rightPointer]) {
					System.out.println("\nSWAPING NOW");
					swapNumbers(leftPointer, rightPointer);
				}

				/** move index to next position on both sides **/
				leftPointer++;
				rightPointer--;
			}

			System.out.println("\nPrint Array AT END OF PARTITION ");
			printArray(array);

			System.out.println("\n*******************************END OF PARTITION*******************************");

		}

		System.out.println("\nPrint Array AFTER Partition Pass");
		printArray(array);

		System.out.println("\n*******************************END OF quickSort*******************************");

		/** call quickSort() method recursively **/
		if (lowerIndex < rightPointer)
			// System.out.println("\nCALL quickSort(lowerIndex, j)");
			quickSort(lowerIndex, rightPointer);
		if (leftPointer < higherIndex)
			// System.out.println("\nCALL quickSort(i, higherIndex);");
			quickSort(leftPointer, higherIndex);

	}

	private void swapNumbers(int i, int j) {
		System.out.println("\nSWAP LEFT_POINTER_VALUE = " + array[i]);
		System.out.println("\nSWAP RIGHT_POINTER_VALUE = " + array[j]);
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	/** A utility function to print array of size n */
	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static int[] generateRandomArray(int arraySize) {
		int[] array = new int[arraySize];
		for (int i = 0; i < arraySize; i++) {
			array[i] = (int) (Math.random() * 10) + 10;
		}
		return array;
	}

	public static void main(String a[]) {

		MyQuickSortFinal sorter = new MyQuickSortFinal();
		// int[] input = { 24, 2, 45, 20, 56, 75, 2, 56, 99, 53, 12 };
		// int[] input = { 10, 7, 8, 9, 1, 5 };
		// int[] input = { 10, 7, 8, 9};
		int[] input = { 12, 11, 19, 15, 10 };
		// int[] input = generateRandomArray(5);

		System.out.println("\nINPUT Array");
		printArray(input);
		sorter.sort(input);
		System.out.println("\nFINAL Sorted Array");
		printArray(input);
	}
}