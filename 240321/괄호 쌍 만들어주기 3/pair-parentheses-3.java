import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int result = 0;
        for(int i = 0; i < input.length() - 1; ++i) {
            if (input.charAt(i) == ')') continue;
            
            for(int j = i+1; j < input.length(); ++j) {
                if (input.charAt(j) == ')') result++;
            }
        }

        System.out.println(result);
    }
}