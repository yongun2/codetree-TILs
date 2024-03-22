import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());

        int[] intervals = new int[201];
        final int offset = 100;
        
        StringTokenizer st;
        for (int interval = 0; interval < N; ++interval) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken()) + offset;
            int end = Integer.parseInt(st.nextToken()) + offset;

            for (int i = start; i < end; ++i) {
                intervals[i] += 1;
            }
            
        }

        int result = Integer.MIN_VALUE;
        for (int i = 0; i < intervals.length; ++i) {
            result = Math.max(result, intervals[i]);
        }

        System.out.println(result);

        

        
    }
}