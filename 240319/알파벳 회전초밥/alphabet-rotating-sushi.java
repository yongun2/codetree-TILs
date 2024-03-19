import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String A = br.readLine();
        final String B = br.readLine();
        Map<Character, Integer> lookup = new HashMap<>();

        for(int i = 0; i < A.length(); ++i) {
            lookup.put(A.charAt(i), i);   
        }

    
        int top = -1;
        int[] stack = new int[1001];
        int result = 0;
        for (int i = 0; i < B.length(); ++i) {
            if (top == -1) {
                stack[++top] = lookup.get(B.charAt(i));
                result++;
            } else {
                int cmpIndex = stack[top];
                int currentCharIndex = lookup.get(B.charAt(i));

                if (currentCharIndex <= cmpIndex) {
                    result++;
                }
                stack[++top] = currentCharIndex;
            }
        }
    
        System.out.println(result);
    }
}