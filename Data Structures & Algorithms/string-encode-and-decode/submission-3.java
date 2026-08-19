class Solution {

    public String encode(List<String> strs) {
        StringBuilder result = new StringBuilder();
        for(String s : strs) {
            result.append(s.length()+"#");
            result.append(s);
        }
        return result.toString();
    }

    public List<String> decode(String str) {
        // System.out.println(str);
        int i = 0;
        List<String> result = new ArrayList<>();
        while(i < str.length()) {
            int j = i;
            while(str.charAt(j) != '#') {
                j++;
            }
            int len = Integer.parseInt(str.substring(i, j));
            result.add(str.substring(j+1, j+1+len));
            i = j + 1 + len;
        }
        return result;
    }
}
