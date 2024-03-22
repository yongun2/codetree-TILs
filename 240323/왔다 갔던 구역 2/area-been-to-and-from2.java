import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());
        int[] area = new int[201];
        

        StringTokenizer st;
        int curIndex = 100;
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            String way = st.nextToken();

            if (way.equals("R")) {
                for (int j = 0; j < x; ++j) {
                    area[curIndex++] += 1;
                }
                
            } else {
                for (int j = 0; j < x; ++j) {
                    area[curIndex--] += 1;
                }
            }
        }

        int result = 0;
        for (int i = 0; i < area.length; ++i) {
            if (area[i] >= 2) result+=1;
        }

        System.out.println(result);
    }
}