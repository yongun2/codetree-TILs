import java.io.*;
import java.util.*;


public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int N, M, START;
    private static Map<Integer, ArrayList<Integer>> graph = new HashMap<>();
    private static Set<Integer> visited = new HashSet<>();

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        START = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            int base = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());

            graph.putIfAbsent(base, new ArrayList<Integer>());
            graph.putIfAbsent(target, new ArrayList<Integer>());
            graph.get(base).add(target);
            graph.get(target).add(base);
        }

        for (Integer key: graph.keySet()) {
            Collections.sort(graph.get(key));
        }

        dfs(START);
        visited.clear();
        bw.write("\n");
        bfs(START);

        bw.flush();
        bw.close();
        
    }

    private static void dfs(int start) throws IOException {

        if (visited.contains(start)) {
            return;
        }
        bw.write(String.valueOf(start) + " ");
        visited.add(start);

        for (Integer neighbor: graph.get(start)) {
            dfs(neighbor);
        }
    }

    private static void bfs(int start) throws IOException {
        Deque<Integer> queue = new ArrayDeque<>();

        queue.add(start);
        visited.add(start);

        while (queue.size() != 0) {

            int next = queue.poll();
            bw.write(String.valueOf(next) + " ");

            for (Integer neighbor: graph.get(next)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }
}