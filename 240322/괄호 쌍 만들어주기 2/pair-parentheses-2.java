import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        int result = 0;
        // 존나 개빡코드 O(n^4)
        // stack 사용해서 줄이기
        for (int i = 0; i < input.length() - 1; ++i) {
            for (int j = i+1; j < input.length() - 1; ++j) {
                if (input.charAt(i) == '(' && input.charAt(i+1) == '('
                    && input.charAt(j) == ')' && input.charAt(j+1) == ')'
                ) result++;
            }
        }
        System.out.println(result);
    }
}