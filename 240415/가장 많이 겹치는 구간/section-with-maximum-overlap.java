import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int[] line = new int[200_001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            line[start] = 1;
            line[end] = -1;
        }

        int result = 0;
        int sum = 0;
        for (int i = 1; i < line.length; ++i) {
            sum += line[i];
            result = Math.max(result, sum);
        }
        System.out.println(result);
    }
}