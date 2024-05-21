import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int[] arrays;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arrays = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; ++i) {
            arrays[i] = Integer.parseInt(st.nextToken());
        }

        arrays = Arrays.stream(arrays)
                .sorted()
                .toArray();
        
        for (int i = arrays.length - 1; i >= 0; --i) {
            System.out.print(arrays[i] + " ");
        }
    }
}