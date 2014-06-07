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

  /**
   * Checks if there are any children for this trie.
   * 
   * @return
   */
  private boolean containsChildren() {
    for (int i=0; i<ALPHABET_SIZE; i++)
      if (children[i] != null)
        return true;
    return false;
  }

  private boolean deleteUtil(String key, int index) throws Exception {
    if (index == key.length())
    {
      if (this.isLeaf) {
        this.isLeaf = false;
        // Case 2: The key is not a prefix of any other key. In that case. Returns true if no children.
        // Case 3: Key is prefix of another longer key in trie. Returns false if atleast one child.
        return !containsChildren();
      }
      // Case 1: Key is not present in trie
      return false;
    }
    int childIndex = getIndexFromCharacter(key.charAt(index));
    // Case 1: Key is not present in trie
    if (children[childIndex] == null)
      return false;
    if (children[childIndex].deleteUtil(key, index+1))
    {
      children[childIndex] = null;
      // Case 2: The key is unique key. return true to delete the key.
      // Case 4: Key present in trie having atleast one another key as prefix or another key is part of this path. then return false
      return !(containsChildren() || isLeaf);
    }
    return false;
  }

  public void delete(String key) throws Exception {
    System.out.println();
    System.out.println("Deleting key[" + key + "] from trie.");
    deleteUtil(key, 0);
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

    root.delete(keys[0]);
    System.out.println("the : " + root.search(keys[0]));
    System.out.println("there : " + root.search(keys[2]));

    root.delete(keys[2]);
    System.out.println("the : " + root.search(keys[0]));
    System.out.println("there : " + root.search(keys[2]));
    System.out.println("answer : " + root.search(keys[3]));
  }

}
