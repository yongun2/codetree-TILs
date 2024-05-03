import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());

        System.out.println(backtracking(N));
    }

    private static int backtracking(int n) {

        if (n == 0) return 0;

        if (n == 1) return 1;

        return backtracking(n-1) + backtracking(n-2);
    }


}