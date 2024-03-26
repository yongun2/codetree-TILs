import java.io.*;
import java.util.*;

public class Main {

    private static Map<Integer, List<Integer>> graph = new HashMap<>();
    private static Set<Integer> visited = new HashSet<>();
    private static int N, M;
    private static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; ++i) {
            graph.putIfAbsent(i, new ArrayList<Integer>());
        }

        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine(), " ");

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        
        DFS(1);

        System.out.println(result);
    }

    private static void DFS(int vertex) {
        
        if (visited.contains(vertex)) return;

        if (vertex != 1) result ++;

        visited.add(vertex);
        List<Integer> neighbors = graph.get(vertex);
        if (neighbors == null ) return;
        for (int next: neighbors) {
            DFS(next);
        }
    }
}