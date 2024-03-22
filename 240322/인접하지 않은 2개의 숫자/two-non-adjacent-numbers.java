import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());

        int[] inputs = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; ++i) {
            inputs[i] = Integer.parseInt(st.nextToken());
        }

        int result = Integer.MIN_VALUE;
        for (int i = 0; i < N - 1; ++i) {
            for (int j = i+2; j < N; ++j) {
                result = Math.max(result, inputs[i] + inputs[j]);
            }
        }

        System.out.println(result);
    }

}