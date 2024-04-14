import java.io.*;
import java.util.*;

public class Main {

    private static int N, Q;
    private static int[] line = new int[1_000_002];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; ++i) {
            line[Integer.parseInt(st.nextToken()) + 1] = 1;
        }

        for (int i = 1; i < line.length; ++i) {
            line[i] = line[i] + line[i-1];
        }

        for (int i = 0; i < Q; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken()) + 1;
            int end = Integer.parseInt(st.nextToken()) + 1;

            System.out.println(line[end] - line[start - 1]);
        }
        
    }
}