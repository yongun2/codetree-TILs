import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        final int N = Integer.parseInt(st.nextToken());
        final int K = Integer.parseInt(st.nextToken());

        int[] blocks = new int[N];
        int[][] query = new int[K][2];
        for (int i = 0; i < K; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            for (int j = start; j <= end; ++j) {
                blocks[j] += 1;
            }
        }
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < blocks.length; ++i) {
            if (result < blocks[i]) result = blocks[i];
        }
        System.out.println(result);

        
    }
}