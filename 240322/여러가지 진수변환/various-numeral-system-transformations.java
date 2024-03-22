import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        StringBuilder result = new StringBuilder();
        while(N != 0) {
            int rest = N % B;
            if (rest == 0) result.append("0");
            else result.append(rest);
            N /= B;
        }

        System.out.println(result.reverse().toString());
    }
}