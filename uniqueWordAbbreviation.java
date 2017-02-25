public class ValidWordAbbr {

  private HashMap<String, String> map;
  public ValidWordAbbr(String[] dictionary) {
    map = new HashMap<>();
    for (String w : dictionary) {
      String abbr = getAbbr(w);
      if (map.isEmpty() || !map.containsKey(abbr)) {
        map.put(abbr, w);
      } else { // same abbr
        // only same word is valid
        if (!map.get(abbr).equals(w)) {
          map.put(abbr, ""); // mark duplicate invaild
        }
      }
    }
  }

  public boolean isUnique(String word) {
    String abbr = getAbbr(word);
    return !map.containsKey(abbr) || map.get(abbr).equals(word);
  }

  private String getAbbr(String w) {
    if (w.length() <= 2) {
      return w;
    }
    return w.charAt(0) + String.valueOf(w.length() - 2) + w.charAt(w.length() - 1);
  }
}
