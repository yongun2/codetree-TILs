import java.io.*;
import java.util.*;

public class Main {
    public static int N, K;
    public static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; ++i) {
            int val = Integer.parseInt(st.nextToken());
            map.put(val, Math.abs(K - val));
        }
        int result = 0;
        for (Integer key: map.keySet()) {
            if (map.containsKey(key)) result += 1;
        }

        System.out.println(result / 2);
    }
}