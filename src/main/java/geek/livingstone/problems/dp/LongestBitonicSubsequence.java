package geek.livingstone.problems.dp;

import java.util.Arrays;

/**
 * Full problem at http://www.geeksforgeeks.org/dynamic-programming-set-17-palindrome-partitioning/
 * 
 * @author emmanuel
 * 
 */
public class LongestBitonicSubsequence {
  public LongestBitonicSubsequence(int[] arr) {
    // lis[i] is the length of longest increasing subsequence of arr[0...i]
    // lds[i] is the length of longest decreasing subsequence of arr[i...n-1]
    int[] lis = new int[arr.length], lds = new int[arr.length];
    for (int i=0;i<arr.length;i++) {
      lis[i] = 1;
      for (int j=0;j<i;j++) {
        if (arr[j] < arr[i] && (lis[j] + 1) > lis[i])
          lis[i] = lis[j] + 1;
      }
    }
    for (int i=arr.length-1;i>=0;i--) {
      lds[i] = 1;
      for (int j=i;j<arr.length;j++) {
        if (arr[j] < arr[i] && (lds[j] + 1) > lds[i])
          lds[i] = lds[j] + 1;
      }
    }
    int maxLength = Integer.MIN_VALUE;
    for (int i=0;i<arr.length;i++) 
      if ((lis[i]+lds[i]-1) > maxLength)
        maxLength = lis[i]+lds[i]-1;
    System.out.println(String.format("Longest bitonic subsequence in %s is %s", Arrays.toString(arr), maxLength));
  }

  public static void main(String[] args) {
    new LongestBitonicSubsequence(new int[] {1,11,2,10,4,5,2,1});
    new LongestBitonicSubsequence(new int[] {12,11,40,5,3,1});
    new LongestBitonicSubsequence(new int[] {80,60,30,40,20,10});
  }

}
