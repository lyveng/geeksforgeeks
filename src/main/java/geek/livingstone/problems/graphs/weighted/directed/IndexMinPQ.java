package geek.livingstone.problems.graphs.weighted.directed;

public class IndexMinPQ {
  int[] pq;
  int curSize;

  public IndexMinPQ(int maxN) {
    curSize = 0;
    pq = new int[maxN + 1];
  }

  public void insert(int value) {
    pq[++curSize] = value;
    swim(curSize);
  }

  public int deleteMin() {
    int min = pq[1];
    exch(1, curSize--);
    sink(1);
    return min;
  }

  public void swim(int pos) {
    while (pos > 1 && pq[pos] < pq[pos / 2]) {
      exch(pos, pos / 2);
      pos = pos / 2;
    }
  }

  public void sink(int pos) {
    while (2 * pos <= curSize) {
      int child = 2 * pos;
      if (pq[child + 1] > pq[child])
        child++;
      if (pq[pos] < pq[child])
        break;
      exch(pos, child);
      pos = child;
    }
  }

  public void exch(int i, int j) {
    int tmp = pq[i];
    pq[i] = pq[j];
    pq[j] = tmp;
  }

  public static void main(String[] args) {

  }

}
