import java.io.*;
import java.util.*;

public class Main {

    
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder a = new StringBuilder(br.readLine());

        int result = Integer.MIN_VALUE;    
        for (int i = 0; i < a.length(); ++i) {
            char before = a.charAt(i);
            char next = a.charAt(i) == '1' ? '0' : '1';
            a.setCharAt(i, next);
            result = Math.max(result, toDecimal(a.toString())); 
            a.setCharAt(i, before);
        }
        System.out.println(result);
    }

    public static int toDecimal(String binary) {
        int result = 0;
        for (int i = 0; i < binary.length(); ++i) {
            result += Character.getNumericValue(binary.charAt((binary.length() - 1) - i)) * (int)Math.pow(2, i);
        }
        return result;
    }   
}