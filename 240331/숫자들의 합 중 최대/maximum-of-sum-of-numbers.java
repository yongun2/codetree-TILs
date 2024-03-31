import java.io.*;
import java.util.*;

public class Main {
    public static String X, Y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        X = st.nextToken();
        Y = st.nextToken();

        int start = Integer.parseInt(X);
        int end = Integer.parseInt(Y);
        int result = Integer.MIN_VALUE;
        while (start <= end) {
            String val = String.valueOf(start);
            int sum = 0;
            for (int i = 0; i < val.length(); ++i) {
                sum += Character.getNumericValue(val.charAt(i));
            }

            result = Math.max(result, sum);
            start += 1;
        }

        System.out.println(result);
    }
}