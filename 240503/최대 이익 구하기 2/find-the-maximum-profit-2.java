import java.io.*;
import java.util.*;

public class Main {

    private static int N, T, P;
    private static int[][] schedules;
    private static int result = Integer.MIN_VALUE;

    private static int end = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        schedules = new int[N+1][N+1];

        StringTokenizer st;
        for (int i = 1; i <= N; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            schedules[i][0] = Integer.parseInt(st.nextToken());
            schedules[i][1] = Integer.parseInt(st.nextToken());
        }

        // 시작일
        for (int i = 1; i <= N; ++i) {
            backtracking(i, 0);
        }

        System.out.println(result);
        
    }

    private static void backtracking(int curDate, int pay) {
        
        int curDateWorkTime = schedules[curDate][0];
        pay += schedules[curDate][1];

        if (curDate >= N) {
            result = Math.max(result, pay);
        }

        for (int i = curDate + 1; i <= N; ++i) {
            if (curDate + curDateWorkTime > i) continue;
            backtracking(i, pay);
        }
    }

}