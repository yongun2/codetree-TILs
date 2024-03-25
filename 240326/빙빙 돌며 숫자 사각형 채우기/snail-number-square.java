import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        final int R = Integer.parseInt(st.nextToken());
        final int C = Integer.parseInt(st.nextToken());

        final int[] dx = new int[] {1, 0, -1, 0};
        final int[] dy = new int[] {0, 1, 0, -1};

        int[][] grid = new int[R][C];

        int direction = 0;

        int curX = 0;
        int curY = 0;
        grid[curY][curX] = 1;
        for (int i = 2; i <= R * C; ++i) {
            int nx = dx[direction] + curX;
            int ny = dy[direction] + curY;
            
            if (!inRange(nx, ny, R, C) || grid[ny][nx] != 0) {
                direction = (direction + 1) % 4;
            } 
            curX += dx[direction];
            curY += dy[direction];

            grid[curY][curX] = i;
        }

        for (int i = 0; i < R; ++i) {
            for (int j = 0; j < C; ++j) {
                System.out.printf("%d ", grid[i][j]);
            }
            System.out.println();
        }
        
    }

    private static boolean inRange(int x, int y, int R, int C) {
        return x >= 0 && x < C && y >= 0 && y < R;
    }

    
}