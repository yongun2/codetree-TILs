import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        final int N = Integer.parseInt(st.nextToken());
        final int T = Integer.parseInt(st.nextToken());

        int[][] grid = new int[N][N];

        st = new StringTokenizer(br.readLine(), " ");
        int curY = Integer.parseInt(st.nextToken());
        int curX = Integer.parseInt(st.nextToken());
        char direction = st.nextToken().charAt(0);

        int[] dx = new int[] {0, 1, 0, -1};
        int[] dy = new int[] {1, 0, -1, 0};
        int curDirection;

        if (direction == 'L') {
            curDirection = 3;
        } else {
            curDirection = 1;
        }

        for (int i = 0; i <= T; ++i) {
            int x = dx[curDirection];
            int y = dy[curDirection];

            if (inRange(curX + x, curY + y, N)) {
                curX += x;
                curY += y;
            } 
            // 벽 넘어간 경우
            else {
                curX -= x;
                curY -= y;
                curDirection = (curDirection + 2) % 4;
            }
            
        }
       
        System.out.printf("%d %d\n", curY, curX);
    }

    private static boolean inRange(int x, int y, int N) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}