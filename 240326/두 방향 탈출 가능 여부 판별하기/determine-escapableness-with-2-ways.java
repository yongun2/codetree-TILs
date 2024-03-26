import java.io.*;
import java.util.*;

public class Main {

    private static int[][] graph;
    private static boolean[][] visited;
    private static int N, M;

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

        DFS(0, 0);

        System.out.println(result);
    }

    private static void DFS(int x, int y) {
        // is inRange
        if (y < 0 || y >= N || x < 0 || x >= M) return;
        // isBlocked
        if (graph[y][x] == 0) return;
        // isVisited
        if (visited[y][x]) return;

        

        visited[y][x] = true;
        if (x == M - 1 && y == N - 1) result = 1;

        DFS(y+1, x);
        DFS(y, x+1);
    }

    
}