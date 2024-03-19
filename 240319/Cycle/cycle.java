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

        cur *= N;
        cur %= P;
        cycleCount++;
        int first = cur;
        while(true) {
            cur *= N;
            cur %= P;
            if (cur == first) break;
            cycleCount++;
        }
        System.out.println(cycleCount);

    }
}