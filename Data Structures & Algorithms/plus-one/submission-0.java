class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int[] result = new int[n];
        int carry = 0;
        for(int i = n-1; i >= 0; i--) {
            if(i == n-1) {
                result[i] = (digits[i] + 1) % 10;
                carry = (digits[i] + 1) / 10;
            }
            else {
                result[i] = (digits[i] + carry) % 10;
                carry = (digits[i] + carry) / 10;
            }
        }
        if(carry == 0) return result;
        int[] newResult = new int[n+1];
        newResult[0] = carry;
        for(int i = 0; i < n; i++) {
            newResult[i+1] = result[i];
        }
        return newResult;
    }
}
