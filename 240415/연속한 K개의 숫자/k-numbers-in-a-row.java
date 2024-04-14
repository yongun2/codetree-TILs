import java.io.*;
import java.util.*;

public class Main {

    private static int N, K, B;
    private static int[] prefixSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        prefixSum = new int[N + 1];
        for (int i = 1; i <= N; ++i) {
            prefixSum[i] =  1;
        }

        for (int i = 0; i < B; ++i) {
            prefixSum[Integer.parseInt(br.readLine())] = 0;
        }

        for (int i = 1; i <= N; ++i) {
            prefixSum[i] = prefixSum[i] + prefixSum[i-1];
        }

        int result = Integer.MAX_VALUE;
        for (int i = B; i <= N; ++i) {
            result = Math.min(result, B - (prefixSum[i] - prefixSum[i - B]));
        }

        System.out.println(result);

   
    }
}