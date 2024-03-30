import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; ++i) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; ++i) {
            if (!set.contains(Integer.parseInt(st.nextToken()))) {
                System.out.println(0);
            } else {
                System.out.println(1);
            }
        }

        
    
    }
}