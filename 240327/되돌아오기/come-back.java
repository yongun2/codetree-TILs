import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        
        int[] dx = new int[] {0, 1, 0, - 1};
        int[] dy = new int[] {-1, 0 , 1, 0};
        int dIndex = 0;

        int curX = 0;
        int curY = 0;

        int result = -1;
        int time = 0;

        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            char direction = st.nextToken().charAt(0);
            int length = Integer.parseInt(st.nextToken());

            switch (direction) {
                case 'N':
                    dIndex = 0;
                    break;
                case 'E':
                    dIndex = 1;
                    break;
                case 'S':
                    dIndex = 2;
                    break;
                case 'W':
                    dIndex = 3;
                    break;
            }

            for (int j = 0; j < length; ++j) {
                curY += dy[dIndex] * 1;
                curX += dx[dIndex] * 1;
                time += 1;
                if (curX == 0 && curY == 0) {
                    result = time;
                }
            }
            if (result != -1) break;
            
            
        }

        System.out.println(result);

    }
}