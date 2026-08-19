class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        ArrayList<int[]> list = new ArrayList<>();
        int i = 0;
        while(i < n && intervals[i][1] < newInterval[0]) {
            list.add(new int[] {intervals[i][0], intervals[i][1]});
            i++;
        }

        while(i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        list.add(new int[] {newInterval[0], newInterval[1]});

        while(i < n) {
            list.add(new int[] {intervals[i][0], intervals[i][1]});
            i++;
        }
        int[][] arr = list.toArray(new int[0][]);
        return arr;
    }
}
