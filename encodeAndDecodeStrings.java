public class Codec {

  // Encodes a list of strings to a single string.
  public String encode(List<String> strs) {
    StringBuilder sb = new StringBuilder();
    for (String str : strs) {
      sb.append(str.length()).append('/');
      sb.append(str);
    }
    return sb.toString();
  }

  // Decodes a single string to a list of strings.
  public List<String> decode(String s) {
    List<String> list = new ArrayList<>();
    int i = 0; // start tracker
    while (i < s.length()) {
      int end = s.indexOf('/', i); // the first / since i
      int len = Integer.parseInt(s.substring(i, end));
      list.add(s.substring(end + 1, end + len + 1));
      i = end + len + 1;
    }
    return list;
  }
}
