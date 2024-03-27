import java.io.*;
import java.util.*;

public class Main {

    public static int N, K;
    public static int[][] grid;
    public static boolean[][] visited;

    public static int result = 0;

    static class Pair {
        public int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        grid = new int[N][N];
        visited = new boolean[N][N];
        
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; ++j) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Deque<Pair> queue = new ArrayDeque<>();
        
        for (int i = 0; i < K; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;

            queue.add(new Pair(x, y));
            if (!visited[y][x]) {
                visited[y][x] = true;
                result+=1;
            }
            
            while(!queue.isEmpty()) {
                Pair current = queue.poll();

                int[] dx = new int[] {0, 1, 0, -1};
                int[] dy = new int[] {-1, 0, 1, 0};

                for (int j = 0; j < 4; ++j) {
                    int nx = dx[j] + current.x;
                    int ny = dy[j] + current.y;
                    if (canGo(ny, nx)) {
                        result += 1;
                        visited[ny][nx] = true;
                        queue.add(new Pair(nx, ny));
                    }
                }
                
            }
            
        }
        
        System.out.println(result);
    }

    public static boolean inRange(int y, int x) {
        return 0 <= y && y < N && 0 <= x && x < N;
    }

    public static boolean canGo(int y, int x) {
        if (!inRange(y, x)) return false;

        if (visited[y][x] || grid[y][x] == 1) return false;

        return true;
    }
}