public class UnionFindUpArray implements IUnionFind {

    private int[] parent;
    private int count;

    public UnionFindUpArray(int n) {
        init(n);
    }

    @Override
    public void init(int N) {
        count = N;
        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i; // initially, each element is its own parent
        }
    }

    @Override
    public int find(int p) {
        if (p < 0 || p >= parent.length) throw new IllegalArgumentException();
        return parent[p]; // no tree traversal, direct lookup
    }

    @Override
    public void union(int p, int q) {
        int pid = find(p);
        int qid = find(q);
        if (pid == qid) return;

        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == pid) {
                parent[i] = qid; // update entire component
                break;
            }
        }
        count--;
    }

    @Override
    public int count() {
        return count;
    }
}
