class Solution {
    boolean allZeroes(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != 0) return false;
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        int[] arr = new int[26];
        for(int i = 0; i < s1.length(); i++) {
            arr[s1.charAt(i) - 'a']++; 
            arr[s2.charAt(i) - 'a']--;
        }
        if(allZeroes(arr)) return true;
        int l = 0;
        int r = s1.length();
        while(r < s2.length()) {
            arr[s2.charAt(l) - 'a']++;
            arr[s2.charAt(r) - 'a']--;
            if(allZeroes(arr)) return true;           
            l++;
            r++;
        }
        return false;
    }
}
