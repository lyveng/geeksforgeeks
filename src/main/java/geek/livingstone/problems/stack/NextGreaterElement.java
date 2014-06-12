package geek.livingstone.problems.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * Full problem at http://www.geeksforgeeks.org/next-greater-element/
 * 
 * @author emmanuel
 *
 */
public class NextGreaterElement {
  public static int[] nextGreaterElement(int[] arr) {
    Stack<Integer> s = new Stack<>();
    int[] nge = new int[arr.length];
    for (int i=0;i<arr.length;i++) {
      while (!s.empty() && arr[i]>arr[s.peek()])
      {
        nge[s.pop()] = i;
      }
      s.push(i);
    }
    while (!s.empty())
      nge[s.pop()] = -1;
    return nge;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(nextGreaterElement(new int[] {4,5,2,25})));
    System.out.println(Arrays.toString(nextGreaterElement(new int[] {11,13,21,3})));
  }

}
