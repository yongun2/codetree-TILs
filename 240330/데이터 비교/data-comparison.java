import java.io.*;
import java.util.*;

public class Main {

    public static int N;
    public static Set<Integer> A = new HashSet<>();
    public static int[] arrayB;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; ++i) {
            A.add(Integer.parseInt(st.nextToken()));
        }

        N = Integer.parseInt(br.readLine());
        arrayB = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; ++i) {
            arrayB[i] = Integer.parseInt(st.nextToken());
        }

        for (Integer number: arrayB) {
            if (A.contains(number)) System.out.print(1 + " ");
            else System.out.print(0 + " ");
        }
    }
}