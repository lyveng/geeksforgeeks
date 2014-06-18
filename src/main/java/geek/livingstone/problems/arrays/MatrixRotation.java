package geek.livingstone.problems.arrays;

import java.util.Arrays;

/**
 * Full problem at http://www.geeksforgeeks.org/turn-an-image-by-90-degree/
 * 
 * @author emmanuel
 * 
 */
public class MatrixRotation {
	public static void printMatrix(int[][] mat) {
		System.out.println();
		for (int i=0;i<mat.length;i++)
			System.out.println(Arrays.toString(mat[i]));
		System.out.println();
	}

	public static int[][] rotate(int[][] mat) {
		int[][] rot = new int[mat[0].length][mat.length];
		int ri,rj;
		for (int i=0;i<mat.length;i++) {
			rj = mat.length - i - 1;
			for (int j=0;j<mat[i].length;j++) {
				ri = j;
				rot[ri][rj] = mat[i][j];
			}
		}
		return rot;
	}

	public static void main(String[] args) {
		int[][] image = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
		printMatrix(image);
		printMatrix(rotate(image));
	}

}
