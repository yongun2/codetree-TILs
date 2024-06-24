import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static String[][] grid;

    private static StringBuilder sb = new StringBuilder();

    private static int min = Integer.MAX_VALUE;
    private static int max = Integer.MIN_VALUE;

    private static int[] dx = {1, 0};
    private static int[] dy = {0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        grid = new String[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; ++j) {
                grid[i][j] = st.nextToken();
            }
        }

        backtracking(0, 0);

        bw.write(String.valueOf(max) + " ");
        bw.write(String.valueOf(min));
        bw.flush();
        bw.close();
    }

    private static void backtracking(int x, int y) {

        sb.append(grid[y][x]);

        if (x == N - 1 && y == N - 1) {
            result();
            return;
        }

        

        for (int i = 0; i < 2; ++i) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (inRange(nx, ny)) {
                backtracking(nx, ny);
                sb.delete(sb.length()-1, sb.length());
            }
        }
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    private static void result() {

        int result = Integer.parseInt(String.valueOf(sb.charAt(0)));
        char op = 0;
        for (int i = 1; i < sb.length(); ++i) {
            char cur = sb.charAt(i);
            if (i % 2 == 0) {
                switch (op) {
                    case '+':
                        result += Integer.parseInt(String.valueOf(cur));
                        break;
                    case '-' :
                        result -= Integer.parseInt(String.valueOf(cur));
                        break;
                    case 'x' :
                        result *= Integer.parseInt(String.valueOf(cur));
                        break;
                }
            } else {
                op = cur;
            }
        }
        
        if (result > max) {
            max = result;
        }

        if (result < min) {
            min = result;
        }
    }
}