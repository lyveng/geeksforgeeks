package geek.livingstone.problems.arrays;

/**
 * Full problem at
 * http://www.geeksforgeeks.org/given-an-array-arr-find-the-maximum
 * -j-i-such-that-arrj-arri/
 * 
 * @author emmanuel
 * 
 */
public class MaxJMinusI {
	public static int maxIndexDiff(int[] A) {
		int[] LMin = new int[A.length];
		int[] RMax = new int[A.length];
		int min = A[0];
		for (int i = 0; i < A.length; i++) {
			if (A[i] < min)
				min = A[i];
			LMin[i] = min;
		}
		int max = A[A.length - 1];
		for (int j = A.length - 1; j >= 0; j--) {
			if (A[j] > max)
				max = A[j];
			RMax[j] = max;
		}

		int i = 0, j = 0, maxDiff = -1;
		while (i < A.length && j < A.length) {
			if (LMin[i] < RMax[j]) {
				if (j - i > maxDiff)
					maxDiff = j - i;
				j++;
			} else
				i++;
		}
		return maxDiff;
	}

	public static void main(String[] args) {
		System.out.println(maxIndexDiff(new int[] { 34, 8, 10, 3, 2, 80, 30,
				33, 1 }));
		System.out.println(maxIndexDiff(new int[] { 9, 2, 3, 4, 5, 6, 7, 8, 18,
				0 }));
		System.out.println(maxIndexDiff(new int[] { 1, 2, 3, 4, 5, 6 }));
		System.out.println(maxIndexDiff(new int[] { 6, 5, 4, 3, 2, 1 }));
	}

}
