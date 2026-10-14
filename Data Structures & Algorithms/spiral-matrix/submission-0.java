class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
        int[] steps = new int[]{matrix[0].length, matrix.length-1};
        List<Integer> result = new ArrayList<>();
        int d = 0;
        int r = 0;
        int c = -1;
        while(steps[d % 2] > 0) {
            for(int i = 0; i < steps[d % 2]; i++) {
                r += directions[d][0];
                c += directions[d][1];
                result.add(matrix[r][c]);
            }
            steps[d % 2]--;
            d = (d+1) % 4;
        }
        return result;
    }
}
