import java.io.*;
import java.util.*;

public class Main {

    private static int N, M;
    private static int[][] grid;
    private static boolean[][] visited;
    
    private static int H, W;
    private static int startY, startX;
    private static int endY, endX;

    private static int result = 0;

    static class Pos {
        int x;
        int y;
        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new int[N + 2][M + 2];
        visited = new boolean[N + 2][M + 2];

        for (int i = 1; i <= N; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; ++j) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        
        startY = Integer.parseInt(st.nextToken());
        startX = Integer.parseInt(st.nextToken());

        endY = Integer.parseInt(st.nextToken());
        endX = Integer.parseInt(st.nextToken());

        bfs();

        String result = null;
        if (grid[endY][endX] == 1) {
            result = "-1";
        } else if (grid[endY][endX] >= 0) {
            result = "-1";
        } else {
            result = String.valueOf(Math.abs(grid[endY][endX]));
        }
        bw.write(result);
        bw.flush();
        bw.close();

    }

    private static void bfs() {
        Deque<Pos> queue = new ArrayDeque<>();
        queue.add(new Pos(startX, startY));
        visited[startY][startX] = true;

        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};

        while(!queue.isEmpty()) {
            Pos cur = queue.poll();

            if (cur.x == endX && cur.y == endY) {
                return;
            }

            for (int i = 0; i < 4; ++i) {
                int nx = dx[i] + cur.x;
                int ny = dy[i] + cur.y;

                if (inRange(nx, ny) && canGo(nx, ny, i)) {
                    visited[ny][nx] = true;
                    grid[ny][nx] = grid[cur.y][cur.x] - 1;
                    queue.add(new Pos(nx, ny));
                }
            }
        }
    }

    private static boolean inRange(int x, int y) {
        return x >= 1 && x + W - 1 <= M &&
                y >= 1 && y + H - 1 <= N;
        
    }

    private static boolean canGo(int x, int y, int d) {

        // 방문한 경우
        if (visited[y][x]) return false;

        // 북쪽으로 이동
        if (d == 0) {
            for (int i = x; i < x + W; ++i) {
                if (grid[y][i] == 1) return false;
            }
        } else if (d == 1) {
            // 동쪽으로 이동
            for (int i = y; i < y + H; ++i) {
                if (grid[i][x + W - 1] == 1) return false;
            }
        } else if (d == 2) {
            // 남쪽
            for (int i = x; i < x + W; ++i) {
                if (grid[y + H - 1][i] == 1) return false;
            }    
        } else {
            // 서쪽   
            for (int i = y; i < y + H; ++i) {
                if (grid[i][x] == 1) return false;
            }
        }
        
        
        
        return true;
    }
}