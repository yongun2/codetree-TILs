import java.io.*;
import java.util.*;

public class Main {

    private static int N,M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] grid = new int[N + 1][N + 1];

        int[] dx = new int[] {0, 1, 0, -1};
        int[] dy = new int[] {-1, 0, 1, 0};

        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine(), " ");

            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            grid[y][x] = 1;
            
            int count = 0;
            for (int j = 0; j < 4; ++j) {
                int nx = x + dx[j];
                int ny = y + dy[j];

                if (inRange(nx, ny) && grid[ny][nx] == 1) {
                    count += 1;
                }
            }
            
            if (count == 3) System.out.println(1);
            else System.out.println(0);
        }
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && x < M && y >= 0 && y < N;
    }
}