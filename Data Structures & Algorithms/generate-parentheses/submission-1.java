class Solution {
    void f(int open, int close, int n, List<String> result, StringBuilder sb) {
        if(close > open || open > n || close > n) return;

        if(sb.length() == 2 * n && open == close) {
            result.add(sb.toString());
            return;
        }

        f(open + 1, close, n, result, sb.append('('));
        sb.deleteCharAt(sb.length() - 1);
        f(open, close + 1, n, result, sb.append(')'));
        sb.deleteCharAt(sb.length() - 1);
    }
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        f(0, 0, n, result, sb);
        return result;
    }
}
