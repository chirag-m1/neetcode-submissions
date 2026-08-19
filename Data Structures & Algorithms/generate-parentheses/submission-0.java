class Solution {
    void f(int open, int close, int n, List<String> result, String s) {
        if(close > open || open > n || close > n) return;

        if(s.length() == 2 * n && open == close) {
            result.add(s);
            return;
        }

        f(open + 1, close, n, result, s + "(");
        f(open, close + 1, n, result, s + ")");
    }
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        f(0, 0, n, result, "");
        return result;
    }
}
