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

        
        int result = Integer.MIN_VALUE;
        int rowMaxSum = 0;
        for (int i = 0; i < grid.length; ++i) {
            int sum = 0;
            for (int j = 0; j < 3; ++j) {
                sum += grid[i][j];
            }
            rowMaxSum = sum;
            for (int j = 3; j < grid.length; ++j) {
                sum = sum - grid[i][j - 3] + grid[i][j];
                rowMaxSum = Math.max(rowMaxSum, sum);
            }
            result = Math.max(result, rowMaxSum);
        }

        System.out.println(result);

        
    }
}