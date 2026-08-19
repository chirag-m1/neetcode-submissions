class Solution {
    boolean canEatAll(int[] piles, int h, int rate) {
        int hours = 0;
        for(int i = 0; i < piles.length; i++) {
            hours += (piles[i] + rate - 1) / rate;
            if(hours > h) return false;
        }
        return hours <= h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int maxi = -1;
        for(int i = 0; i < n; i++) {
            maxi = Math.max(maxi, piles[i]);
        }   
        int low = 1;
        int high = maxi;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(canEatAll(piles, h, mid)) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return low;
    }
}
