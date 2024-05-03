import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int result = 0;

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        backtracking(0, 0);
        System.out.println(result);
    }

    private static void backtracking(int curNum, int sum) {
        if (sum > N) return;

        if (sum == N) {
            result += 1;
            return;
        }

        for (int i = 1; i <= 3; ++i) {
            backtracking(i, sum + i);
        }


    }
}