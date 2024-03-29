import java.io.*;
import java.util.*;

public class Main {

    public static int N;
    public static Map<String, Integer> hashMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; ++i) {
            String string = br.readLine();
            hashMap.put(string, hashMap.getOrDefault(string, 0) + 1);
        }

        int result = Integer.MIN_VALUE;
        for (String key: hashMap.keySet()) {
            result = Math.max(result, hashMap.get(key));
        }

        System.out.println(result);

    }
}