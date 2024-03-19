import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray();
        final int N = inputs[0];
        final int P = inputs[1];

        int cycleCount = 0;
        int cur = N;
        
        List<Integer> lookupArray = new ArrayList();
        Set<Integer> lookupSet = new HashSet();
        while(true) {
            cur *= N;
            cur %= P;
            
            if (lookupSet.contains(cur)) break;
            lookupSet.add(cur);
            lookupArray.add(cur);
            cycleCount++;
        }
        System.out.println(cycleCount - (lookupArray.indexOf(cur) + 1) + 1);

    }
}