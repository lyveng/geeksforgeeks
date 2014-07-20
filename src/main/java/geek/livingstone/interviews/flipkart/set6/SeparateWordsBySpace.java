package geek.livingstone.interviews.flipkart.set6;

import java.util.HashSet;
import java.util.Set;

public class SeparateWordsBySpace {
  public static void printSpaceSeparated(String value, Set<String> dict) {
    printUtil(value, 0, dict, new StringBuilder(), new StringBuilder());
  }

  private static boolean printUtil(String value, int index, Set<String> dict, StringBuilder line, StringBuilder lastWord) {
    if (index == value.length()) {
      if (dict.contains(lastWord.toString())) {
        line.append(" ");
        line.append(lastWord.toString());
        System.out.println(line.toString());
        return true;
      }
      return false;
    }
    lastWord.append(value.charAt(index));
    if (dict.contains(lastWord.toString())) {
      if (line.length() > 0)
        line.append(" ");
      line.append(lastWord.toString());
      if (printUtil(value, index+1, dict, line, new StringBuilder()))
        return true;
      if (line.length() > lastWord.length())
        line.delete(line.length() - lastWord.length() - 1, line.length());
      else
        line.delete(line.length() - lastWord.length(), line.length());
    }
    if (printUtil(value, index+1, dict, line, lastWord))
      return true;
    lastWord.deleteCharAt(lastWord.length()-1);
    return false;
  }

  public static void main(String[] args) {
    Set<String> dict = new HashSet<>();
    dict.add("shop");
    dict.add("shopping");
    dict.add("with");
    dict.add("is");
    dict.add("flip");
    dict.add("flipkart");
    dict.add("easy");
//    dict.add("kart");
    printSpaceSeparated("shoppingwithflipkartiseasy", dict);
  }

}
