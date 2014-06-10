package geek.livingstone.problems.dp;

public class CutRod {
  public CutRod(int[] price) {
    // maxValues[i] stores the maximum value that can be generated from a rod of length i.
    int n = price.length;
    int[] maxValues = new int[n+1];
    maxValues[0] = 0;
    for (int l=1;l<=n;l++) {
      maxValues[l] = Integer.MIN_VALUE;
      for (int i=1;i<=l;i++) {
        int val = price[i-1] + maxValues[l-i];
        if (val > maxValues[l])
          maxValues[l] = val;
      }
    }
    System.out.println("Maximum value will be " + maxValues[n]);
  }

  public static void main(String[] args) {
    new CutRod(new int[]{1,5,8,9,10,17,17,20});
    new CutRod(new int[]{3,5,8,9,10,17,17,20});
  }

}
