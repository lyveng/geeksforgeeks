package geek.livingstone.problems.backtracking;

import java.util.Stack;

/**
 * Full problem at http://www.geeksforgeeks.org/backtracking-set-7-hamiltonian-cycle/
 * 
 * @author emmanuel
 * 
 */
public class HamiltonianPath {
  public static void printHamiltonianPath(boolean[][] graph, int N) {
    int[] path = new int[N];
    for (int i = 0; i < N; i++)
      path[i] = -1;
    path[0] = 0;
    int lastNode = printUtil(graph, N, path, 1, 0);
    if (lastNode != -1)
      printPath(path, N, lastNode);
    else
      System.out.println("No hamiltonian cycle exists for this graph");
  }

  private static void printPath(int[] path, int n, int lastNode) {
    Stack<Integer> pathStack = new Stack<>();
    pathStack.push(0);
    int curNode = lastNode;
    while (curNode != path[curNode]) {
      pathStack.push(curNode);
      curNode = path[curNode];
    }
    pathStack.push(curNode);
    System.out.println(pathStack);
  }

  private static int printUtil(boolean[][] graph, int N, int[] path, int visitCount, int cur) {
    if (visitCount == N) if (graph[cur][0])
      return cur;
    else
      return -1;
    for (int i = 0; i < N; i++) {
      if (cur != i && graph[cur][i] && path[i] == -1) {
        path[i] = cur;
        int lastNode = printUtil(graph, N, path, visitCount + 1, i);
        if (lastNode != -1) return lastNode;
        path[i] = -1;
      }
    }
    return -1;
  }

  private static boolean[][] getGraph(int[][] g) {
    boolean[][] ret = new boolean[g.length][];
    for (int i = 0; i < g.length; i++) {
      ret[i] = new boolean[g[i].length];
      for (int j = 0; j < g[i].length; j++)
        ret[i][j] = g[i][j] == 0 ? false : true;
    }
    return ret;
  }

  public static void main(String[] args) {
    boolean[][] graph =
        getGraph(new int[][] { {0, 1, 0, 1, 0}, {1, 0, 1, 1, 1}, {0, 1, 0, 0, 1}, {1, 1, 0, 0, 1}, {0, 1, 1, 1, 0},});
    printHamiltonianPath(graph, 5);

    graph =
        getGraph(new int[][] { {0, 1, 0, 1, 0}, {1, 0, 1, 1, 1}, {0, 1, 0, 0, 1}, {1, 1, 0, 0, 0}, {0, 1, 1, 0, 0},});
    printHamiltonianPath(graph, 5);
  }

}
