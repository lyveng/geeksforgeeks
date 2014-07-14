package geek.livingstone.problems.stack;

import java.util.Stack;

/**
 * Full problem at http://www.geeksforgeeks.org/reverse-a-stack-using-recursion/
 * 
 * @author emmanuel
 * 
 */
public class ReverseUsingRecursion {
  private static void insertAtBottom(Stack<Integer> s, int item) {
    if (s.isEmpty())
      s.push(item);
    else {
      int tmp = s.pop();
      insertAtBottom(s, item);
      s.push(tmp);
    }
  }

  private static void reverse(Stack<Integer> s) {
    if (!s.isEmpty()) {
      int tmp = s.pop();
      reverse(s);
      insertAtBottom(s, tmp);
    }
  }

  public static void main(String[] args) {
    Stack<Integer> s = new Stack<>();
    s.push(1);
    s.push(2);
    s.push(3);
    s.push(4);
    System.out.println(s.toString());
    reverse(s);
    System.out.println(s.toString());
  }

}
