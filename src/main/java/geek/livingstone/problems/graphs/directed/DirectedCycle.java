package geek.livingstone.problems.graphs.directed;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DirectedCycle {
  private List<Integer> cycle;
  private boolean[] onStack;
  private boolean[] marked;
  private int[] edgeTo;

  public DirectedCycle(Digraph G) {
    onStack = new boolean[G.V()];
    marked = new boolean[G.V()];
    edgeTo = new int[G.V()];
    for (int s = 0; s < G.V(); s++)
      if (!marked[s])
        dfs(G, s);
  }

  private void dfs(Digraph G, int u) {
    onStack[u] = true;
    marked[u] = true;
    for (int v : G.adj(u))
      if (!marked[v]) {
        edgeTo[v] = u;
        dfs(G, v);
      } else if (onStack[v]) {
        Stack<Integer> reverseCycle = new Stack<>();
        reverseCycle.push(v);
        for (int w = u; w != v; w = edgeTo[w])
          reverseCycle.push(w);
        reverseCycle.push(v);

        cycle = new ArrayList<>();
        while (!reverseCycle.isEmpty())
          cycle.add(reverseCycle.pop());
      }
    onStack[u] = false;
  }

  public boolean hasCycle() {
    return cycle != null;
  }

  public Iterable<Integer> cycle() {
    return cycle;
  }
}
