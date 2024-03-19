import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] computers = new int[1001];
        final int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine(), " ");

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int computer = Integer.parseInt(st.nextToken());

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