package geek.livingstone.problems.dp;

/**
 * Full problem at http://www.geeksforgeeks.org/dynamic-programming-set-13-cutting-a-rod/
 * 
 * @author emmanuel
 * 
 */
public class CutRod {
  public static void cutRod(int[] prices) {
    int[] maxPrice = prices.clone();
    for (int i = 1; i < maxPrice.length; i++) {
      for (int j = 0; j < i; j++)
        maxPrice[i] = Math.max(maxPrice[i], maxPrice[j] + maxPrice[i - j - 1]);
    }
    System.out.println(maxPrice[prices.length - 1]);
  }

  public static void main(String[] args) {
    cutRod(new int[] {1, 5, 8, 9, 10, 17, 17, 20});
    cutRod(new int[] {3, 5, 8, 9, 10, 17, 17, 20});
  }

}
