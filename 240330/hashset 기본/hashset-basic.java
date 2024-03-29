import java.io.*;
import java.util.*;

public class Main {
    
    public static int N;
    public static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            String query = st.nextToken();
            int val = Integer.parseInt(st.nextToken());

            if (query.equals("add")) {
                set.add(val);
            } else if (query.equals("remove")) {
                set.remove(val);
            } else {
                System.out.println(set.contains(val));
            }
        }
    }
}