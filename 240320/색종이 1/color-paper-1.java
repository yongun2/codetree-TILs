import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        final int[][] area = new int[91][91];
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int j = x; j < x + 10; ++j) {
                for (int k = y; k < y + 10; ++k) {
                    area[k][j] += 1;
                }
            }
        }

        int result = 0;
        for (int i = 0; i < 91; ++i) {
            for (int j = 0; j < 91; ++j) {
                if (area[i][j] != 0) result++;
            }
        }

        System.out.println(result);


    }
}