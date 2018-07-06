package datastructuresalgo;

/**
 * @author ANUP
 * 
 *         [3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7] 
 *         [6, 3, 8, 9, 7] -> [7, 6, 3, 8, 9]
 *         [7, 6, 3, 8, 9] -> [9, 7, 6, 3, 8]
 *         
 *         3 8 9 7 6
 *         6 8 9 7 3
 *         6 3 9 7 8
 *         6 3 8 7 9
 *         6 3 8 9 7
 *         
 *         tmp = 8
 *         3
 *
 */

public class CyclicRotationFinal {

	public static void main(String[] args) {

		int[] A = { 3, 8, 9, 7, 6 };

		int noOfRotations = 4;

		//int tmp = 0;
		
		System.out.println("A size " + A.length);
		
		for (int i = 0 ; i < noOfRotations ; i++) {
			for (int j = 0 ; j < A.length ; j++) {
				int tmp = A[j];
				A[j] = A[A.length-1];
				A[A.length-1] = tmp;
			}
		}
		
		System.out.println("\nPrint A");
		for (int i = 0 ; i < A.length ; i++) {
			System.out.println(A[i]);
		}

	}
	
	    public int[] solution(int[] A, int K) {
        // write your code in Java SE 8
		for (int i = 0 ; i < K ; i++) {
			for (int j = 0 ; j < A.length ; j++) {
				int tmp = A[j];
				A[j] = A[A.length-1];
				A[A.length-1] = tmp;
			}
		}
		return A;
    }

}
