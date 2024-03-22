import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int result = 0;
        String input = br.readLine();

        for(int i = 0; i < input.length(); ++i) {
            result += Character.getNumericValue(input.charAt(i)) * Math.pow(2, input.length() - 1 - i);
        }

        System.out.println(result);

    }
}