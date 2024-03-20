import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());

        
        Map<Integer, Integer> sequences = new HashMap<Integer, Integer>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; ++i) {
            sequences.put(Integer.parseInt(st.nextToken()) - 1, i);
        }

        Map<Integer, Integer> backward = new HashMap<Integer, Integer>();
        for (int i = 0; i < N; ++i) {
            backward.put(i, sequences.get(i));
        }

        int[] base = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; ++i) {
            base[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < 3; ++i) {
            // 섞기
            int[] next = new int[N];
            for (int j = 0; j < N; ++j) {
                int index = backward.get(j);
                next[index] = base[j];
            }

            // copy
            for (int j = 0; j < base.length; ++j) {
                base[j] = next[j];
            }
        
        }

        for(int num: base) {
            System.out.println(num);
        }

        
    }
}