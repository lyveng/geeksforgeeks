package geek.livingstone.problems.arrays;

/**
 * Find two repeating elements. Uses xor logic. Full problem at
 * http://www.geeksforgeeks.org/find-the-two-repeating-elements-in-a-given-array/
 * 
 * @author emmanuel
 * 
 */
public class FindTwoRepeatingElements {
	public static void findRepeating(int[] A) {
		int n = A.length - 2;
		int xor = A[0];
		for (int i = 1; i < A.length; i++)
			xor ^= A[i];
		for (int i = 1; i <= n; i++)
			xor ^= i;
		int setBitNo = xor & (-xor);
		int x = 0, y = 0;
		for (int i = 0; i < A.length; i++) {
			if ((A[i] & setBitNo) == 0)
				x ^= A[i];
			else
				y ^= A[i];
		}
		for (int i = 1; i <= n; i++)
			if ((i & setBitNo) == 0)
				x ^= i;
			else
				y ^= i;
		System.out.println(x);
		System.out.println(y);
	}

	public static void main(String[] args) {
		findRepeating(new int[] { 4, 2, 4, 5, 2, 3, 1 });
	}

}
