import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());

        int[] houses = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; ++i) {
            houses[i] = Integer.parseInt(st.nextToken());
        }
        
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < N; ++i) {
            int distance = 0;
            for (int j = 0; j < N; ++j){
                distance += (houses[j] * Math.abs(i - j));
            }
            result = Math.min(result, distance);
        }

        System.out.println(result);
    }
}