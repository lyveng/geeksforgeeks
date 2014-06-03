package geek.livingstone.adt;

public class Trie {
  public int ALPHABET_SIZE = 26;
  private boolean isLeaf;
  private Trie[] children = new Trie[ALPHABET_SIZE];

  private static int getIndexFromCharacter(char c) throws Exception {
    int index = ((int) c) - ((int) 'a');
    if (index >= 26 || index < 0) throw new Exception("Allowed characters are lower case a to z");
    return ((int) c) - ((int) 'a');
  }

  private void insertUtil(String key, int index) throws Exception {
    if (index == key.length()) {
      isLeaf = true;
      return;
    }
    int childIndex = getIndexFromCharacter(key.charAt(index));
    if (children[childIndex] == null) children[childIndex] = new Trie();
    children[childIndex].insertUtil(key, index + 1);
  }

  private boolean searchUtil(String key, int index) throws Exception {
    if (index == key.length()) return isLeaf;
    int childIndex = getIndexFromCharacter(key.charAt(index));
    if (children[childIndex] == null) return false;
    return children[childIndex].searchUtil(key, index + 1);
  }

  public void insert(String key) throws Exception {
    insertUtil(key, 0);
  }

  public boolean search(String key) {
    try {
      return searchUtil(key, 0);
    } catch (Exception e) {
      return false;
    }
  }

  public static void main(String[] args) throws Exception {
    String[] keys = {"the", "a", "there", "answer", "any", "by", "bye"};
    Trie root = new Trie();
    for (String key : keys) {
      root.insert(key);
    }
    System.out.println("the : " + root.search("the"));
    System.out.println("these : " + root.search("these"));
    System.out.println("their : " + root.search("their"));
    System.out.println("thaw : " + root.search("thaw"));
  }

}
