import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int[][] grid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        grid = new int[N+1][N+1];

        for (int i = 1; i <= N; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= N; ++j) {
                grid[i][j] = grid[i-1][j] +
                                grid[i][j-1] +
                                Integer.parseInt(st.nextToken()) -
                                grid[i-1][j-1];
            }
        }
        int result = Integer.MIN_VALUE;
        for (int row = 1; row <= N; ++row) {
            for (int col = 1; col <= N; ++col) {
                // 정사각형
                if (row == col) {
                    for (int i = row; i <= N; ++i) {
                        for (int j = col; j <= N; ++j) {
                            int val = grid[i][j] - grid[i - row][j] - grid[i][j-col] + grid[i-row][j-col];
                            result = Math.max(result, val);
                        }
                    }
                } else {
                    for (int i = row; i <= N; ++i) {
                        for (int j = col; j <= N; ++j) {
                            int val = grid[i][j] - grid[i - row][j] - grid[i][j-col] + grid[i-row][j-col];
                            result = Math.max(result, val);
                        }
                    }

                    for (int i = col; i <= N; ++i) {
                        for (int j = row; j <= N; ++j) {
                            int val = grid[j][i] - grid[j - row][i] - grid[j][i-col] + grid[j-row][i-col];
                            result = Math.max(result, val);
                        }
                    }
                }
                // 직사각형
            }
        }
        System.out.println(result);

    }
}