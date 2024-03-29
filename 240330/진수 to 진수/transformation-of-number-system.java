import java.io.*;
import java.util.*;

public class Main {
    
    public static int A, B;
    public static String N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        N = br.readLine();

        int decimal = toDecimal();

        StringBuilder result = new StringBuilder();
        while (decimal != 0) {
            if (decimal % B != 0) result.append(decimal % B);
            else result.append(0) ;
            decimal /= B;
        }

        System.out.println(result.reverse().toString());
    }

    public static int toDecimal() {
        int result = 0;
        for (int i = 0; i < N.length(); ++i) {
            result += Character.getNumericValue(N.charAt(i)) * Math.pow(A, N.length() - 1 - i);
        }
        return result;
        
    }
}