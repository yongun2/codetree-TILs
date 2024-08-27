import java.io.*;
import java.util.*;

public class Main {

    private static int N, M;
    private static int[] inputs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        inputs = new int[N + 1];
        inputs[0] = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; ++i) {
            inputs[i] = inputs[i-1] + Integer.parseInt(st.nextToken());
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i < N - M; ++i) {
            max = Math.max(max, inputs[i + M - 1] - inputs[i - 1]);
        }
        int count = 0;
        for (int i = 1; i <= N - M + 1; ++i) {
            if (max == inputs[i + M - 1] - inputs[i - 1]) {
                count++;
            }
        }

        if (max != 0) {
            System.out.println(max);
            System.out.println(count);
        }
        
    }
}