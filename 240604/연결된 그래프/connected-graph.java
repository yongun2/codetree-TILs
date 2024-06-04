import java.io.*;
import java.util.*;

public class Main {

    private static int N, M;
    private static Map<Integer, ArrayList<Integer>> graph = new HashMap<>();
    private static Set<Integer> visited = new HashSet<>();
    
    private static int result = -1;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine());
            int base = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            graph.putIfAbsent(base, new ArrayList<Integer>());
            graph.putIfAbsent(target, new ArrayList<Integer>());

            graph.get(base).add(target);
            graph.get(target).add(base);
            
        }
        
        dfs(1);
        System.out.println(result);

    }

    private static void dfs(int start) {

        if (visited.contains(start)) {
            return;
        }
        
        visited.add(start);
        result += 1;

        for (Integer neighbor: graph.get(start)) {
            dfs(neighbor);
        }
    }
}