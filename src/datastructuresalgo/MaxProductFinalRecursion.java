package datastructuresalgo;

/**
 * @author ANUP
 */

public class MaxProductFinalRecursion {

	public static void main(String[] args) {

		int[] A = { 1, 2, 3, 2, 3, 2, 1, 3, 10, 12, 5, 52,100, 20, 20 };
		/*
		 * int product = 0; int maxProduct = 0; System.out.println("A size " +
		 * A.length); for (int i = 0; i < A.length; i = i + 3) { product = A[i]
		 * * A[i + 1] * A[i + 2]; System.out.println("product = " + product); if
		 * (maxProduct <= product) { maxProduct = product; } }
		 */

		System.out.println("\nInput Array size = " + A.length);

		MaxProductFinalRecursion max = new MaxProductFinalRecursion();

		int maxProd = max.maxProduct(A, 0, 0);

		System.out.println("maxProduct =  " + maxProd);
	}

	public int maxProduct(int A[], int index, int maxProd) {

		System.out.println("index =  " + index);

		if ((index + 3) > A.length) {
			return maxProd;
		}

		if ((A[index] * A[index + 1] * A[index + 2]) > maxProd) {
			maxProd = A[index] * A[index + 1] * A[index + 2];
			System.out.println("\nmaxProd = " + maxProd);
		}

		return maxProduct(A, index + 3, maxProd);
	}
}
