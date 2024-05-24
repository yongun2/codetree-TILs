import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    private static int N, M;
    private static int[] A, B;
    private static int K = 0;
    
    private static List<Integer> lookup = new LinkedList<>();
    private static List<Integer> kIndex = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        for (int i = 0; i < N; ++i) {
            A[i] = Integer.parseInt(br.readLine().trim());;
        }

        M = Integer.parseInt(br.readLine());
        B = new int[M];
        for (int i = 0; i < M; ++i) {
            B[i] = Integer.parseInt(br.readLine().trim());
        }

        for (int i = 0; i < M; ++i) {
            lookup.add(A[i]);
        }

        Arrays.sort(B);

        
        if (isPerfect(lookup)) {
            K ++;
            kIndex.add(0);
        }

        // System.out.println(Arrays.toString(B));
        for (int i = M; i < A.length; ++i) {
            lookup.remove(0);
            lookup.add(A[i]);
            if (isPerfect(lookup)) {
                K++;
                kIndex.add(i - M + 2);
            }
        }
        System.out.println(K);
        kIndex.stream()
                .forEach(System.out::println);
                
        // 9 7 10
        // 4 6 7
    }

    private static boolean isPerfect(List<Integer> j) {
        
        List<Integer> target = j.stream()
                                    .sorted()
                                    .collect(Collectors.toList());
        int diff = Math.abs(target.get(0) - B[0]);
        
        boolean isPerfectA = true;
        for (int i = 1; i < target.size(); ++i) {
            if (target.get(i) + diff != B[i]) {
                isPerfectA = false;
                break;
            }
        }

        boolean isPerfectB = true;
        for (int i = 1; i < target.size(); ++i) {
            if (target.get(i) - diff != B[i]) {
                isPerfectB = false;
                break;
            }
        }

        
        return isPerfectA || isPerfectB;
        
    }
}