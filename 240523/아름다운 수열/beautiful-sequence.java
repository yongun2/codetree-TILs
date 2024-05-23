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

        for (int i = lookup.size(); i < A.length; ++i) {
            lookup.remove(0);
            lookup.add(A[i]);
            if (isPerfect(lookup)) {
                K++;
                kIndex.add(i - lookup.size() + 2);
            }
        }
        System.out.println(K);
        kIndex.stream()
                .forEach(System.out::println);
                
    }

    private static boolean isPerfect(List<Integer> j) {
        
        List<Integer> target = j.stream()
                                    .sorted()
                                    .collect(Collectors.toList());
        int diff = Math.abs(target.get(0) - B[0]);
        boolean isPerfect = true;
        for (int i = 1; i < target.size(); ++i) {
            if (diff != Math.abs(target.get(i) - B[i])) {
                isPerfect = false;
                break;
            }
        }
        // System.out.println(target);
        // System.out.println(Arrays.toString(B));
        // System.out.println(isPerfect);
        return isPerfect;
    }
}