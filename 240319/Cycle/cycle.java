import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray();
        int N = inputs[0];
        int P = inputs[1];

        int cycleCount = 0;
        int cur = N;
        
        Set<Integer> lookup = new HashSet<Integer>();
        while(true) {
            cur *= N;
            cur %= P;
            if (lookup.contains(cur)) break;
            lookup.add(cur);
            cycleCount++;
        }
        System.out.println(cycleCount);

    }
}