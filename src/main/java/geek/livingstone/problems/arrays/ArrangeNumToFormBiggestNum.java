package geek.livingstone.problems.arrays;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Full problem at
 * http://www.geeksforgeeks.org/given-an-array-of-numbers-arrange-the-numbers-to-form
 * -the-biggest-number/
 * 
 * @author emmanuel
 * 
 */
public class ArrangeNumToFormBiggestNum {
  public static String arrange(int[] arr) {
    String[] s = new String[arr.length];
    for (int i = 0; i < arr.length; i++) {
      s[i] = Integer.toString(arr[i]);
    }
    Arrays.sort(s, new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        String xy = o1 + o2;
        String yx = o2 + o1;
        return yx.compareTo(xy);
      }
    });
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length; i++) {
      sb.append(s[i]);
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    System.out.println(arrange(new int[] {54, 546, 548, 60}));
    System.out.println(arrange(new int[] {1, 34, 3, 98, 9, 76, 45, 4}));
  }

}
