import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        int result = 0;
        // 존나 개빡코드 O(n^4)
        for (int i = 0; i < input.length() - 3; ++i) {
            for (int j = i+1; j < input.length() - 2; ++j) {
                for (int k = j + 1; k < input.length() - 1; ++k) {
                    for (int l = k + 1; l < input.length(); ++l) {
                        if (j == i + 1 && l == k + 1) {
                            if (input.charAt(i) == '(' &&
                                input.charAt(j) == '(' &&
                                input.charAt(k) == ')' &&
                                input.charAt(l) == ')') result++;
                        }
                        
                    }
                }
            }
        }
        System.out.println(result);
    }
}