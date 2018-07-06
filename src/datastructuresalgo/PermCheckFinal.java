package datastructuresalgo;

import java.util.Arrays;
import java.util.HashSet;

public class PermCheckFinal {

	
public int solution(int[] A) {
        
        Arrays.sort(A);
        boolean permCheck = false;
		int minValue = A[0];
		int searchValue = 0;
		int value = 0;
        
       if (isDuplicate(A) || (A[0] != 1)) {
			/** If dups are present or starting poistion is not 1 **/
			return 0;
		} else if ((A.length == 1) && (A[0] == 1)) {
			/** If Array contains only one element make sure it should be only 1 **/
			return 1;
		} else {
			for (int i = 0; i < A.length- 1; i++) {
			    /** Traverse Array till last element - 1 **/
				searchValue = minValue + (i + 1);
				int searchIndex = recursiveBinarySearch(A, 0, A.length, searchValue);
				if (searchIndex >= 0 && searchIndex <= A.length) {
					permCheck = true;
				} else {
				    /** searchIndex -ve means search value not present **/
					permCheck = false;
					break;
				}
			}
		}

		if (permCheck == true) {
			return 1;
		} else {
			return 0;
		}
    }
    
    public static boolean isDuplicate(int[] A) {
		boolean isDuplicate = false;
		HashSet set = new HashSet();
		for (int i = 0; i < A.length; i++) {
			if (!set.add(A[i])) {
				isDuplicate = true;
			}
		}
		return isDuplicate;
	}

	public static int recursiveBinarySearch(int[] sortedArray, int start, int end, int key) {
		if (start < end) {
			int mid = start + (end - start) / 2;
			if (key < sortedArray[mid]) {
				return recursiveBinarySearch(sortedArray, start, mid, key);
			} else if (key > sortedArray[mid]) {
				return recursiveBinarySearch(sortedArray, mid + 1, end, key);
			} else {
				return mid;
			}
		}
		return -(start + 1);
	}
	
}
