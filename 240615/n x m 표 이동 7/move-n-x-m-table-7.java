import java.io.*;
import java.util.*;

public class Main {

    private static int N, M;
    private static int[][] grid;
    private static boolean[][] visited;

    private static int H, W;
    private static int startX, startY;
    private static int endX, endY;

    // private static int result = 0;

    private static class Rectangle {
        public Pos topLeft;
        public Pos bottomRight;
        public Rectangle(Pos topLeft, Pos bottomRight) {
            this.topLeft = topLeft;
            this.bottomRight = bottomRight;
        }
    }

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
        visited = new boolean[N][M];

        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; ++j) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        
        startY = Integer.parseInt(st.nextToken()) - 1;
        startX = Integer.parseInt(st.nextToken()) - 1;
        
        endY = Integer.parseInt(st.nextToken()) - 1;
        endX = Integer.parseInt(st.nextToken()) - 1;

        bfs();

        // for (int i = 0; i < N; ++i) {
        //     System.out.println(Arrays.toString(grid[i]));
        // }
        bw.write(String.valueOf(grid[endY][endX] == 0 ? -1 : grid[endY][endX]));

        
        bw.flush();
        bw.close();
    }

    private static void bfs() {
        Deque<Pos> queue = new ArrayDeque<>();
        Pos start = new Pos(startX, startY);
        queue.add(start);
        visit(startX, startY);
        
        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            Pos cur = queue.poll();

            if (cur.x == endX && cur.y == endY) {
                return;
            }

            for (int i = 0; i < 4; ++i) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (inRange(nx, ny) && canGo(nx, ny)) {
                    visit(nx, ny);
                    queue.add(new Pos(nx, ny));
                    grid[ny][nx] = grid[cur.y][cur.x] + 1;
                }
            }

            // for (int i = 0; i < N; ++i) {
            //     System.out.println(Arrays.toString(visited[i]));
            // }
            // System.out.println();
        }
    }

    private static void visit(int x, int y) {
        for (int i = y; i <= y + H - 1; ++i) {
            for (int j = x; j <= x + W - 1; ++j) {
                visited[i][j] = true;
            }
        }
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && x + W - 1 < M && y >= 0 && y + H - 1 < N;
    }

    private static boolean canGo(int x, int y) {
        for (int i = y; i <= y + H - 1; ++i) {
            for (int j = x; j <= x + W - 1; ++j) {
                if (grid[i][j] == 1) {
                    return false;
                }
            }
        }

        return true;
    }
}