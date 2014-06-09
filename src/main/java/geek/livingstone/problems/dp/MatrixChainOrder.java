package geek.livingstone.problems.dp;

import java.util.Arrays;

public class MatrixChainOrder {
  private int[][] minCost;

  public MatrixChainOrder(int[] mat) {
    minCost = new int[mat.length][mat.length];
    for (int i=1;i<mat.length;i++) {
      for (int j=i;j<mat.length;j++) {
        getCost(mat, i, j);
      }
    }
    for (int i=0;i<mat.length;i++)
      System.out.println(Arrays.toString(minCost[i]));
    System.out.println("Minimum no of operations is " + getCost(mat, 1, mat.length-1));
  }

  private int getCost(int[] mat, int i, int j) {
    assert i<=j;
    if (i == j)
      return 0;
    if (minCost[i][j] != 0)
      return minCost[i][j];
    minCost[i][j] = Integer.MAX_VALUE;
    for (int k=i;k<j;k++) {
      int minCostIJK = getCost(mat,i,k) + getCost(mat,k+1,j) + mat[i-1]*mat[k]*mat[j];
      if (minCostIJK < getCost(mat,i,j))
        minCost[i][j] = minCostIJK;
    }
    assert minCost[i][j] != Integer.MAX_VALUE;
    return minCost[i][j];
  }

  public static void main(String[] args) {
    new MatrixChainOrder(new int[]{40,20,30,10,30});
    new MatrixChainOrder(new int[]{10,20,30,40,30});
    new MatrixChainOrder(new int[]{10,20,30});
  }

}
