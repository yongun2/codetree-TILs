import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int[] inputs;
    private static Set<Integer> lookup = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        inputs = new int[N];

        for (int i = 0; i < N; ++i) {
            int val = Integer.parseInt(br.readLine());
            inputs[i] = val;
            lookup.add(val);
        }

        Iterator iterator = lookup.iterator();

        int result = Integer.MIN_VALUE;
        while (iterator.hasNext()) {
            int val = (int) iterator.next();

            int prev = inputs[0];
            int count = 0;
            for (int i = 1; i < N; ++i) {
                if (inputs[i] == val) continue;

                if (prev == inputs[i]) count++;
                else {
                    result = Math.max(result, count + 1);
                    prev = inputs[i];
                    count = 0;
                }
            }
            result = Math.max(result, count + 1);
        }

        System.out.println(result == Integer.MIN_VALUE ? 0 : result);
    }
}