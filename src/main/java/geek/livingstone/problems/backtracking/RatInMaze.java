package geek.livingstone.problems.backtracking;

/**
 * Full problem at http://www.geeksforgeeks.org/backttracking-set-2-rat-in-a-maze/
 * 
 * @author emmanuel
 * 
 */
public class RatInMaze {
  public static void findPath(int[][] maze, int N, int source_i, int source_j, int dest_i, int dest_j) {
    int[][] path = new int[N][N];
    path[0][0] = 1;
    if (findPathUtil(maze, path, N, 0, 0, dest_i, dest_j))
      printPath(path, N);
    else
      System.out.println("No path found");
  }

  public static boolean findPathUtil(int[][] maze, int[][] path, int N, int cur_i, int cur_j, int dest_i, int dest_j) {
    if (cur_i == dest_i && cur_j == dest_j)
      return true;
    int next_i, next_j;

    // Move Down
    next_i = cur_i + 1;
    next_j = cur_j;
    if (next_i < N && next_j < N && maze[next_i][next_j] == 1) {
      path[next_i][next_j] = 1;
      if (findPathUtil(maze, path, N, next_i, next_j, dest_i, dest_j))
        return true;
      path[next_i][next_j] = 0;
    }

    // Move Right
    next_i = cur_i;
    next_j = cur_j + 1;
    if (next_i < N && next_j < N && maze[next_i][next_j] == 1) {
      path[next_i][next_j] = 1;
      if (findPathUtil(maze, path, N, next_i, next_j, dest_i, dest_j))
        return true;
      path[next_i][next_j] = 0;
    }
    return false;
  }

  private static void printPath(int[][] path, int N) {
    for (int i=0;i<N;i++) {
      for (int j=0;j<N;j++)
        System.out.print(String.format("%1d ", path[i][j]));
      System.out.println();
    }
  }

  public static void main(String[] args) {
    int[][] maze = {
        {1, 0, 0, 0},
        {1, 1, 0, 1},
        {0, 1, 0, 0},
        {1, 1, 1, 1}};
    findPath(maze, 4, 0, 0, 3, 3);
  }

}
