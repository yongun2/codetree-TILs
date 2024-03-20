import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());
        int[][] area = new int[511][511];

        StringTokenizer st;
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int j = y; j < y + 10; ++j) {
                for (int k = x; k < x + 10; ++k) {
                    area[j][k] = 1;
                }
            }
        }

        int result = 0;
        int[] y = new int[] {1, -1, 0 , 0};
        int[] x = new int[] {0, 0, 1, -1};
        for (int i = 0; i < 511; ++i) {
            for (int j = 0; j < 511; ++j) {
                if (area[i][j] == 1) {
                    int count = 0;
                    for (int k = 0; k < 4; ++k) {
                        int dx = x[k] + j; 
                        int dy = y[k] + i;
                        if (dx < 0 || dx >= 511 || dy < 0 || dy >= 511) continue;
                        if (area[dy][dx] == 1) count += 1;
                    }
                    if (count == 3) {
                        result += 1;
                    } else if (count == 2) {
                        result += 2;
                    }   
                }
                
            }
            
        }
        System.out.println(result);
    }
}