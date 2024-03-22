import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String binary = br.readLine();

        // to decimal
        int decimal = 0;
        for (int i = 0; i < binary.length(); ++i) {
            decimal += Character.getNumericValue(binary.charAt(i)) * Math.pow(2, binary.length() - 1 - i);
        }

        decimal *= 17;
        StringBuilder result = new StringBuilder();
        while (decimal != 0) {
            if (decimal % 2 == 0) result.append("0");
            else result.append("1");
            decimal /= 2;
        }

        System.out.println(result.reverse().toString());
    }
}