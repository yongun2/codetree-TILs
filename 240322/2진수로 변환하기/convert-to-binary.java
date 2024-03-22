import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder result = new StringBuilder();

        while (N != 0) {
            if (N % 2 == 0) result.append("0");
            else result.append("1");
            N /= 2;
        }

        System.out.println(result.reverse().toString());
    }
}