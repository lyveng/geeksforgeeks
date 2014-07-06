package geek.livingstone.problems.graphs.directed;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstDirectedPaths extends Paths {

  public BreadthFirstDirectedPaths(Digraph G, int s) {
    super(G, s);
    bfs(G, s);
  }

  private void bfs(Digraph G, int s) {
    Queue<Integer> q = new LinkedList<>();
    q.add(s);
    while (!q.isEmpty()) {
      int u = q.remove();
      marked[u] = true;
      for (int v : G.adj(u))
        if (!marked[v]) {
          q.add(v);
          edgeTo[v] = u;
          marked[v] = true;
        }
    }
  }

}
