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
        for (int i = 2; i <= N; ++i) {
            choose(0, i);
        }
        
        System.out.println(result);
    }

    private static void choose(int index, int choiceCount) {
        if (index >= choiceCount) {
            // System.out.println(Arrays.toString(choices));
            result();
            return;
        }

        for (int i = 1; i <= N; ++i) {
            if (current.contains(i)) continue;
            current.add(i);
            choices[index] = i;
            choose(index + 1, choiceCount);
            current.remove(choices[index]);
        }
    }

    private static void result() {
        int[] line = new int[1001];
        // int[] line = new int[12];
        
        int count = 0;
        for (int choice: choices) {
            if (choice == 0) continue;
            count += 1;
            Pair pair = lines.get(choice - 1);
            for (int i = pair.start; i <= pair.end; ++i) {
                line[i] += 1;
            }
        }
    
        for (int i = 0; i < line.length; ++i) {
            if (line[i] >= 2) return;
        }

        result = Math.max(result, count);
    }   
}