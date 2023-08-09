import java.util.*;

public class BFS {
    public static void main(String[] args) {
        int vertices = 8;
        int[][] edges = {
            {0, 1},
            {0, 2},
            {0, 3},
            {1, 4},
            {1, 7},
            {2, 5},
            {3, 6}
        };

        ArrayList<Integer> bfsResult = BFS1(vertices, edges);
        System.out.println(bfsResult);
    }

    public static ArrayList<Integer> BFS1(int vertex, int edges[][]) {
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] vis = new boolean[vertex + 1];
        Arrays.fill(vis, false);
        Queue<Integer> q = new LinkedList<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= vertex; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            adj.get(x).add(y);
            adj.get(y).add(x);
        }
        q.offer(0);
        vis[0] = true;
        while (!q.isEmpty()) {
            Integer node = q.poll();
            bfs.add(node);
            for (int it : adj.get(node)) {
                if (vis[it] == false) {
                    vis[it] = true;
                    q.offer(it);
                }
            }
        }

        return bfs;
    }
}
