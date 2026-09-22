class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if(a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        ArrayList<int[]> list = new ArrayList<>();
        int end = -1;
        for(int[] i : intervals) {
            int start = i[0];
            if(start > end) {
                end = i[1];
                list.add(new int[] {start, end});
            }
            else {
                int[] temp = list.get(list.size() - 1);
                if(i[1] > temp[1]) {
                    temp[1] = i[1];
                    end = i[1];
                }
            }
        }
        int[][] ans = new int[list.size()][2];
        for(int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
