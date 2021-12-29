package org.learn.leetcode.amazon;

import java.util.Arrays;

public class Problem1135 {


    public int minimumCost(int N, int[][] connections) {
        UnionFind uf = new UnionFind(N);
        

        int cost = 0;
        int totalNodesinMST =0;
        Arrays.sort(connections, (a,b) -> a[2]-b[2]);

        for (int i = 0; i<connections.length; i++) {

            int a = connections[i][0];
            int b = connections[i][1];
           if (uf.isConnected(a, b)) {
               continue;
           }else {
               cost = cost + connections[i][2];
               uf.union(a, b);
           }
        }


        return totalNodesinMST == N-1 ? cost: -1;
    }

    public class UnionFind {

        int[] size;
        int[] parent;

        public void union(int a, int b) {
            int roota = root(a);
            int rootb = root(b);

            if(size[roota] >size[rootb]) {
                parent[rootb] = roota;
                size[roota] = size[roota]+size[rootb];
            }else {
                parent[roota] = rootb;
                size[rootb] = size[rootb] + size[roota];
            }
        }

        public int root (int a) {

            while (a != parent[a]) {
                parent[a] = parent[parent[a]];
                 a = parent[a];
            }

            return a;
        }
        public UnionFind(int N) {

            parent = new int[N+1];
            size = new int[N+1];
            for(int i = 1; i < N; i++) {
                parent[i] = i;
                size[i] = 1;
            }

        }

        public boolean isConnected(int a, int b) {

            return root(a) == root(b);
        }

    }

    public static void main(String[] args) {
        int[][]  connections = {{1,2,5}, {1,3,6},{2,3,1}};
        Problem1135 prob = new Problem1135();
        System.out.println(prob.minimumCost(3, connections));
    }
}
