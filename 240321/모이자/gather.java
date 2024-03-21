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
        for (int i = 0; i < N; ++i) {
            inputs[i] *= 2;
            int diff = 0;
            for (int j = 0; j < N - 1; ++j) {
                diff += Math.abs(inputs[j+1] - inputs[j]);
            }
            result = Math.max(result, diff);
            inputs[i] /= 2;
        }

        

        System.out.println(result);
    }
}