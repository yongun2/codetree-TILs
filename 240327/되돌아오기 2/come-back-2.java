import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String queries = br.readLine();

        int curX = 0;
        int curY = 0;

        int[] dx = new int[] {0, 1, 0, -1};
        int[] dy = new int[] {-1, 0, 1, 0};
        int dIndex = 0;

        int result = -1;
        int time = 0;
        for (int i = 0; i < queries.length(); ++i) {
            char query = queries.charAt(i);
            
            switch (query) {
                case 'F':
                    curX += dx[dIndex];
                    curY += dy[dIndex];
                    time+=1;
                    break;
                case 'R':
                    dIndex = (dIndex + 1) % 4;
                    time+=1;
                    break;
                case 'L':
                    dIndex = (dIndex + 3) % 4;
                    time+=1;
                    break;
            }
        
            if (curX == 0 && curY == 0) {
                result = time;
                break;
            }
        }

        System.out.println(result);
    }
}