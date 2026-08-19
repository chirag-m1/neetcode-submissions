class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;    
        int n = s.length();
        int[] freq = new int[26];
        for(int i = 0; i < n; i++) {
            int index1 = (int)(s.charAt(i) - 'a');
            int index2 = (int)(t.charAt(i) - 'a');
            freq[index1]++;
            freq[index2]--;
        }
        for(int i = 0; i < 26; i++) {
            if(freq[i] != 0) return false;
        }
        return true;
    }
}
