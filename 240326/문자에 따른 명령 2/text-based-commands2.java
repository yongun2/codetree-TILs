import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] dx = new int[] {0, 1, 0, -1};
        int[] dy = new int[] {1, 0, -1, 0};

        int curX = 0;
        int curY = 0;

        int curDirection = 0;

        String queries = br.readLine();

        for (int i = 0; i < queries.length(); ++i) {
            char query = queries.charAt(i);

            switch (query) {
                case 'L':
                    curDirection = (3 + curDirection) % 4;
                    break;
                case 'R':
                    curDirection = (curDirection + 1) % 4;
                    break;
                case 'F':
                    curX += 1 * dx[curDirection];
                    curY += 1 * dy[curDirection];
                    break;
            }
        }
        System.out.printf("%d %d\n", curX, curY);

    }
}