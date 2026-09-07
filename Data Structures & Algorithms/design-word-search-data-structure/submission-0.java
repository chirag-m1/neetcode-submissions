class Node {
    Node[] links = new Node[26];
    boolean isEnd = false;

    Node() {}

    boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    Node get(char ch) {
        return links[ch - 'a'];
    }

    void put(char ch, Node node) {
        links[ch - 'a'] = node;
    }

    boolean isEnd() {
        return isEnd;
    }

    void setEnd() {
        isEnd = true;
    }
}
class WordDictionary {
    private Node root;
    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node node = root;
        for(char ch : word.toCharArray()) {
            if(!node.containsKey(ch)) {
                node.put(ch, new Node());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }

    public boolean search(String word) {
        Node node = root;
        return searchDFS(0, word, node, word.length());
    }

    boolean searchDFS(int i, String word, Node node, int n) {
        if(i == n) {
            return node.isEnd;
        }
        if(word.charAt(i) != '.') {
            if(!node.containsKey(word.charAt(i))) {
                return false;
            }
            return searchDFS(i+1, word, node.get(word.charAt(i)), n);
        }
        for(int j = 0; j < 26; j++) {
            char ch = (char)('a' + j);
            if(node.containsKey(ch)) {
                if(searchDFS(i+1, word, node.get(ch), n)) {
                    return true;
                }
            }
        }
        return false;
    }
}
