import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());

        int checkPoints[][] = new int[N][2];
        StringTokenizer st;
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            checkPoints[i][0] = Integer.parseInt(st.nextToken());
            checkPoints[i][1] = Integer.parseInt(st.nextToken());
        }
        int result = Integer.MAX_VALUE;
        for (int i = 1; i < N - 1; ++i) {
            int curX = checkPoints[0][0];
            int curY = checkPoints[0][1];
            int totalDistance = 0;

            for (int j = 1; j < N; ++j) {
                if (j == i) continue;
                int dx = Math.abs(curX - checkPoints[j][0]);
                int dy = Math.abs(curY - checkPoints[j][1]);
                totalDistance +=  dx + dy;
                curX = checkPoints[j][0];
                curY = checkPoints[j][1];
            }
            
            result = Math.min(result, totalDistance);
        }
        System.out.println(result);
    }
}