import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        array = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; ++i) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);
        int sum = 0;
        for (int i = 0; i < array.length; ++i) {
            for (int j = 0; j <= i; ++j) {
                sum += array[j];
            }
        }

        System.out.println(sum);

    }
}