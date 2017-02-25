public class MovingAverage {

   private Queue<Integer> queue;
   private int size;
   private int sum;

   public MovingAverage(int size) {
     this.size = size;
     sum = 0;
     queue = new LinkedList<>();
   }

   public double next(int val) {
      if (queue.size() == this.size) {
        sum -= queue.poll();
      }
      queue.offer(val);
      sum += val;
      return (double) sum / queue.size();
   }
}
