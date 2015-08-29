class TrieNode {
    // Initialize your data structure here.
    Map<Character, TrieNode> children;
    boolean isLeaf;
    public TrieNode() {
        children = new HashMap<Character, TrieNode>();
        isLeaf = false;
    }
    
    public void insert(String s) {
        if (s.length() == 0) {
            this.isLeaf = true;
            return;
        }
        char c = s.charAt(0);
        if (!this.children.containsKey(c)) {
            TrieNode next = new TrieNode();
            this.children.put(c, next);
        }
        this.children.get(c).insert(s.substring(1));
    }
    
    public boolean search(String s) {
        if (s.length() == 0) {
            return this.isLeaf;
        }
        char c = s.charAt(0);
        if (children.containsKey(c)) {
            return this.children.get(c).search(s.substring(1));
        }
        return false;
    }
    
    public boolean startWith(String s) {
        if (s.length() == 0) {
            return true;
        }
        char c = s.charAt(0);
        if (children.containsKey(c)){
            return this.children.get(c).startWith(s.substring(1));
        }
        return false;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        this.root.insert(word);
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        return this.root.search(word);
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        return this.root.startWith(prefix);
        
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
