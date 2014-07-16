package geek.livingstone.problems.dp;


public class MatrixChainOrder {
  public static void minMultiplications(int[] p) {
    int[][] m = new int[p.length][p.length];
    int n = p.length;
    for (int L=2;L<n;L++) {
      for (int i=1;i<n-L+1;i++) {
        int j = i + L - 1;
        m[i][j] = Integer.MAX_VALUE;
        for (int k=i;k<j;k++) {
          m[i][j] = Math.min(m[i][j], m[i][k] + m[k+1][j] + p[i-1]*p[k]*p[j]);
        }
      }
    }
    System.out.println(m[1][n-1]);
  }

  public static void main(String[] args) {
    minMultiplications(new int[]{40,20,30,10,30});
    minMultiplications(new int[]{10,20,30,40,30});
    minMultiplications(new int[]{10,20,30});
  }

}
