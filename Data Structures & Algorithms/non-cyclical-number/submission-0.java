class Solution {
    boolean helper(int n, Set<Integer> set) {
        if(n == 1) {
            return true;
        }
        if(set.contains(n)) {
            return false;
        }
        set.add(n);
        int temp = 0;
        while(n != 0) {
            int digit = n % 10;
            n = n / 10;
            temp = digit * digit + temp;
        } 
        return helper(temp, set);
    }
    public boolean isHappy(int n) {
        return helper(n, new HashSet<>());
    }
}
