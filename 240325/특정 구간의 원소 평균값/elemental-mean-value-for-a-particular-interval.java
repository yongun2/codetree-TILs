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

        int result = 0;
        for (int i = 0; i < N; ++i) {
            for (int j = i; j < N; ++j) {
                int sum = 0;
                for (int k = i; k <= j; ++k) {
                    sum += inputs[k];
                }
                
                double average = (double) sum / ((j - i) + 1);
                
                boolean flag = false;
                for (int k = i; k <= j; ++k) {
                    if (average == inputs[k]) {
                        flag = true;
                        break;
                    }
                }
                if (flag) result++;
            }
        }

        System.out.println(result);
    }
}