package geek.livingstone.problems.binarytree;

import java.util.Arrays;

public class InterpretationsOfArrayOfDigits {
//For simplicity I am taking it as string array. Char Array will save space
  private static final String[] alphabet = {"", "a", "b", "c", "d", "e",
      "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
      "s", "t", "u", "v", "w", "x", "v", "z"};

  public static Node createTree(int data, String curString, int[] arr) {
    if (data > 26)
      return null;
    Node node = new Node(curString + alphabet[data]);
    if (arr.length > 0)
    {
      node.left = createTree(arr[0], node.interpretation, Arrays.copyOfRange(arr, 1, arr.length));
      if (arr.length > 1)
      {
        node.right = createTree(arr[0]*10 + arr[1], node.interpretation, Arrays.copyOfRange(arr, 2, arr.length));
      }
    }
    if (node.isLeafNode())
      System.out.println(node.interpretation);
    return node;
  }

  public static void printAllInterpretations(int[] arr)
  {
    System.out.println(String.format("Printing interpretations for array %s", Arrays.toString(arr)));
    createTree(0, "", arr);
    System.out.println();
  }

  public static void main(String[] args) {
 // aacd(1,1,3,4) amd(1,13,4) kcd(11,3,4)
    // Note : 1,1,34 is not valid as we don't have values corresponding
    // to 34 in alphabet
    int[] arr = {1, 1, 3, 4};
    printAllInterpretations(arr);

    // aaa(1,1,1) ak(1,11) ka(11,1)
    int[] arr2 = {1, 1, 1};
    printAllInterpretations(arr2);

    // bf(2,6) z(26)
    int[] arr3 = {2, 6};
    printAllInterpretations(arr3);

    // ab(1,2), l(12)  
    int[] arr4 = {1, 2};
    printAllInterpretations(arr4);

    // a(1,0} j(10)  
    int[] arr5 = {1, 0};
    printAllInterpretations(arr5);

    // "" empty string output as array is empty
    int[] arr6 = {};
    printAllInterpretations(arr6);

    // abba abu ava lba lu
    int[] arr7 = {1, 2, 2, 1};
    printAllInterpretations(arr7);
  }

  private static class Node {
    String interpretation;
    Node left;
    Node right;
    Node(String interpretation) {
      this.interpretation = interpretation;
    }
    boolean isLeafNode() {
      return left == null && right == null;
    }
  }
}
