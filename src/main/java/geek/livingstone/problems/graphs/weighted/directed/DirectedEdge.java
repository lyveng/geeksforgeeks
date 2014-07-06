package geek.livingstone.problems.graphs.weighted.directed;

public class DirectedEdge implements Comparable<DirectedEdge> {
  private int u, v, weight;

  DirectedEdge(int u, int v, int weight) {
    super();
    this.u = u;
    this.v = v;
    this.weight = weight;
  }

  public int from() {
    return u;
  }

  public int to() {
    return v;
  }

  public int weight() {
    return weight;
  }

  @Override
  public int compareTo(DirectedEdge o) {
    return this.weight - o.weight;
  }
}
