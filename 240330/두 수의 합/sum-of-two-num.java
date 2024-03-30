import java.io.*;
import java.util.*;

public class Main {
    public static int N, K;
    public static long[] array;
    public static Map<Long, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        array = new long[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; ++i) {
            long val = Long.parseLong(st.nextToken());
            array[i] = val;
        }

        int result = 0;
        for (long num: array) {
            long diff = K - num;
            if (map.containsKey(diff)) {
                result += map.get(diff);
            }

            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }

        System.out.println(result);
    }

    
}