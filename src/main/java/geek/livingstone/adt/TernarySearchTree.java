package geek.livingstone.adt;

import java.util.ArrayList;
import java.util.List;

/**
 * Full problem at http://www.geeksforgeeks.org/ternary-search-tree/
 * 
 * @author emmanuel
 * 
 */
public class TernarySearchTree {
  Node root;

  public void insert(String value) {
    if (root == null)
      root = new Node(value, 0);
    else
      root.insert(value, 0);
  }

  public boolean search(String value) {
    if (root == null)
      return value == null || value.isEmpty();
    return root.find(value, 0);
  }

  public void traverse() {
    if (root != null)
      root.traverse(new StringBuilder());
  }

  public List<String> findStringsWithPrefix(String prefix) {
    if (root == null)
      return new ArrayList<>();
    List<String> strings = new ArrayList<>();
    root.findStringsWithPrefix(prefix, 0, strings);
    return strings;
  }

  class Node {
    char val;
    Node left;
    Node right;
    Node down;
    boolean isLeaf;

    Node(String value, int index) {
      assert index < value.length();
      val = value.charAt(index);
      if (index == value.length() - 1)
        isLeaf = true;
      else
        down = new Node(value, index + 1);
    }

    private void findStrings(List<String> strings, StringBuilder sb) {
      if (isLeaf) {
        sb.append(this.val);
        strings.add(sb.toString());
        sb.deleteCharAt(sb.length()-1);
      }
      if (down != null) {
        sb.append(this.val);
        down.findStrings(strings, sb);
        sb.deleteCharAt(sb.length()-1);
      }
      if (left != null)
        left.findStrings(strings, sb);
      if (right != null)
        right.findStrings(strings, sb);
    }

    private void findStringsWithPrefix(String prefix, int index, List<String> strings) {
      assert index < prefix.length();
      if (index == prefix.length()) {
        findStrings(strings, new StringBuilder(prefix));
        return;
      }
      if (prefix.charAt(index) == val && down != null)
        down.findStringsWithPrefix(prefix, index + 1, strings);
      else if (prefix.charAt(index) < val && left != null)
        left.findStringsWithPrefix(prefix, index, strings);
      else if (prefix.charAt(index) > val && right != null)
        right.findStringsWithPrefix(prefix, index, strings);
    }

    void insert(String value, int index) {
      assert index < value.length();
      if (index == value.length() - 1) {
        isLeaf = true;
        return;
      }
      if (value.charAt(index) < val) {
        if (left == null)
          left = new Node(value, index);
        else
          left.insert(value, index);
      } else if (value.charAt(index) == val)
        if (down == null)
          down = new Node(value, index+1);
        else
          down.insert(value, index + 1);
      else {
        if (right == null)
          right = new Node(value, index);
        else
          right.insert(value, index);
      }
    }

    boolean find(String value, int index) {
      assert index < value.length();
      if (index == value.length() - 1)
        return value.charAt(index) == val && isLeaf;
      if (value.charAt(index) == val)
        if (down == null)
          return false;
        else
          return down.find(value, index + 1);
      else if (value.charAt(index) < val)
        if (left == null)
          return false;
        else
          return left.find(value, index);
      else if (right == null)
        return false;
      else
        return right.find(value, index);
    }

    void traverse(StringBuilder sb) {
      sb.append(val);
      if (isLeaf)
        System.out.println(sb.toString());
      if (down != null)
        down.traverse(sb);
      sb.deleteCharAt(sb.length()-1);
      if (left != null)
        left.traverse(sb);
      if (right != null)
        right.traverse(sb);
    }
  }

  public static void main(String[] args) {
    TernarySearchTree tst = new TernarySearchTree();
    tst.insert("cat");
    tst.insert("cats");
    tst.insert("up");
    tst.insert("bug");
    
    System.out.println("Following is the traversal of ternary search tree");
    tst.traverse();

    System.out.println("\nFollowing are search results for catd, bu, cat and sads respectively");
    System.out.println(tst.search("catd"));
    System.out.println(tst.search("bu"));
    System.out.println(tst.search("cat"));
    System.out.println(tst.search("sads"));

    List<String> strings = tst.findStringsWithPrefix("ca");
    System.out.println("\nStrings with prefix ca are " + strings);
  }

}
