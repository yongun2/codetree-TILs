import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String A = br.readLine();
        final String B = br.readLine();

        Set<Character> lookup = new HashSet<>();
        int start = 0;
        int result = 1;

        for (int i = 0; i < B.length(); ++i) {
            lookup.add(B.charAt(i));
        }
        
        for (int i = 0; i < A.length(); ++i) {
            if (!lookup.contains(A.charAt(i))) continue;

            if (A.charAt(i) == B.charAt(start)) {
                start++;
            } else {
                result++;
            }
            lookup.add(A.charAt(i));
        }
        System.out.println(result);
    }
}