class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        int n = s.length();
        int i = 0;
        while(i < n) {
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                st.push(s.charAt(i));
                i++;
                continue;
            }
            else {
                if(st.isEmpty() || ((s.charAt(i) == ')' && st.peek() != '(')
                || (s.charAt(i) == '}' && st.peek() != '{')
                || (s.charAt(i) == ']' && st.peek() != '['))) {
                    return false;
                }
            }
            i++;
            if(!st.isEmpty()) st.pop();
        }
        return st.isEmpty();
    }
}
