import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;
    private static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        array = new int[N + M];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; ++i) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = N; i < array.length; ++i) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        array = Arrays.sort(array)

        for (int i = 0; i < array.length; ++i) {
            System.out.print(array[i] + " ");
        }
        
    }
}