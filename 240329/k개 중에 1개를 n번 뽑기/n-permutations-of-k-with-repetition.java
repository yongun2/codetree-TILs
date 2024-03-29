import java.io.*;
import java.util.*;

public class Main {
    
    public static int K, N;

    public static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        choose(1);
    }

    public static void choose(int n) {
        if (n == N + 1) {
            print();
            return;
        }

        for (int i = 1; i <= N; ++i) {
            list.add(i);
            choose(n+1);
            list.remove(list.size() - 1);
        }
    }

    public static void print() {
        for (Integer number: list) {
            System.out.printf("%d ", number);
        }
        System.out.println();
    }
}