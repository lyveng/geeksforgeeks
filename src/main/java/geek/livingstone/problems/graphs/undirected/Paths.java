package geek.livingstone.problems.graphs.undirected;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public abstract class Paths {
  protected boolean[] marked;
  protected int[] edgeTo;
  protected int source;

  public Paths(Graph G, int s) {
    marked = new boolean[G.V()];
    edgeTo = new int[G.V()];
    source = s;
    edgeTo[s] = s;
  }

  public boolean hasPathTo(int u) {
    return marked[u];
  }

  public Iterable<Integer> pathTo(int u) {
    if (hasPathTo(u))
      return null;

    Stack<Integer> reversePath = new Stack<>();
    for (int v = u; v != source; v = edgeTo[v]) {
      reversePath.add(v);
    }
    reversePath.add(source);

    List<Integer> path = new ArrayList<>();
    while (!reversePath.empty())
      path.add(reversePath.pop());

    return path;
  }
}
