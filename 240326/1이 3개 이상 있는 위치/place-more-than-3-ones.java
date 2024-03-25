import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int[][] grid = new int[N][N];
        
        StringTokenizer st;
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; ++j) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                int count = 0;
                for (int k = 0; k < 4; ++k) {
                    int x = j + dx[k];
                    int y = i + dy[k];

                    if (y < 0 || y >= N || x < 0 || x >= N) continue;
                    if (grid[y][x] == 1) count++;
                }

                if (count >= 3) result++;
            }
        }

        System.out.println(result);
    }
}