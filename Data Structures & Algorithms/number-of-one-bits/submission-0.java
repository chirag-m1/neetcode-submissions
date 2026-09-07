class Solution {
    public int hammingWeight(int n) {
        int numBits = 0;
        for(int i = 31; i >= 0; i--) {
            int bit = (n >> i) & 1;
            if(bit == 1) numBits++;
        }
        return numBits;
    }
}
