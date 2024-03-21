import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());

        int[][] grid = new int[N][N];

        StringTokenizer st;
        for (int i = 0; i < grid.length; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < grid.length; ++j) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;
        for (int i = 0; i < 3; ++i) {
            result += grid[0][i];
        }

        for (int i = 0; i < grid.length; ++i) {
            for (int j = 3; j < grid.length - 3; ++j) {
                result = Math.max(result, result - grid[i][j - 3] + grid[i][j]);
            }
        }

        System.out.println(result);

        
    }
}