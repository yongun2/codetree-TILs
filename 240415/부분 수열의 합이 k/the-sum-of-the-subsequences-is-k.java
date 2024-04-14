import java.io.*;
import java.util.*;

public class Main {

    private static int N, K;
    private static int[] prefixSum;
    private static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        prefixSum = new int[N + 1];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; ++i) {
            prefixSum[i] = Integer.parseInt(st.nextToken()) + prefixSum[i-1];
        }
        
        for (int i = 1; i <= N; ++i) {
            for (int j = i; j <= N; ++j) {
                if (prefixSum[j] - prefixSum[j - i] == K) result ++;
            }
        }

        System.out.println(result);

    }
}