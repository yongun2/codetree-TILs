import java.io.*;
import java.util.*;

public class Main {

    public static int[][] grid;
    public static boolean[][] visited;
    public static int N;

    public static int villageCount = 0;
    public static int memberCount = 0;
    public static List<Integer> members = new ArrayList<>();

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
                if (canGo(i, j)) {
                    visited[i][j] = true;
                    memberCount = 1;
                    
                    DFS(i, j);
                    members.add(memberCount);   
                }    
            }
            
        }

        System.out.println(members.size());
        Collections.sort(members);
        for (Integer count: members) {
            System.out.println(count);
        }
    }

    public static void DFS(int y, int x) {
        int[] dx = new int[] {0, 1, 0, - 1};
        int[] dy = new int[] {-1, 0, 1, 0};

        visited[y][x] = true;
        for (int i = 0; i < 4; ++i) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if (canGo(ny, nx)) {
                memberCount += 1;
                DFS(ny, nx);
            }
        }
    }

    public static boolean canGo(int y, int x) {
        if (!inRange(y, x)) return false;

        if (grid[y][x] == 0 || visited[y][x]) return false;

        return true;
    }

    public static boolean inRange(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < N;
    }
}