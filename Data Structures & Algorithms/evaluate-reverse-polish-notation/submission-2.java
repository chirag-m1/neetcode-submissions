class Solution {
    boolean canParseInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        }
        catch(Exception e) {
            return false;
        }
    }
    public int evalRPN(String[] tokens) {
        Deque<Integer> st = new ArrayDeque<>();
        for(int i = 0; i < tokens.length; i++) {
            if(canParseInt(tokens[i])) {
                st.push(Integer.parseInt(tokens[i]));
            }
            else {
                int t1 = st.pop();
                int t2 = st.pop();
                int res = switch(tokens[i]) {
                    case "+" -> t1 + t2;
                    case "*" -> t1 * t2;
                    case "-" -> t2 - t1;
                    case "/" -> t2 / t1;
                    default -> t1 + t2;
                };
                st.push(res);
            }
        }
        return st.peek();  
    }
}
