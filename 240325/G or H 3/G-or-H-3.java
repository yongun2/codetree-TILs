import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        final int N = Integer.parseInt(st.nextToken());
        final int K = Integer.parseInt(st.nextToken());       

        int[] line = new int[10_001];
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            int point = Integer.parseInt(st.nextToken());
            String alpha = st.nextToken();
            if (alpha.equals('G')) {
                line[point] = 1;
            } else {
                line[point] = 2;
            }
        }
        int sum = 0;
        for (int i = 0; i < K; ++i) {
            sum += line[i];
        }

        int result = sum - 1;
        for (int i = K; i < line.length; ++i) {
            sum = sum - line[i-K] + line[i] - 1;
            result = Math.max(result, sum);
        }

        System.out.println(result);
    }
}