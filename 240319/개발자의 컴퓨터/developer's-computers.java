import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] computers = new int[1001];

        final int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; ++i) {
            int[] inputs = Arrays.stream(br.readLine().split(" "))
                                .mapToInt(Integer::parseInt)
                                .toArray();
            int start = inputs[0];
            int end = inputs[1];
            int computer = inputs[2];

            for (int j = start; j <= end; ++j) {
                computers[j] += computer;
            }
        }

        int result = Integer.MIN_VALUE;
        for (int i = 0; i < 1001; ++i) {
            if (result < computers[i]) result = computers[i];
        }

        System.out.println(result);
    }
}