package geek.livingstone.problems.arrays;

/**
 * Full problem at
 * http://www.geeksforgeeks.org/search-floor-and-ceil-in-a-sorted-array/
 * 
 * @author emmanuel
 * 
 */
public class FloorInSortedArray {
	public static int floor(int[] A, int val) throws Exception {
		if (val < A[0])
			throw new Exception("All elements are greater than val");
		else if (val > A[A.length - 1])
			return A[A.length - 1];
		return floor(A, 0, A.length - 1, val);
	}

	private static int floor(int[] A, int l, int r, int val) throws Exception {
		if (l > r) {
			throw new Exception("Not found");
		}
		int mid = (l + r) / 2;
		if (val == A[mid])
			return A[mid];
		else if (val < A[mid]) {
			if (val >= A[mid - 1])
				return A[mid - 1];
			return floor(A, l, mid - 1, val);
		} else {
			if (val < A[mid + 1])
				return A[mid];
			return floor(A, mid + 1, r, val);
		}
	}

	public static void main(String[] args) throws Exception {
		int[] A = new int[] { 1, 3, 4, 7, 8, 12, 32, 45, 78, 98 };
		// System.out.println(floor(A, -45));
		System.out.println(floor(A, 11));
		System.out.println(floor(A, 32));
		System.out.println(floor(A, 70));
		System.out.println(floor(A, 125));
	}

}
