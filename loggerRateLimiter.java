public class Logger {

  Hashtable<String, Integer> table;
  public Logger() {
    table = new Hashtable<>();
  }

  public boolean shouldPrintMessage(int timestamp, String message) {
    if (table.containsKey(message) && table.get(message) + 10 > timestamp) {
      return false;
    }
    table.put(message, timestamp);
    return true;
  }
}
