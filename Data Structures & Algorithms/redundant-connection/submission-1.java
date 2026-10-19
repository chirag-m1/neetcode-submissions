class DisjointSet {
    int[] size;
    int[] parent;
    public DisjointSet(int n) {
        size = new int[n+1];
        parent = new int[n+1];
        for(int i = 1; i <= n; i++) {
            size[i] = 1;
            parent[i] = i;
        }
    }

    int findParent(int n) {
        if(n == parent[n]) {
            return n;
        }
        return parent[n] = findParent(parent[n]);
    }

    void unionBySize(int u, int v) {
        int pu = findParent(u);
        int pv = findParent(v);
        if(pu == pv) return;

        if(size[pu] < size[pv]) {
            parent[pu] = pv;
            size[pv] += size[pu];
        }
        else {
            parent[pv] = pu;
            size[pu] += size[pv];
        }
    }

    boolean isConnected(int u, int v) {
        return findParent(u) == findParent(v);
    }
}

class Solution {

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] ans = new int[2];
        DisjointSet ds = new DisjointSet(n);
        for(int[] e : edges) {
            if(!ds.isConnected(e[0], e[1])) {
                ds.unionBySize(e[0], e[1]);
            }
            else {
                ans = e;
            }
        }
        return ans;
    }
}
