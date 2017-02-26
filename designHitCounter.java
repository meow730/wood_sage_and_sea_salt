public class HitCounter {
  
  private PriorityQueue<Integer> queue;
  public HitCounter() {
    queue = new PriorityQueue<>();
  }

  public void hit(int timestamp) {
    queue.offer(timestamp);
  }

  public int getHits(int timestamp) {
    while (!queue.isEmpty() && queue.peek() + 300 <= timestamp) {
      queue.poll();
    } 
    return queue.size();
  }

}
// or use 2 array, faster?
public class HitCounter {
  
  private int[] time;
  private int[] hit;

  public HitCounter() {
    time = new int[300];
    hit =  new int[300];
  }

  public void hit(int timestamp) {
    int idx = timestamp % 300;
    if (time[idx] != timestamp) {
      time[idx] = timestamp;
      hit[idx] = 1; // updates !
    } else {
      hit[idx]++;
    }
  }

  public int getHits(int timestamp) {
    int sum = 0;
    for (int i = 0; i < 300; i++) {
      if (timestamp - time[i] < 300) {
        sum += hit[i];
      }
    }
    return sum;
  }

}
