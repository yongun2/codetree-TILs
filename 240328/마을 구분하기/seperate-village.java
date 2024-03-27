import java.io.*;
import java.util.*;

public class Main {

    public static int[][] grid;
    public static boolean[][] visited;
    public static int N;

    public static int villageCount = 0;
    public static int memberCount = 0;
    public static Set<Integer> members = new HashSet<>(); 

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
                if (DFS(i, j)) {
                    villageCount += 1;
                    members.add(memberCount);
                }
                memberCount = 0;
            }
        }
        System.out.println(villageCount);
        for (Integer count: members) {
            System.out.println(count);
        }
    }

    public static boolean DFS(int x, int y) {
        
        if (!inRange(x, y)) return false;

        if (isBlocked(x, y) || visited[y][x]) return false;

        visited[y][x] = true;
        memberCount += 1;

        int[] dx = new int[] {0, 1, 0, -1};
        int[] dy = new int[] {-1, 0, 1, 0};
        for (int i = 0; i < 4; ++i) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            DFS(nx, ny);
        }
        return true;
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    public static boolean isBlocked(int x, int y) {
        return grid[y][x] == 0;
    }
}