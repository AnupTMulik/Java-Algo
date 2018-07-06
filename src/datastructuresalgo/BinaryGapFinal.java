package datastructuresalgo;

/**
 * @author ANUP
 */

public class BinaryGapFinal {

	public static void main(String[] args) {
		// write your code in Java SE 8

		// String binaryIntInStr = Integer.toBinaryString(N);

		String binaryIntInStr1 = "10000010001100001100000100000000";

		// String binaryIntInStr = "1001000100000000000000000";

		// String binaryIntInStr = "1001000100000000000000000";

		// String binaryIntInStr = "1001000100000000000000000";

		// String binaryIntInStr = "000000001001000100001";

		// String binaryIntInStr = "00000000100000000000000000100010000000001";

		// String binaryIntInStr =
		// "0000000010000000000000000010001000000000100000000000000000";

		String binaryIntInStr = "0000000010000000000000001000100000000000000000100000000000000000";

		System.out.println("binaryIntInStr " + binaryIntInStr);

		System.out.println("\n************************************************");
		System.out.println("\n************************************************");

		char A[] = binaryIntInStr.toCharArray();

		int zeroCountPerBinGap = 0;
		int maxZeroCount = 0;
		int traceOneCount = 0;

		for (int i = 0; i < A.length; i++) {
			if (A[i] == '1') {
				traceOneCount = traceOneCount + 1;
			} else if (traceOneCount == 1) {
				zeroCountPerBinGap = zeroCountPerBinGap + 1;
			}
			if (traceOneCount == 2) {
				System.out.println("traceOneCount is 2 that is end of binary count unit , Reset Values");
				if (maxZeroCount < zeroCountPerBinGap) {
					maxZeroCount = zeroCountPerBinGap;
				}
				traceOneCount = 1;
				zeroCountPerBinGap = 0;
			}
			System.out.println("traceOneCount = " + traceOneCount);
			System.out.println("zeroCountPerBinGap = " + zeroCountPerBinGap);
			System.out.println("maxZeroCount = " + maxZeroCount);
			System.out.println("\n************************************************");
		}
		System.out.println("Final maxZeroCount = " + maxZeroCount);
	}

	public int solution(int N) {
		// write your code in Java SE 8

		String binaryIntInStr = Integer.toBinaryString(N);

		char A[] = binaryIntInStr.toCharArray();

		int zeroCountPerBinGap = 0;
		int maxZeroCount = 0;
		int traceOneCount = 0;

		for (int i = 0; i < A.length; i++) {

			if (A[i] == '1') {
				traceOneCount = traceOneCount + 1;
			} else if (traceOneCount == 1) {
				zeroCountPerBinGap = zeroCountPerBinGap + 1;
			}

			if (traceOneCount == 2) {
				if (maxZeroCount < zeroCountPerBinGap) {
					maxZeroCount = zeroCountPerBinGap;
				}
				traceOneCount = 1;
				zeroCountPerBinGap = 0;
			}

		}
		return maxZeroCount;
	}

}
