public class ValidTree {

    public boolean validTree(int n, int[][] edges) {


        UnionFind uf = new UnionFind(n);

        for(int [] edge :edges) {

            if(!uf.union(edge[0], edge[1])) {
                return false;
            }
        }

        return true;
    }

    public class UnionFind {

        int[] parent;
        int[] size;

        public UnionFind(int n) {

            this.parent = new int[n];
            this.size = new int[n];
            for(int i  =0 ; i<n; i++) {

                parent[i] = i;
                size[i] = 1;
            }
        }


        public int parent(int a) {

            while(a!=parent[a]) {
                parent[a] = parent[parent[a]];
                a = parent[a];
            }

            return a;
        }


        public boolean isConnected(int a, int b){

            return parent(a) == parent(b);
        }

        public boolean union(int a, int b) {

            int parenta = parent(a);
            int parentb = parent(b);

            if(parenta == parentb) {
                return false;
            }
            if(size[parenta]>size[parentb]) {

                parent[parentb] = parenta;
                size[parenta]+=size[parentb];
            }else {

                parent[parenta] = parentb;
                size[parentb]+=size[parenta];
            }

            return true;
        }
    }

    public static void main(String[] args) {
        int[][] edges = {{0,1},{2,3}};

        ValidTree vt = new ValidTree();
        System.out.println(vt.validTree(4, edges));
    }
}
