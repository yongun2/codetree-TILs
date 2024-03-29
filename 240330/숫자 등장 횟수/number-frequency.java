import java.io.*;
import java.util.*;

public class Main {

    public static int N,M;
    public static Map<Integer, Integer> hashMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; ++i) {
            int key = Integer.parseInt(st.nextToken());
            hashMap.putIfAbsent(key, 0);
            hashMap.put(key, hashMap.get(key) + 1);
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; ++i) {
            int key = Integer.parseInt(st.nextToken());
            if (!hashMap.containsKey(key)) {
                System.out.print(0 + " ");
            } else {
                System.out.print(hashMap.get(key)  + " ");
            }
        }
    }
}