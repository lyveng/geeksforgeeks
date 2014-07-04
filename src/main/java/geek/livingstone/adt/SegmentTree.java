package geek.livingstone.adt;

/**
 * Full problem at http://www.geeksforgeeks.org/segment-tree-set-1-sum-of-given-range/
 * 
 * @author emmanuel
 * 
 */
public class SegmentTree {
  int[] tree;
  int size;

  public SegmentTree(int[] arr) {
    size = arr.length;
    int treeSize = (int) Math.pow(2, Math.ceil(Math.log(size) / Math.log(2)) + 1);
    tree = new int[treeSize];
    insert(arr, 0, size - 1, 0);
  }

  private int insert(int[] arr, int start, int end, int index) {
    if (start > end)
      return 0;
    else if (start == end) {
      tree[index] = arr[start];
      return arr[start];
    }
    int mid = (start + end) / 2;
    return insert(arr, start, mid, 2 * index + 1) + insert(arr, mid + 1, end, 2 * index + 2);
  }

  public int sum(int start, int end) {
    assert start <= end;
    return sumUtil(start, end, 0, size - 1, 0);
  }

  private int sumUtil(int qstart, int qend, int stStart, int stEnd, int index) {
    if (qstart <= stStart && qend >= stEnd)
      return tree[index];
    else if (qstart > stEnd || qend < stStart)
      return 0;
    int mid = (stStart + stEnd) / 2;
    return sumUtil(qstart, qend, stStart, mid, 2 * index + 1) + sumUtil(qstart, qend, mid + 1, stEnd, 2 * index + 2);

  }

  public void updateValue(int index, int value) {
    assert index < size;
    updateValueUtil(index, 0, size - 1, value, 0);
  }

  private int updateValueUtil(int index, int stStart, int stEnd, int value, int stIndex) {
    if (stStart > stEnd)
      return 0;
    if (stStart == stEnd && stStart == index) {
      int diff = value - tree[stIndex];
      tree[stIndex] = value;
      return diff;
    }
    int mid = (stStart + stEnd) / 2;
    int diff;
    if (index <= mid)
      diff = updateValueUtil(index, stStart, mid, value, 2 * stIndex + 1);
    else
      diff = updateValueUtil(index, mid + 1, stEnd, value, 2 * stIndex + 2);
    tree[index] += diff;
    return diff;
  }

  public static void main(String[] args) {
    SegmentTree st = new SegmentTree(new int[] {1, 3, 5, 7, 9, 11});
    System.out.println(st.sum(1, 3));
    st.updateValue(1, 10);
    System.out.println(st.sum(1, 3));
  }

}
