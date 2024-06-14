import java.io.*;
import java.util.*;

public class Main {

    private static int N,M;
    private static int[][] grid;

    private static class Pos {
        public int x;
        public int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new int[N][M];
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; ++j) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        bfs();

        // for (int i = 0; i < N; ++i) {
        //     System.out.println(Arrays.toString(grid[i]));
        // }

        bw.write(String.valueOf(grid[N-1][M-1]));
        bw.flush();
        bw.close();
        
    }

    private static void bfs() {
        Deque<Pos> queue = new ArrayDeque();
        queue.add(new Pos(0, 0));

        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};

        int movCount = 1;
        while(!queue.isEmpty()) {
            Pos cur = queue.poll();
            ++movCount;
            for (int i = 0; i < 4; ++i) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (canGo(nx, ny)) {
                    grid[ny][nx] = movCount;
                    queue.push(new Pos(nx, ny));
                }
            }
        }
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && x < M && y >= 0 && y < N;
    }

    private static boolean canGo(int x, int y) {
        return inRange(x, y) && grid[y][x] == 1;
    }
}