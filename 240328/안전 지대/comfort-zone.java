import java.io.*;
import java.util.*;

public class Main {

    public static int N,M;
    public static int[][] grid;
    public static boolean[][] visited;

    public static int result = 0;
    
    public static boolean inRange(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }

    public static boolean canGo(int y, int x, int k) {
        if (!inRange(y, x)) return false;

        if (visited[y][x] || grid[y][x] <= k) return false;

        return true;
    }

    public static void DFS(int y, int x, int k) {

        int[] dx = new int[] {0, 1, 0, -1};
        int[] dy = new int[] {-1, 0, 1, 0};

        visited[y][x] = true;

        for (int i = 0; i < 4; ++i) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if (canGo(ny, nx, k)) {
                DFS(ny, nx, k);
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int K = Integer.MIN_VALUE;
        grid = new int[N][M];
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; ++j) {
                int val = Integer.parseInt(st.nextToken());
                grid[i][j] = val;
                if (K < val) K = val;
            }
        }
        int resultCount = Integer.MIN_VALUE;
        int resultK = Integer.MIN_VALUE;
        for (int i = 1; i <= K; ++i) {
            int count = 0;
            visited = new boolean[N][M];
            for (int j = 0; j < N; ++j) {
                for (int k = 0; k < M; ++k) {
                    if (canGo(j, k, i)) {
                        visited[j][k] = true;
                        DFS(j, k, i);

                        count += 1;
                    }
                }
            }
            if (resultCount < count) {
                resultCount = count;
                resultK = i;
            }
            
        }

        System.out.printf("%d %d\n", resultK, resultCount);
    }
}