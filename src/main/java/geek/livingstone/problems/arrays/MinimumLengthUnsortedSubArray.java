package geek.livingstone.problems.arrays;

/**
 * Full problem at
 * http://www.geeksforgeeks.org/minimum-length-unsorted-subarray-
 * sorting-which-makes-the-complete-array-sorted/
 * 
 * @author emmanuel
 * 
 */
public class MinimumLengthUnsortedSubArray {
	public static void minLength(int[] A) {
		int left=0, right=A.length;
		for (int i=0;i<A.length-1;i++) {
			if (A[i] > A[i+1]) {
				left = i;
				break;
			}
		}
		if (left == 0) {
			System.out.println("Array is already sorted.");
			return;
		}
		for (int i=A.length-1;i>0;i--)
			if (A[i-1] > A[i]) {
				right = i;
				break;
			}
		if (left > right) {
			int tmp = left;
			left = right;
			right = tmp;
		}
		int min=left,max=left;
		for (int i=left;i<=right;i++)
		{
			if (A[i] < A[min])
				min = i;
			if (A[i] > A[max])
				max = i;
		}
		System.out.println(String.format("left=%d, right=%d", left, right));
		for (int i=0;i<A.length-1;i++)
			if (A[i] > A[min])
			{
				min = i;
				break;
			}
		for (int i=A.length-1;i>0;i--)
			if (A[i] < A[max])
			{
				max = i;
				break;
			}
		
		System.out.println(min);
		System.out.println(max);
	}

	public static void main(String[] args) {
		minLength(new int[] {10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60});
		minLength(new int[] {0, 1, 15, 25, 6, 7, 30, 40, 50});
	}

}
