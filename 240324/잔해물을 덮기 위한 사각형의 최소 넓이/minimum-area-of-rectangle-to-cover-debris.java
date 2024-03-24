import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int offset = 1000;
        int[] rectangle = new int[4];
        int[][] area = new int[2001][2001];

        StringTokenizer st;
        for (int i = 0; i < 2; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken()) + offset;
            int y1 = Integer.parseInt(st.nextToken()) + offset;
            int x2 = Integer.parseInt(st.nextToken()) + offset;
            int y2 = Integer.parseInt(st.nextToken()) + offset;

            if (i == 0) {
                rectangle[0] = x1;
                rectangle[1] = y1;
                rectangle[2] = x2;
                rectangle[3] = y2;

                for (int j = y1; j < y2; ++j) {
                    for (int k = x1; k < x2; ++k) {
                        area[j][k] = 1;
                    }
                }
            } else {
                for (int j = y1; j < y2; ++j) {
                    for (int k = x1; k < x2; ++k) {
                        area[j][k] = 0;
                    }
                }
            }
        }
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        for (int i = rectangle[1]; i < rectangle[3]; ++i) {
            for (int j = rectangle[0]; j < rectangle[2]; ++j) {
                if (area[i][j] != 0) {
                    maxX = Math.max(maxX, j);
                    maxY = Math.max(maxY, i);
                }
                // System.out.printf("%2d ", area[i][j]);
            }
            // System.out.println();

        }

        // System.out.printf("maxX = %d maxY = %d\n", maxX, maxY);

        System.out.println((maxY - rectangle[1] + 1) * (maxX - rectangle[0] + 1));
    }
}