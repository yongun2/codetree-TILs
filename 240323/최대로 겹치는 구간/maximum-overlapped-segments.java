import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());

        int[] intervals = new int[101];
        StringTokenizer st;
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            for (int j = start; j <=end; ++j) {
                if (j == start || j == end) continue;
                intervals[j] += 1;
            }
        }

        int result = Integer.MIN_VALUE;
        for (int i = 0; i < intervals.length; ++i) {
            if (result < intervals[i]) result = intervals[i];
        }

        System.out.println(result);
    }
}