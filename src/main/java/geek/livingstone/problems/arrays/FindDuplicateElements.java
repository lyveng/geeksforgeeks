package geek.livingstone.problems.arrays;

/**
 * Full problem at
 * http://www.geeksforgeeks.org/find-duplicates-in-on-time-and-constant-extra-space/
 * 
 * @author emmanuel
 * 
 */
public class FindDuplicateElements {
	public static void find(int[] A, int n) {
		for (int i = 0; i < A.length; i++) {
			if (A[Math.abs(A[i])] < 0)
				System.out.print(Math.abs(A[i]) + " ");
			else
				A[Math.abs(A[i])] = -A[Math.abs(A[i])];
		}
		System.out.println();
		;
	}

	public static void main(String[] args) {
		find(new int[] { 2, 4, 3, 4, 5, 1, 2, 2 }, 5);
		find(new int[] { 1, 1, 1, 2, 1, 1 }, 2);
	}

}
