import java.io.*;
import java.util.*;

public class Main {

    private static int N, K;
    private static int[][] grid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        grid = new int[N + 1][N + 1];

        int sum = 0;
        for (int i = 1; i <= N; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= N; ++j) {
                grid[i][j] = grid[i-1][j] + 
                                grid[i][j-1] - 
                                grid[i-1][j-1] + 
                                Integer.parseInt(st.nextToken()); 
            }
        }
        int result = Integer.MIN_VALUE;
        for (int i = K; i <= N; ++i) {
            for (int j = K; j <= N; ++j) {
                result = Math.max(result, grid[i][j] - grid[i][j-1] - grid[i-1][j] + grid[i-1][j-1]);
            }
        }
        System.out.println(result);

    }
}