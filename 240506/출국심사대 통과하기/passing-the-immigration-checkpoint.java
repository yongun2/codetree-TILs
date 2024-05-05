import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int[] timeline;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        peoples = new People[N];

        timeline = new int[15];

        StringTokenizer st;
        for (int i = 0; i < N; ++i){
            st = new StringTokenizer(br.readLine(), " ");
            int at = Integer.parseInt(st.nextToken());
            int rt = Integer.parseInt(st.nextToken());

            for (int j = at; j <=at+rt; ++j) {
                timeline[j] += 1;
            }
        }

        int result = 0;
        for (int i = 0; i < timeline.length; ++i) {
            result += timeline[i];
        } 

        System.out.println(result + 1);


    }
}