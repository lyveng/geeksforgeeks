package geek.livingstone.problems.graphs.directed;

import java.util.Deque;
import java.util.LinkedList;

public class DepthFirstOrder {
  private Deque<Integer> pre;
  private Deque<Integer> post;
  private Deque<Integer> reversePost;
  private boolean[] marked;

  public DepthFirstOrder(Digraph G) {
    pre = new LinkedList<>();
    post = new LinkedList<>();
    reversePost = new LinkedList<>();
    marked = new boolean[G.V()];

    
  }

  private void dfs(Digraph G, int u) {
    pre.add(u);
    marked[u] = true;
    for (int v : G.adj(u))
      if (!marked[v])
        dfs(G, v);
    post.add(u);
    post.addFirst(u);
  }
}
