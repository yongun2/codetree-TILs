import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());
        final int offset = 100;
        int[][] area = new int[201][201];

        StringTokenizer st;
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken()) + offset;
            int y1 = Integer.parseInt(st.nextToken()) + offset;
            int x2 = Integer.parseInt(st.nextToken()) + offset;
            int y2 = Integer.parseInt(st.nextToken()) + offset;

            for (int j = y1; j < y2; ++j) {
                for (int k=x1; k < x2; ++k) {
                    area[j][k] = 1;
                }
            }
        }
        int result = 0;
        for (int i = 0; i < 201; ++i) {
            for (int j = 0; j < 201; ++j) {
                if (area[i][j] != 0) result++;
            }
        }
        System.out.println(result);

    }
}