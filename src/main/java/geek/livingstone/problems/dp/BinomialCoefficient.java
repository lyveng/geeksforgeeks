package geek.livingstone.problems.dp;

import java.util.Arrays;

public class BinomialCoefficient {
  
  private int[][] B;
  public BinomialCoefficient(int n, int k) {
    B = new int[n+1][k+1];
    for (int i=0;i<=n;i++) {
      for (int j=0;j<=k;j++) {
        if (i == 0 && j==0)
          B[i][j] = 0;
        else if (i==0)
          B[i][j] = 0;
        else if (j==0 || i==j)
          B[i][j] = 1;
        else {
          B[i][j] = B[i-1][j-1] + B[i-1][j];
        }
      }
    }
    for (int i=0;i<=n;i++)
      System.out.println(Arrays.toString(B[i]));
    System.out.println("Binomial Coefficient is " + B[n][k]);
  }

  public static void main(String[] args) {
    new BinomialCoefficient(4, 2);
    new BinomialCoefficient(5, 2);
  }
}
