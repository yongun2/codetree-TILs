import java.io.*;
import java.util.*;

public class Main {

    private static int N, K;
    private static int[] sums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        sums = new int[N + 1];

        int sum = 0;
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; ++i) {
            sum += Integer.parseInt(st.nextToken());
            sums[i] = sum;
        }
        int result = Integer.MIN_VALUE;
        for (int i = 2; i < sums.length; ++i) {
            if (i == 2) result = sums[i];
            else {
                result = Math.max(result, sums[i] - sums[i-2]);
            }
        }

        System.out.println(result);
    }
}