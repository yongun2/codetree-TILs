import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());

        // int[] dx = new int[] {1, 0, -1, 0};
        // int[] dy = new int[] {0, -1, 0, 1};

        int curX = 0;
        int curY = 0;

        StringTokenizer st;
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            char direction = st.nextToken().charAt(0);
            int distance = Integer.parseInt(st.nextToken());

            switch (direction) {
                case 'N':
                    curY += distance;
                    break;
                case 'E':
                    curX += distance;
                    break;
                case 'S':
                    curY -= distance;
                    break;
                case 'W':
                    curX -= distance;
                    break;
            }
        }
        System.out.printf("%d %d\n", curX, curY);
    }
}