import java.io.*;
import java.util.*;

public class Main {

    private static int[][] graph;
    private static boolean[][] visited;
    private static int N,M;
    private static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; ++j) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Deque<List<Integer>> queue = new ArrayDeque<>();
        queue.add(Arrays.asList(0, 0));
        visited[0][0] = true;

        int[] dx = new int[] {0, 1, 0, -1};
        int[] dy = new int[] {1, 0, -1, 0};

        while(!queue.isEmpty()) {
            List<Integer> current = queue.poll();
            int x = current.get(0);
            int y = current.get(1);

            for (int i = 0; i < 4; ++i) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (inRange(nx, ny) && !visited[ny][nx] && graph[ny][nx] != 0) {
                    visited[ny][nx] = true;
                    queue.add(Arrays.asList(nx, ny));
                    if (ny == N - 1 && nx == M - 1) result = 1;
                }
            }
        }

        System.out.println(result);
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && x < M && y >= 0 && y < N;
    }
}