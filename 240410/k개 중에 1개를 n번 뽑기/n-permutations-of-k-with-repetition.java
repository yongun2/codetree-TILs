import java.io.*;
import java.util.*;

public class Main {

    private static int K, N;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N];

        choose(0);
    }

    private static void choose(int index) {

        if (index >= N) {
            print();
            return;
        }

        for (int i = 1; i <= K; ++i) {
            arr[index] = i;
            choose(index + 1);
        }
    }

    private static void print() {
        for (int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}