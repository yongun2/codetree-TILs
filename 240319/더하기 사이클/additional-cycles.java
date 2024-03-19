import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder str = new StringBuilder(br.readLine());

        int result = 0;
        String first = str.toString();
        do {
            // 1
            int case1;
            if (str.length() == 1) {
                case1 = Character.getNumericValue(str.charAt(0));
            } else {
                case1 = (Character.getNumericValue(str.charAt(0)) + Character.getNumericValue(str.charAt(1))) % 10;
            }

            // 2
            char ch = str.charAt(str.length() - 1);
            str.setLength(0);

            if (ch == '0') {
                str.append(case1);
            } else {
                str.append(ch);
                str.append(case1);
            }
            
            result++;

        } while(!first.equals(str.toString()));

        System.out.println(result);
    }
}