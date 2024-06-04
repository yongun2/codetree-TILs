import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int[][] grid;
    private static boolean[][] visited;

    private static int[] dx = new int[] {0, 1, 0, -1};
    private static int[] dy = new int[] {-1, 0, 1, 0};
    private static int count = 0;
    private static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        grid = new int[N][N];
        visited = new boolean[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; ++j) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // for (int i = 0; i < N; ++i) {
        //     System.out.println(Arrays.toString(grid[i]));
        //     System.out.println(Arrays.toString(visited[i]));
        // }

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                count = 0;
                dfs(j, i);
                if (count != 0) {
                    result.add(count);
                }
            }
        }

        Collections.sort(result);

        bw.write(String.valueOf(result.size()) + "\n");
        for(Integer count: result) {
            bw.write(String.valueOf(count) + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static void dfs(int startX, int startY) {

        if (!canGo(startX, startY)) {
            return;
        }
        if (visited[startY][startX]) {
            return;
        }
        // System.out.printf("x: %d y: %d\n", startX, startY);

        count += 1;
        visited[startY][startX] = true;

        for (int i = 0; i < 4; ++i) {
            int nextX = startX + dx[i];
            int nextY = startY + dy[i];
            dfs(nextX, nextY);
        }
    }

    private static boolean canGo(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N && grid[y][x] != 0;
    }
}