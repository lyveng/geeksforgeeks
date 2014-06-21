package geek.livingstone.problems.arrays;

import java.util.Arrays;

/**
 * Dutch National Flag problem. Full problem at
 * http://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/
 * 
 * @author emmanuel
 * 
 */
public class Segregate012 {
	public static void seggregate(int[] A) {
		int lo = 0, mid = 0, high = A.length - 1;
		// Invariants
		// 1. 0 to lo-1 are zeros
		// 2. lo to mid are ones
		// 3. high+1 to end are twos
		// 4. mid+1 to high are unknown
		while (mid <= high) {
			if (A[mid] == 0) {
				swap(A, lo, mid);
				lo++;
				mid++;
			} else if (A[mid] == 1) {
				mid++;
			} else {
				swap(A, mid, high);
				high--;
			}
		}
	}

	private static void swap(int[] A, int i, int j) {
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}

	public static void main(String[] args) {
		int[] A = new int[] { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
		System.out.println(Arrays.toString(A));
		seggregate(A);
		System.out.println(Arrays.toString(A));
	}

}
