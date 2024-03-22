import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());

        int[] negativeIntervals = new int[101];
        int[] positiveIntervals = new int[101];
        StringTokenizer st;
        for (int interval = 0; interval < N; ++interval) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if (start < 0 && end < 0) {
                for (int i = Math.abs(end); i < Math.abs(start); ++i) {
                    if (i == start || i == end) continue;
                    negativeIntervals[i] += 1;
                }
            } else if (start < 0 && end >= 0) {
                for (int i = Math.abs(start); i < negativeIntervals.length; ++i) {
                    if (i == start || i == end) continue;
                    negativeIntervals[i] += 1;
                }
                for (int i = 0; i <= end; ++i) {
                    if (i == start || i == end) continue;
                    positiveIntervals[i] += 1;
                }

            } else {
                for (int i = start; i <=end; ++i) {
                    if (i == start || i == end) continue;
                    positiveIntervals[i] += 1;
                }
            }
        }

        int result = Integer.MIN_VALUE;
        for (int i = 0; i < negativeIntervals.length; ++i) {
            if (result < negativeIntervals[i]) result = negativeIntervals[i];
        }
        for (int i = 0; i < positiveIntervals.length; ++i) {
            if (result < positiveIntervals[i]) result = positiveIntervals[i];
        }

        System.out.println(result);
    }
}