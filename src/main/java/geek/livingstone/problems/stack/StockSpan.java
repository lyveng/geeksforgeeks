package geek.livingstone.problems.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * Full problem at http://www.geeksforgeeks.org/the-stock-span-problem/
 * 
 * @author emmanuel
 * 
 */
public class StockSpan {
  public static void calculate(int[] prices) {
    int[] span = new int[prices.length];
    Stack<Integer> s = new Stack<>();
    for (int i=0;i<prices.length;i++) {
      if (s.isEmpty())
        span[i] = 1;
      else {
        while (prices[s.peek()] < prices[i])
          s.pop();
        span[i] = i - s.peek();
      }
      s.push(i);
    }
    System.out.println(Arrays.toString(prices));
    System.out.println(Arrays.toString(span));
  }

  public static void main(String[] args) {
    calculate(new int[] {100, 80, 60, 70, 60, 75, 85});
  }

}
