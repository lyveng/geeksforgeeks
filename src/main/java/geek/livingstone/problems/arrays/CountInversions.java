package geek.livingstone.problems.arrays;

import java.util.Arrays;

public class CountInversions {
	public static int count(int[] A) {
		int[] aux = new int[A.length];
		return countUtil(A, aux, 0, A.length - 1);
	}

	private static int countUtil(int[] A, int[] aux, int start, int end) {
		if (start >= end)
			return 0;
		int mid = (start + end) / 2;
		int left = countUtil(A, aux, start, mid);
		int right = countUtil(A, aux, mid + 1, end);
		int i, j, k, count = 0;
		for (i = start, j = mid + 1, k = start; i <= mid && j <= end
				&& k <= end; k++) {
			if (A[i] < A[j])
				aux[k] = A[i++];
			else {
				aux[k] = A[j++];
				count += (mid - i + 1);
			}
		}
		while (i <= mid)
			aux[k++] = A[i++];
		while (j <= end)
			aux[k++] = A[j++];
		for (i=start;i<=end;i++)
			A[i] = aux[i];
		return count + left + right;
	}

	public static void main(String[] args) {
		int[] A = new int[] {2, 4, 1, 3, 5};
		System.out.println(count(A));
		System.out.println(Arrays.toString(A));
	}

}
