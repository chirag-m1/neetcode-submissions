class Solution {
    public int reverseBits(int n) {
        int res = 0;
        for(int i = 31; i >= 0; i--) {
            int bit = n & (1 << i);
            if(bit != 0) {
                res = res | (1 << (31 - i));
            }
        }
        return res;
    }
}
