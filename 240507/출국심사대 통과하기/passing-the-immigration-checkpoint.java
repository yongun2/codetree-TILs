import java.io.*;
import java.util.*;

public class Main {

    static class People {
        public int arrivalTime;
        public int reviewTime;

        public People(int at, int rt){
            arrivalTime = at;
            reviewTime = rt;
        }

        public int getArrivalTime() {
            return arrivalTime;
        }

        public String toString() {
            return "arrivalTime = " + arrivalTime + " reviewTime = " + reviewTime;
        }
    }

    private static int N;
    private static int[] timeline;
    private static People[] peoples;

    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        timeline = new int[2_000_002];
        peoples = new People[N];

        StringTokenizer st;
        for (int i = 0; i < N; ++i){
            st = new StringTokenizer(br.readLine(), " ");
            int at = Integer.parseInt(st.nextToken());
            int rt = Integer.parseInt(st.nextToken());

            peoples[i] = new People(at, rt);
        }

        peoples = Arrays.stream(peoples)
                .sorted(Comparator.comparing(People::getArrivalTime))
                .toArray(People[]::new);

        int time = 0;
        for (People p: peoples) {
            int at = p.arrivalTime;
            int rt = p.reviewTime;

            if (time < at) time = at;
            time += rt;
        }
        System.out.println(time);
                

    }
}