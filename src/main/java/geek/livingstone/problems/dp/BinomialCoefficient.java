package geek.livingstone.problems.dp;

/**
 * Full problem at http://www.geeksforgeeks.org/dynamic-programming-set-9-binomial-coefficient/
 * 
 * @author emmanuel
 * 
 */
public class BinomialCoefficient {
  // C(n, k) = C(n-1, k-1) + C(n-1, k)
  public static void binomialCoefficient(int n, int k) {
    int[][] b = new int[n + 1][k + 1];
    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= Math.min(k, i); j++) {
        if (j == 0 || j == i)
          b[i][j] = 1;
        else
          b[i][j] = b[i - 1][j - 1] + b[i - 1][j];
      }
    }
    System.out.println(b[n][k]);
  }

  public static void main(String[] args) {
    binomialCoefficient(4, 2);
    binomialCoefficient(5, 2);
  }
}
