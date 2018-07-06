package datastructuresalgo;

public class ArrayRecursion {

	public static void main(String[] args) {
		ArrayRecursion rec = new ArrayRecursion();
		
		int[] A = { 999, 2, 345, 5, 66, 77, 33, 77, 99, 35, 12 };
		
		System.out.println("\nInput Array size = " + A.length);
		
		int largest = rec.largestNumber(A, A.length - 1, A[0]);
		
		System.out.println("\nLARGEST = " + largest);
	}

	public int largestNumber(int[] A, int index, int largest) {
		System.out.println("\nindex = " + index);
		System.out.println("\nlargest = " + largest);
		
		if (index > 0) {
			
			if (A[index] > largest) {
				largest = A[index];
			}
			
			System.out.println("\nlargestNumber = " + largest);
			
			return largestNumber(A, index - 1, largest);
		}
		
		return largest;
	}

}
