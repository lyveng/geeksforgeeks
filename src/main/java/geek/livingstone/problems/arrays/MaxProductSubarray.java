package geek.livingstone.problems.arrays;

/**
 * Full problem at http://www.geeksforgeeks.org/maximum-product-subarray/
 * 
 * @author emmanuel
 * 
 */
public class MaxProductSubarray {
  public static void maxProdSubarray(int[] A) {
    int maxNegProd = 1, maxPosProd = 1, tmp;
    int maxProd = 1;
    for (int i = 0; i < A.length; i++) {
      if (A[i] == 0) {
        maxNegProd = 1;
        maxPosProd = 1;
      } else if (A[i] > 0) {
        maxNegProd = Math.min(maxNegProd * A[i], A[1]);
        maxPosProd *= A[i];
      } else {
        tmp = maxNegProd;
        maxNegProd = maxPosProd * A[i];
        maxPosProd = Math.max(tmp * A[i], 1);
      }
      if (maxPosProd > maxProd)
        maxProd = maxPosProd;
    }
    System.out.println(maxProd);
  }

  public static void main(String[] args) {
    maxProdSubarray(new int[] {6, -3, -10, 0, 2});
    maxProdSubarray(new int[] {-1, -3, -10, 0, 60});
    maxProdSubarray(new int[] {-2, -3, 0, -2, -40});
  }

}
