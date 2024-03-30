import java.io.*;
import java.util.*;

public class Main {

    public static int N;
    public static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; ++i) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        System.out.println(set.size());
    }
}