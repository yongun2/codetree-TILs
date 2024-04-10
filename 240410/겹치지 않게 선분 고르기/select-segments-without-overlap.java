import java.io.*;
import java.util.*;

public class Main {

    static class Pair {
        public int start;
        public int end;
        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private static int N;
    private static int[] choices;
    private static int result = 1;
    // private static int[] lookup = new int[1001];
    private static List<Pair> lines = new ArrayList<>();
    private static Set<Integer> current = new HashSet<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        // N이 1이면 최대값은 1
        if (N == 1) {
            System.out.println(1);
            return;
        }

        choices = new int[N];

        StringTokenizer st;
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            lines.add(new Pair(Integer.parseInt(st.nextToken()),
                                 Integer.parseInt(st.nextToken())
                                )
                        );
        }
        choose(0);
        // for (int i = 2; i <= N; ++i) {
        //     choose(0, i);
        // }
        
        System.out.println(result);
    }

    private static void choose(int index) {
        if (index >= N) {
            // System.out.println(Arrays.toString(choices));
            result();
            return;
        }

        choices[index] = 0;
        choose(index + 1);
        
        choices[index] = 1;
        choose(index + 1);
        
    }

    private static void result() {
        int[] lookup = new int[1001];
        int count = 0;
        for (int i = 0; i < choices.length; ++i) {
            if (choices[i] == 0) continue;
            count += 1;
            Pair pair = lines.get(i);
            for (int j = pair.start; j <= pair.end; ++j) {
                lookup[j] += 1;
            }
        }
    
        for (int i = 0; i < lookup.length; ++i) {
            if (lookup[i] >= 2) return;
        }
        result = Math.max(result, count);
    }  

    
}