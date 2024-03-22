import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());

        int[] rooms = new int[N];
        for (int i = 0; i < N; ++i) {
            rooms[i] = Integer.parseInt(br.readLine());
            
        }

        

        int result = Integer.MAX_VALUE;
        for (int start = 0; start < N; ++start) {
            int next = start;
            int distance = 0;
            int count = 0;
            while(true) {
                if (count != 0 && start == next) break;
                
                distance += count * rooms[next];
                next = next == N-1 ? 0 : next + 1;
                count += 1;
                
            }
            
            result = Math.min(result, distance);
        }

        System.out.println(result);
        

    }
}