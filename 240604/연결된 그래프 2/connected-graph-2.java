import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int N,M;
    private static Map<Integer, ArrayList<Integer>> graph = new HashMap<>();
    private static Set<Integer> visited = new HashSet<>();

    private static List<Node> result = new ArrayList<>();

    private static int start = 0;
    private static int depth = 0;

    private static class Node {
        public int nodeNum;
        public int depth;

        public Node(int nodeNum, int depth) {
            this.nodeNum = nodeNum;
            this.depth = depth;
        }

        public int getNodeNum() {
            return nodeNum;
        }

        public int getDepth() {
            return depth;
        }

        public String toString() {
            return "nodeNum: " + nodeNum + " depth: " + depth;
        }
    }

    public static void main(String[] args) throws IOException {
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
        }

        // System.out.println(graph);

        for (Integer i: graph.keySet()) {
            start = i;
            depth = 0;
            dfs(i);
            visited.clear();

            result.add(new Node(start, depth));
        }

        // System.out.println(result);
        
        int maxValue = result.stream()
                                .mapToInt(Node::getDepth)
					            .max()
					            .orElse(0);
        result = result.stream()
                            .filter(node -> node.depth == maxValue)
                            .sorted(Comparator.comparing(Node::getNodeNum))
                            .collect(Collectors.toList());
        
        

        for (Node node: result) {
            bw.write(String.valueOf(node.nodeNum) + " ");
        }
        bw.flush();
        bw.close();
    }

    private static void dfs(int cur) {

        if (visited.contains(cur)) {
            return;
        }

        if (start != cur) {
            depth += 1;
        }

        visited.add(cur);

        List<Integer> neighbors = graph.get(cur);

    
        for (int i = 0; i < neighbors.size(); ++i) {
            int next = neighbors.get(i);
            dfs(next);
        }
    }
}