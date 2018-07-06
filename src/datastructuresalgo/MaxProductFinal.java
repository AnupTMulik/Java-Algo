package datastructuresalgo;

/**
 * @author ANUP
 */

public class MaxProductFinal {

	public static void main(String[] args) {

		int[] A = {100,20,20, 1, 2, 3, 2, 3, 2, 1, 3, 10, 12, 5, 52 };
		int product = 0;
		int maxProduct = 0;
		System.out.println("A size " + A.length);
		for (int i = 0; i < A.length; i = i + 3) {
			product = A[i] * A[i + 1] * A[i + 2];
			System.out.println("product = " + product);
			if (maxProduct <= product) {
				maxProduct = product;
			}
		}
		System.out.println("maxProduct =  " + maxProduct);
	}

}
