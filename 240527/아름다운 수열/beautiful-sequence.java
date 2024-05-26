import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    private static int N,M;
    private static int[] A, B;
    private static List<Integer> lookup = new LinkedList<>();

    private static int K = 0;
    private static List<Integer> kIndex = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        A = new int[N];

        for (int i = 0; i < N; ++i) {
            A[i] = Integer.parseInt(br.readLine().trim());
        }

        M = Integer.parseInt(br.readLine());
        B = new int[M];
        for (int i = 0; i < M; ++i) {
            B[i] = Integer.parseInt(br.readLine().trim());
        }

        Arrays.sort(B);

        for (int i = 0; i < M; ++i) {
            lookup.add(A[i]);
        }

        if (isPerfectSequences(lookup)) {
            K++;
            kIndex.add(0);
        }

        for (int i = M; i < N; ++i) {
            lookup.remove(0);
            lookup.add(A[i]);

            
            if (isPerfectSequences(lookup)) {
                K++;
                kIndex.add(i - M + 2);
            }
            

        }

        System.out.println(K);
        kIndex.stream()
                .forEach(System.out::println);

    }

    private static boolean isPerfectSequences(List<Integer> lookup) {
        // System.out.printf("B: %s lookup: %s\n", Arrays.toString(B), lookup);
        lookup = lookup.stream()
                        .sorted()
                        .collect(Collectors.toList());
        
        int diff = lookup.get(0) - B[0];
        
        if (diff >= 0) {
            for (int i = 1; i < M; ++i) {
                if (lookup.get(i) - diff != B[i]) return false;
            }
        } else {
            for (int i = 1; i < M; ++i) {
                if (B[i] + diff != lookup.get(i)) return false;
            }
        }

        return true;

        // 30 35
        // 11 54

        
        
    }
}