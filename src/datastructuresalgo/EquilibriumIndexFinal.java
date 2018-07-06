package datastructuresalgo;

import java.util.Arrays;
import java.util.List;

public class EquilibriumIndexFinal {

	public static void main(String[] args) {

		Integer[] intArray = { -7, 1, 5, 2, -4, 3, 0 };
		List<Integer> list = Arrays.asList(intArray);
		int leftSum = 0;
		int rightSum = 0;

		System.out.println("intArray size " + intArray.length);

		for (int i = 0; i < intArray.length; i++) {
			System.out.println("Print intArray elements " + intArray[i]);
			rightSum = rightSum + intArray[i];
		}
		System.out.println("\nTotal rightSum = " + rightSum);

		for (int j = 0; j < intArray.length; j++) {
			rightSum = rightSum - intArray[j];
			System.out.println("rightSum = " + rightSum);
			if (leftSum == rightSum) {
				System.out.println("*************************EquilibriumIndex " + j);
				System.out.println("*************************EquilibriumIndex Value " + intArray[j]);
			}
			leftSum = leftSum + intArray[j];
			System.out.println("leftSum = " + rightSum);
		}

	}

	public static int addListElements(int startIndex, int endIndex, List<Integer> list) {
		int addValue = 0;
		int indxValue = 0;
		for (int i = startIndex; i <= endIndex; i++) {
			indxValue = list.get(i).intValue();
			System.out.println("***indxValue " + indxValue);
			addValue = addValue + indxValue;
			System.out.println("***addValue " + addValue);
		}
		return addValue;
	}

}
