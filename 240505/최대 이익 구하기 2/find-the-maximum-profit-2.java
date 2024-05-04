import java.io.*;
import java.util.*;

public class Main {

    static class Schedule {
        public int t;
        public int p;

        public Schedule(int t, int p) {
            this.t = t;
            this.p = p;
        }
    }

    private static int N, T, P;
    private static Schedule[] schedules;
    private static int result = Integer.MIN_VALUE;

    private static List<Integer> selected = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        schedules = new Schedule[N];
        
        StringTokenizer st;
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            schedules[i] = new Schedule(t, p);
        }

        // 시작일
        backtracking(1);

        System.out.println(result);
        
    }

    private static void backtracking(int select) {
        
        if (select > N) {
            result();
            return;
        }

        selected.add(0);
        backtracking(select + 1);
        selected.remove(selected.size() - 1);

        selected.add(1);
        backtracking(select + 1);
        selected.remove(selected.size() - 1);
    }

    private static void result() {
        
        int sumP = 0;

        int lookup = 0;

        for (int i = 0; i < N; ++i) {
            if (selected.get(i) == 0) continue;

            if (lookup == -1) {
                lookup = i + schedules[i].t;
            } else {
                if (i < lookup) return;
                lookup = i + schedules[i].t;
            }
            int p = schedules[i].p;
            sumP += p;
        }
        // System.out.println(selected);
        // System.out.println(sumP);
        if (lookup <= N) {
            result = Math.max(result, sumP);
        }
    }
 
}