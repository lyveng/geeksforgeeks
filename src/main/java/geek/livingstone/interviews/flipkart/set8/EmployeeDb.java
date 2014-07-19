package geek.livingstone.interviews.flipkart.set8;

import java.util.List;

public class EmployeeDb {
  private Node root;

  public EmployeeDb() {
    root = null;
  }

  public void insert(String emp) {
    if (root == null)
      root = new Node(emp, 0);
    else
      root.insert(emp, 0);
  }

  public void printPrefixes(String prefix) {
    
  }

  private static class Node {
    char value;
    boolean isLeafNode;
    Node left, down, right;

    Node(String emp, int index) {
      value = emp.charAt(index);
      if (index == emp.length() - 1)
        isLeafNode = true;
      else {
        if (down == null)
          down = new Node(emp, index + 1);
        else
          down.insert(emp, index + 1);
      }
    }

    private void insert(String emp, int index) {
      if (index == emp.length() - 1) {
        isLeafNode = true;
        return;
      }
      if (emp.charAt(index) == value)
      {
        if (down == null)
          down = new Node(emp, index+1);
        else
          down.insert(emp, index+1);
      }
      else if (emp.charAt(index) < value)
      {
        if (left == null)
          left = new Node(emp, index);
        else
          left.insert(emp, index);
      }
      else
      {
        if (right == null)
          right = new Node(emp, index);
        else
          right.insert(emp, index);
      }
    }

    void printPrefixes(String prefix, int index) {
      if (index == prefix.length()) {
        
      }
    }
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
