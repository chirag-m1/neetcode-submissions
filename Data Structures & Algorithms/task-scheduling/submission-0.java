class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> 
            Integer.compare(b, a));

        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < tasks.length; i++) {
            map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
        }

        for(int val : map.values()) {
            pq.offer(val);
        }

        Queue<int[]> q = new LinkedList<>();
        int time = 0;
        while(!pq.isEmpty() || !q.isEmpty()) {
            time++;
            if(pq.isEmpty()) {
                time = q.peek()[1];
            }
            else {
                int cnt = pq.poll() - 1;
                if(cnt > 0) {
                    q.offer(new int[]{cnt, time + n});
                }
            }

            if(!q.isEmpty() && q.peek()[1] == time) {
                pq.add(q.poll()[0]);
            }
        }
        return time;
    }
}
