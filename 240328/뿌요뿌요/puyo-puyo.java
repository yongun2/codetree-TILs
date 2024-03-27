import java.io.*;
import java.util.*;

public class Main {

    public static int N;
    public static int[][] grid;
    public static boolean[][] visited;

    public static int curNumber;
    public static int blocks = 0;
    public static List<Integer> bomb = new ArrayList<>();

    public static boolean inRange(int y, int x) {
        return 0 <= y && y < N && 0 <= x && x < N;
    }

    public static boolean canGo(int y, int x) {
        if (!inRange(y, x)) return false;

        if (grid[y][x] != curNumber || visited[y][x]) return false;

        return true;
    }

    public static void DFS(int y, int x) {
        int[] dx = new int[] {0, 1, 0, -1};
        int[] dy = new int[] {-1, 0, 1, 0};

        visited[y][x] = true;
        for (int i = 0; i < 4; ++i) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (canGo(ny, nx)) {
                blocks += 1;
                DFS(ny, nx);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

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

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                curNumber = grid[i][j];
                if (canGo(i, j)) {
                    visited[i][j] = true;
                    
                    blocks = 1;
                    DFS(i, j);
                    
                    bomb.add(blocks);
                    
                }
            }
        }
        System.out.printf("%d %d\n", bomb.stream().filter(i -> i >= 4).count(), Collections.max(bomb));
        
    }
}