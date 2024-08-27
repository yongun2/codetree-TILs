import java.util.*;
import java.io.*;

public class Main {
    
    private static int N, Q;
    private static int[][] grids;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        grids = new int[N + 1][N + 1];

        for (int i = 1; i <= N; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= N; ++j) {
                grids[i][j] = Integer.parseInt(st.nextToken());
            }
        }   

        int[][] prefixSum = new int[N+1][N+1];

        for (int i = 1; i <= N; ++i) {
            for (int j = 1; j <= N; ++j) {
                prefixSum[i][j] = prefixSum[i-1][j] + prefixSum[i][j-1] 
                - prefixSum[i-1][j-1] + grids[i][j];
            }
        }

        for (int i = 0; i < Q; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            int result = prefixSum[y2][x2] - prefixSum[y1 - 1][x2] 
                - prefixSum[y2][x1 - 1] + prefixSum[y1-1][x1-1];
            System.out.println(result);
        }
        

    }
}