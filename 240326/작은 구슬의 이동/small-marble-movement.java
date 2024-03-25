import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        final int N = Integer.parseInt(st.nextToken());
        final int T = Integer.parseInt(st.nextToken());

        int[][] grid = new int[N+1][N+1];

        st = new StringTokenizer(br.readLine(), " ");
        int curY = Integer.parseInt(st.nextToken());
        int curX = Integer.parseInt(st.nextToken());
        char direction = st.nextToken().charAt(0);

        int[] dx = new int[] {0, 1, 0, -1};
        int[] dy = new int[] {1, 0, -1, 0};
        int curDirection;

        switch(direction) {
            case 'L':
                curDirection = 3;
                break;
            case 'R':
                curDirection = 1;
                break;
            case 'D':
                curDirection = 2;
                break;
            case 'U':
                curDirection = 0;
                break; 
            default:
                curDirection = -1;
                break;
        }
        

        for (int i = 0; i < T; ++i) {
            
            int x = dx[curDirection];
            int y = dy[curDirection];

            curX += x;
            curY += y;

            if (!inRange(curX, curY, N)) {
                // 방향 전환
                curX -= x;
                curY -= y;
                curDirection = (curDirection + 2) % 4;
                continue;
            }
        }
       
        System.out.printf("%d %d\n", curY, curX);
    }

    private static boolean inRange(int x, int y, int N) {
        return x >= 1 && x <= N && y >= 1 && y <= N;
    }
}