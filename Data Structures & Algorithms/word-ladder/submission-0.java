class Pair {
    String word;
    int steps;
    public Pair(String word, int steps) {
        this.word = word;
        this.steps = steps;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int n = beginWord.length();

        Set<String> set = new HashSet<>();
        for(int i = 0; i < wordList.size(); i++) {
            set.add(wordList.get(i));
        }

        if(!set.contains(endWord)) {
            return 0;
        }
        
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(beginWord, 1));

        while(!q.isEmpty()) {
            Pair p = q.poll();
            String word = p.word;
            int steps = p.steps;
            if(word.equals(endWord)) {
                return steps;
            }
            for(int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder(word);
                // char c = word.charAt(i);
                for(int j = 0; j < 26; j++) {
                    sb.setCharAt(i, (char)('a' + j));
                    String nword = sb.toString();
                    if(set.contains(nword) && !nword.equals(word)) {
                        q.offer(new Pair(nword, steps + 1));
                        set.remove(nword);
                    }
                }
            }
        }
        return 0;
    }
}
