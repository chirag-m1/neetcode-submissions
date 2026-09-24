class Node {
    private Node links[] = new Node[26];
    private boolean isEnd = false;
    private int index = -1;

    public Node() {}

    boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    Node get(char ch) {
        return links[ch - 'a'];
    }

    void put(char ch, Node node) {
        links[ch - 'a'] = node;
    }

    void setEnd(int index) {
        isEnd = true;
        this.index = index;
    }

    boolean isEnd() {
        return isEnd;
    }

    int getIndex() {
        return index;
    }

    void removeEnd() {
        isEnd = false;
    }
}

class Trie {
    private Node root;
    public Trie() {
        root = new Node();
    }

    void insert(String word, int index) {
        Node node = root;
        for(char ch : word.toCharArray()) {
            if(!node.containsKey(ch)) {
                node.put(ch, new Node());
            }
            node = node.get(ch);
        }
        node.setEnd(index);
    }

    boolean contains(String word) {
        Node node = root;
        for(char ch : word.toCharArray()) {
            if(!node.containsKey(ch)) {
                return false;
            }
            node = node.get(ch);
        }
        return node.isEnd();
    }

    Node getTrieNode() {
        return root;
    }
}

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for(int i = 0; i < words.length; i++) {
            trie.insert(words[i], i);
        }   

        ArrayList<String> res = new ArrayList<>();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                dfs(board, words, trie.getTrieNode(), i, j, res);
            }
        }
        return res;
    }

    void dfs(char[][] board, String[] words, Node tNode, int i, int j, ArrayList<String> res) {
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '*' || !tNode.containsKey(board[i][j]) ) return;
        char ch = board[i][j];
        Node next = tNode.get(ch);

        if(next != null && next.isEnd()) {
            int index = next.getIndex();
            res.add(words[index]);
            next.removeEnd();
        }

        board[i][j] = '*';

        dfs(board, words, tNode.get(ch), i+1, j, res);

        dfs(board, words, tNode.get(ch), i-1, j, res);

        dfs(board, words, tNode.get(ch), i, j+1, res);

        dfs(board, words, tNode.get(ch), i, j-1, res);

        board[i][j] = ch;
    }
}
