public class Trie {
  class Node {
    char val;
    boolean isWord;
    Node parent;
    Node[] childrens = new Node[26];

    Node(char v) {
      val = v;
    }
  }

  private Node root;

  public Trie() {
    root = new Node(' ');  
  }

  public void insert(String word) {
    char[] letters = word.toCharArray();
    Node cur = root;
    for (char c : letters) {
      if (cur.childrens[c - 'a'] == null) {
        cur.childrens[c - 'a'] = new Node(c);
      }
      cur = cur.childrens[c - 'a'];
    }
    cur.isWord = true;
  }

  public boolean search(String word) {
    char[] path = word.toCharArray();
    Node cur = root;
    for (char c : path) {
      if (cur.childrens[c - 'a'] == null) return false;
      cur = cur.childrens[c - 'a'];
    }
    return cur.isWord;
  }

  public boolean startsWith(String prefix) {
    char[] path = word.toCharArray();
    Node cur = root;
    for (char c : path) {
      if (cur.childrens[c - 'a'] == null) return false;
      cur = cur.childrens[c - 'a'];
    }
    return true; 
  }
}
