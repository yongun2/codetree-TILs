import java.io.*;
import java.util.*;

public class Main {
    private static int R, C;
    private static char[][] grid;
    private static int result = 0;
    private static char[] pos = new char[] {'W', 'B', 'W', 'B'};

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        grid = new char[R][C];
        for (int i = 0; i < R; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < C; ++j) {
                grid[i][j] = st.nextToken().charAt(0);
            }
        }

        trace(0, 0, 0);

        System.out.println(result);


    }

    private static void trace(int y, int x, int step) {

        if (y >= R || x >= C) return;

        if (pos[step] != grid[y][x]) return;
        
        if (y == R-1 && x == C-1 && step == 3) {
            result++;
            return;
        }

        for (int i = 1; i < R; ++i) {
            for (int j = 1; j < C; ++j) {
                trace(y+i, x+j, step+1);
            }
        }
    }
}