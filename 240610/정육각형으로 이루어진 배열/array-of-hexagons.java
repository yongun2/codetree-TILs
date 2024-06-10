import java.io.*;
import java.util.*;

public class Main {

    private static int N, M;
    private static int[][] grid, lookup;
    private static boolean[][] visited;

    private static int result = 0;
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new int[N + 2][M + 2];
        lookup = new int[N + 2][M + 2];
        visited = new boolean[N + 2][M + 2];

        for (int i = 1; i <= N; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= M; ++j) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        dfs(0, 0);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    private static void dfs(int startX, int startY) {

        if (!inRange(startX, startY)) {
            return;
        }

        if (grid[startY][startX] == 1 || visited[startY][startX]) {
            return;
        }

        visited[startY][startX] = true;
        
        int[] dx;
        int[] dy = new int[] {-1, -1, 0, 1, 1, 0};
        if (startY % 2 == 0) {
            dx = new int[] {-1, 0, 1, 0, -1, -1};
        } else {
            dx = new int[] {0, 1, 1, 1, 0, -1};
        }

        for (int i = 0; i < 6; ++i) {
            int nx = startX + dx[i];
            int ny = startY + dy[i];

            if (inRange(nx, ny) && grid[ny][nx] == 1) {
                result += 1;
                continue;
            } 
            dfs(nx,ny);
        }
    } 

    private static boolean inRange(int x, int y) {
        return x >= 0 && x < M + 2 && y >= 0 && y < N + 2;
    }
}