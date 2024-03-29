import java.io.*;
import java.util.*;

public class Main {
    
    public static int N;

    public static Map<Integer, Integer> hashMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            String query = st.nextToken();
            
            if (query.equals("add")) {
                int key = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());
                hashMap.put(key, value);
            } else if (query.equals("remove")) {
                int key = Integer.parseInt(st.nextToken());
                hashMap.remove(key);
            } else {
                int key = Integer.parseInt(st.nextToken());
                Integer result = hashMap.get(key);
                if (result == null) System.out.println("None");
                else System.out.println(result);
            }
        }

    }
}