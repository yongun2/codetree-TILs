import java.io.*;
import java.util.*;

public class Main {

    private static int N,M;
    private static int[][] grid;
    private static boolean[][] visited;
    

    private static int[] oddDx = new int[]  {0, 1, 1, 1, 0, -1};
    private static int[] evenDx = new int[] {-1, 0, 1, 0, -1, -1};
    private static int[] dy = new int[]  {-1, -1, 0, 1, 1, 0};

    private static int result = 0;

    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int padding = 2;

        grid = new int[N + padding][M + padding];
        visited = new boolean[N + padding][M + padding];

        for (int i = 1; i <= N; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= M; ++j) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // for (int i = 0; i < N + padding; ++i) {
        //     System.out.println(Arrays.toString(grid[i]));
        // }

        for (int i = 1; i <= N; ++i) {
            for (int j = 1; j <= M; ++j) {
                dfs(j, i);
            }
        }

        // System.out.println(count);
        System.out.println(result);
    }

    private static void dfs(int startX, int startY) {
        if (!canGo(startX, startY)) {
            return;
        }

        if (visited[startY][startX]) {
            return;
        }

        count += 1;
        visited[startY][startX] = true;

        if (startY % 2 == 0) {
            for (int i = 0; i < 6; ++i) {
                int nx = startX + evenDx[i];
                int ny = startY + dy[i];

                if (grid[ny][nx] != 1 && !isInside(nx, ny)) {
                    result += 1;
                }

                dfs(nx, ny);
            }
        } else {
            for (int i = 0; i < 6; ++i) {
                int nx = startX + oddDx[i];
                int ny = startY + dy[i];

                if (grid[ny][nx] != 1 && !isInside(nx, ny)) {
                    result += 1;
                }
                
                dfs(nx, ny);
            }
        }
    }

    private static boolean canGo(int x, int y) {
        return inRange(x, y) && grid[y][x] == 1;
    }   

    private static boolean inRange(int x, int y) {
        return y >= 1 && y <= N && x >= 1 && x <= M;
    }

    private static boolean isInside(int x, int y) {
        int count = 0;
        for (int i = 0; i < 6; ++i) {
            int nx = x + oddDx[i];
            int ny = y + dy[i];

            if (!inRange(nx,ny)) {
                continue;
            }

            if (grid[ny][nx] == 1) {
                count += 1;
            }
        }
        return count == 6;
    }    

}