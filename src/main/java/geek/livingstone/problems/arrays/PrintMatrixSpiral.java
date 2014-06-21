package geek.livingstone.problems.arrays;


/**
 * Full problem at http://www.geeksforgeeks.org/print-a-given-matrix-in-spiral-form/
 * 
 * @author emmanuel
 * 
 */
public class PrintMatrixSpiral {
  public static void printMatrix(int[][] mat, int m, int n) {
    /*
     * k = starting row m = ending row l = starting col n = ending col
     */
    int k = 0, l = 0, i;
    while (k < m && l < n) {
      // print first row of remaining rows
      for (i = l; i < n; i++)
        System.out.print(mat[k][i] + " ");
      k++;

      // print last col of remaining cols
      for (i = k; i < m; i++)
        System.out.print(mat[i][n - 1] + " ");
      n--;

      // print last row of remaining rows
      if (k < m) {
        for (i = n - 1; i >= l; i--)
          System.out.print(mat[m - 1][i] + " ");
        m--;
      }

      // print first col of remaining cols
      if (l < n) {
        for (i = m - 1; i >= k; i--)
          System.out.print(mat[i][l] + " ");
        l++;
      }
    }
  }

  public static void main(String[] args) {
    int[][] a = new int[3][];
    a[0] = new int[] {1, 2, 3, 4, 5, 6};
    a[1] = new int[] {7, 8, 9, 10, 11, 12};
    a[2] = new int[] {13, 14, 15, 16, 17, 18};
    printMatrix(a, 3, 6);
  }
}
