package geek.livingstone.problems.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Full problem at http://www.geeksforgeeks.org/custom-tree-problem/
 * 
 * @author emmanuel
 * 
 */
public class CustomTreeProblem {
  static int base_a = (int) 'a';

  public static void processLinks(String[] links) {
    TreeNode[] nodes = new TreeNode[26];
    Set<Integer> heads = new TreeSet<>();
    char a, b;
    int aIndex, bIndex;
    for (String link : links) {
      a = link.split(" ")[0].charAt(0);
      b = link.split(" ")[1].charAt(0);
      aIndex = a - base_a;
      bIndex = b - base_a;
      if (nodes[aIndex] == null) {
        nodes[aIndex] = new TreeNode(a);
        heads.add(aIndex);
      }
      if (nodes[bIndex] == null)
        nodes[bIndex] = new TreeNode(b);
      nodes[aIndex].addChild(nodes[bIndex]);
    }
    for (int i : heads) {
      System.out.println();
      nodes[i].printTreeIdented("");
    }
  }

  public static void main(String[] args) {
    processLinks(new String[] {"a b", "b c", "b d", "a e"});
    System.out.println("\n");
    processLinks(new String[] {"a b", "a g", "b c", "c d", "d e", "c f", "z y", "y x", "x w"});
  }

  static class TreeNode {
    List<TreeNode> children;
    char c;

    public void addChild(TreeNode t) {
      this.children.add(t);
    }

    // Constructor
    public TreeNode(char c) {
      this.c = c;
      this.children = new ArrayList<>();
    }

    // Recursive method to print indented tree rooted with this node.
    public void printTreeIdented(String indent) {
      System.out.println(indent + "-->" + c);
      for (TreeNode child : children) {
        child.printTreeIdented(indent + "   |");
      }
    }
  }
}
