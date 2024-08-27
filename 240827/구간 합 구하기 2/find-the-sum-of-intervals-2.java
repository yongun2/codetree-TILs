import java.util.*;
import java.io.*;

public class Main {

    private static int N, M;
    private static int[] inputs;

    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        inputs = new int[N + 1];

        st = new StringTokenizer(br.readLine(), " ");
        inputs[0] = 0;
        for (int i = 1; i <= N; ++i) {
            inputs[i] = inputs[i-1] + Integer.parseInt(st.nextToken());;
        }
        
        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int result = inputs[end] - inputs[start - 1];
            System.out.println(result);
        }

    }
}