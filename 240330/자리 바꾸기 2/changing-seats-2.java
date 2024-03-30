import java.io.*;
import java.util.*;

public class Main {

    public static int N, K;
    public static Set<Integer>[] seatInfo;
    public static int[] seats;

    public static int[][] info;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        seatInfo = new HashSet[N];
        seats = new int[N];

        info = new int[K][2];

        for (int i = 0; i < N; ++i) {
            seats[i] = i;
            seatInfo[i] = new HashSet<>();
            seatInfo[i].add(i);
        }
        
        for (int i = 0; i < K; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            info[i][0] = Integer.parseInt(st.nextToken());
            info[i][1] = Integer.parseInt(st.nextToken());
        }
        
        for (int i = 0; i < 3 * K; ++i) {
            int ai = info[i % K][0] - 1;
            int bi = info[i % K][1] - 1;
        
            seatInfo[seats[ai]].add(bi);
            seatInfo[seats[bi]].add(ai);

            int tmp = seats[ai];
            seats[ai] = seats[bi];
            seats[bi] = tmp;

            
        }

        for (int i = 0; i < seatInfo.length; ++i) {
            System.out.println(seatInfo[i].size());
        }

    
    }
}