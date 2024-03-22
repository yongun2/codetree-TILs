import java.io.*;
import java.util.*;


public class Main {

    private static int result = 0;
    private static char[][] grid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] size = new int[2];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");;
        for(int i = 0; i < 2; ++i) {
            size[i] = Integer.parseInt(st.nextToken());
        }

        final int R = size[0];
        final int C = size[1];

        grid = new char[R][C];
        for(int i = 0; i < R; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < C; ++j) {
                grid[i][j] = st.nextToken().charAt(0);
            }
        }
        
        trace(0, 0, 1);

        System.out.println(result);
        
    }

    private static void trace(int x, int y, int step) {
        if (y >= grid.length || x >= grid[y].length) return;

        if (step == 2 && grid[y][x] != 'B') return;
        if (step == 3 && grid[y][x] != 'W') return;
        if (step == 4 && grid[y][x] != 'B') return;
            
        if (y == grid.length - 1 && x == grid[y].length - 1 && grid[y][x] == 'B' && step==4) {
            result++;
            return;
        }
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                int nextY = y + i + 1;
                int nextX = x + j + 1;

                if (nextY - y < 1 || nextX - x < 1) continue;
                trace(nextX, nextY, step+1);
            }
        }
    }   
    
}