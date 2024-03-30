import java.io.*;
import java.util.*;

public class Main {
    public static int N, K;
    public static int[] array;
    public static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        array = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; ++i) {
            int val = Integer.parseInt(st.nextToken());
            array[i] = val;
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

    
        int result = 0;
        for (int num: array) {
            int need = K - num;
            if (!map.containsKey(need)) continue;

            if (map.get(num) == 0 || map.get(need) == 0) continue;

            if (need == num) {
                int count = map.get(num);
                result += count - 1;
                map.put(need, count - 1);
            } else if(map.containsKey(need)) {
                result += map.get(need) * map.get(num);
                map.put(num, map.get(num) - 1);
            }
            
        }
        // 
        System.out.println(result);
    }

    
}