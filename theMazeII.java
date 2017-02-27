class Pos {
  int x;
  int y;
  int steps;

  Pos(int x, int y, int steps) {
    this.x = x;
    this.y = y;
    this.steps = steps;
  }
}
private int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
private int[][] maze;

public int shortestDistance(int[][] maze, int[] start, int[] destination) {
  this.maze = maze;
  int row = maze.length;
  int col = maze[0].length;
  int[][] min = new int[row][col];
  Arrays.fill(min, Integer.MAX_VALUE);

  // fast fall
  boolean up = canRoll(destination[0], destination[1], dirs[1]);
  boolean down = canRoll(destination[0], destination[1], dirs[0]);
  boolean left = canRoll(destination[0], destination[1], dirs[3]);
  boolean right = canRoll(destination[0], destination[1], dirs[2]);
  if (!up && !down && !left && !right) return -1;
  if (up && down && !left && !right) return -1;
  if (!up && !down && left && right) return -1;
  if (up && down && left && right) return -1;

  min[start[0]][start[1]] = 0;
  PriorityQueue<Pos> q = new PriorityQueue<Pos>(new Comparator<Pos>(
    public int compare(Pos a, Pos b) {
      return a.steps - b.steps;
    }      
  ));
  q.offer(Pos(start[0], start[1], 0));
  while (!q.isEmpty()) {
    Pos cur = q.poll();
    for (int[] d : dir) {
      int x = cur.x + d[0];
      int y = cur.y + d[1];
      int steps = cur.steps;
      // one dir all the way down
      while (canRoll(x, y, d)) {// pre-check next Pos
        x += d[0];
        y += d[1];
        steps++; 
      }
      if (steps < min[x][y] && steps < min[destination[0]][destination[1]]) {
        min[x][y] = steps;
        q.offer(new Pos(x, y, steps));
      }
    }
  }
  if (min[destination[0]][destination[1]] == Integer.MAX_VALUE) return -1;
  return min[destination[0]][destination[1]];
}
private boolean canRoll(int x, int y, int[] d) {
  int nx = x + d[0];
  int ny = y + d[1];
  if (nx < 0 || ny < 0 || nx >= maze.length || ny >= maze[0].length || maze[nx][ny] == 1) return false;
  return true;
}
