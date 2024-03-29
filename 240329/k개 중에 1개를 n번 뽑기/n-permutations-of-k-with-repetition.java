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

        choose(0);
    }

    public static void choose(int n) {
        if (n == N) {
            print();
            return;
        }

        for (int i = 1; i <= K; ++i) {
            list.add(i);
            choose(n+1);
            list.remove(list.size() - 1);
        }
    }

    public static void print() {
        for (int i = 0; i < list.size(); ++i) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
}