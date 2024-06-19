import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;
    private static Map<Integer, ArrayList<Integer>> graph = new HashMap<>();
    private static Set<Integer> visited = new HashSet<>();

    private static int result = 0;

    private static class Node {
        int num;
        int depth;
        public Node(int num, int depth) {
            this.num = num;
            this.depth = depth;
        }
    }

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            int base = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());

            graph.putIfAbsent(base, new ArrayList<Integer>());
            graph.putIfAbsent(target, new ArrayList<Integer>());
            
            graph.get(base).add(target);
            graph.get(target).add(base);
        }

        for (Integer start: graph.keySet()) {
            bfs(start);
            // System.out.println();
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    private static void bfs(int start) {
        Deque<Node> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(new Node(start, 0));
        visited.add(start);

        while(!queue.isEmpty()) {
            Node cur = queue.poll();

            // System.out.printf("%d %d\n", cur.num, cur.depth);

            List<Integer> neighbors = graph.get(cur.num);
            if (cur.depth == 3 && neighbors.size() != 0) {
                result =1;
                return;
            }

            for (int i = 0; i < neighbors.size(); ++i) {
                int neighbor = neighbors.get(i);
                if(!visited.contains(neighbor)) {
                    queue.add(new Node(neighbor, cur.depth + 1));
                    visited.add(neighbor);
                }
            }
        }
        
    }
}