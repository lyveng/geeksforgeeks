package geek.livingstone.problems.graphs.weighted.directed;

import java.util.NoSuchElementException;


public class IndexMinPQ<T extends Comparable<T>> {
  private int[] pq; // Stores the actual priority queue. Elements are indices of pq.
  private int[] qp; // Stores the position of element at index i in the priority queue.
  private T[] keys;
  private int maxN;
  private int curSize;

  public IndexMinPQ(int maxN) {
    this.maxN = maxN;
    pq = new int[maxN];
    qp = new int[maxN];
    keys = (T[]) new Comparable[maxN];
    curSize = 0;
  }

  public void insert(int index, T value) {
    if (index < 0 || index >= maxN) throw new IndexOutOfBoundsException();
    if (contains(index)) throw new IllegalArgumentException("Element already available at given index.");
    pq[curSize] = index;
    qp[index] = curSize;
    keys[index] = value;
    swim(curSize);
    curSize++;
  }

  public int deleteMin() {
    if (isEmpty()) throw new NoSuchElementException("Underflow");
    int minElementIndex = pq[0];
    curSize--;
    exch(0, curSize);
    sink(0);
    pq[curSize] = -1;
    qp[minElementIndex] = -1;
    keys[minElementIndex] = null;
    return minElementIndex;
  }

  public void changeKey(int index, T value) {
    if (!contains(index)) throw new NoSuchElementException();
    keys[index] = value;
    swim(qp[index]);
    sink(qp[index]);
  }

  private void swim(int pos) {
    int parent = getParent(pos);
    while (parent != pos && greater(parent, pos)) {
      exch(parent, pos);
      pos = parent;
      parent = getParent(pos);
    }
  }

  private void sink(int pos) {
    int child = 2 * pos + 1;
    while (child < curSize) {
      if (child + 1 < curSize && greater(child, child + 1))
        child++;
      if (!greater(pos, child))
        break;
      exch(pos, child);
      pos = child;
      child = 2 * pos + 1;
    }
  }

  private int getParent(int pos) {
    return (pos - 1) / 2;
  }

  private boolean greater(int i, int j) {
    return keys[pq[i]].compareTo(keys[pq[j]]) > 0;
  }

  private void exch(int i, int j) {
    int tmp = pq[i];
    pq[i] = pq[j];
    pq[j] = tmp;
    qp[pq[i]] = i;
    qp[pq[j]] = j;
  }

  public boolean contains(int index) {
    return keys[index] != null;
  }

  public boolean isEmpty() {
    return curSize == 0;
  }

  public static void main(String[] args) {
    String[] strings = {"it", "was", "the", "best", "of", "times", "it", "was", "the", "worst"};
    IndexMinPQ<String> pq = new IndexMinPQ<String>(strings.length);
    for (int i = 0; i < strings.length; i++) {
      pq.insert(i, strings[i]);
    }

    // delete and print each key
    while (!pq.isEmpty()) {
      int i = pq.deleteMin();
      System.out.println(i + " " + strings[i]);
    }
    System.out.println();

    // reinsert the same strings
    for (int i = 0; i < strings.length; i++) {
        pq.insert(i, strings[i]);
    }
    strings[9] = "air";
    pq.changeKey(9, strings[9]);
    // delete and print each key
    while (!pq.isEmpty()) {
      int i = pq.deleteMin();
      System.out.println(i + " " + strings[i]);
    }
    System.out.println();
  }

}
