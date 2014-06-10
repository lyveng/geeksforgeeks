package geek.livingstone.problems.dp;

import java.util.Arrays;
import java.util.Collections;

/**
 * Full problem at http://www.geeksforgeeks.org/dynamic-programming-set-14-maximum-sum-increasing-subsequence/
 * 
 * @author emmanuel
 *
 */
public class MaxSumIncreasingSubsequence {

  public MaxSumIncreasingSubsequence(int[] s) {
    Integer[] mis = new Integer[s.length];
    for (int i=0;i<s.length;i++) {
      mis[i] = s[i];
      for (int j=0;j<i;j++) {
        if (s[j] < s[i] && (mis[j]+s[i]) > mis[i])
          mis[i] = mis[j]+s[i];
      }
    }
    System.out.println("Maximum increasing subsequence sum is " + Collections.max(Arrays.asList(mis)));
  }

  public static void main(String[] args) {
    new MaxSumIncreasingSubsequence(new int[]{1,101,2,3,100,4,5});
  }

}
