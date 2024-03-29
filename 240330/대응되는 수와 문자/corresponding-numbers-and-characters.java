import java.io.*;
import java.util.*;

public class Main {

    public static int N, M;

    public static Map<String, String> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; ++i) {
            String val = br.readLine();
            map.put(val, String.valueOf(i));
            map.put(String.valueOf(i), val);
        }

        for (int i = 0; i < M; ++i) {
            String key = br.readLine();
            System.out.println(map.get(key));
        }
    }
}