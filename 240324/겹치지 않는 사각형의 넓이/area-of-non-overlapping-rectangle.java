import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] area = new int[2001][2001];
        final int offset = 1000;

        StringTokenizer st;
        for (int i = 0; i < 3; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken()) + offset;
            int y1 = Integer.parseInt(st.nextToken()) + offset;
            int x2 = Integer.parseInt(st.nextToken()) + offset;
            int y2 = Integer.parseInt(st.nextToken()) + offset;
            
            if (i < 2) {
                for (int j = y1; j < y2; ++j) {
                    for (int k = x1; k < x2; ++k) {
                        area[j][k] = 1;
                    }
                }
            } else {
                for (int j = y1; j < y2; ++j) {
                    for (int k = x1; k < x2; ++k) {
                        area[j][k] -= 1;
                    }
                }
            }
        }
        int result = 0;
        for (int i = 0; i < 2001; ++i) {
            for (int j = 0; j < 2001; ++j) {
                if (area[i][j] == 1) result++;
            }
        }

        System.out.println(result);
    }
}