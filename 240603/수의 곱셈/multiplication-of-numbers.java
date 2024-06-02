import java.io.*;
import java.util.*;

public class Main {

    private static int[] arrays = new int[3];
    private static boolean[] visited = new boolean[3];

    private static List<Integer> lookup = new ArrayList<>();
    private static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; ++i) {
            arrays[i] = Integer.parseInt(st.nextToken());
        }

        
        for (int i = 1; i <= arrays.length; ++i) {
            combine(0, i);    
        }
        
        System.out.println(result);

    }

    public static void combine(int start, int r) {
        if (r == 0) {
            print();
            return;
        }

        for (int i = start; i <= arrays.length - r; i++) {
            visited[i] = true;
            combine(i+1, r-1);
            visited[i] = false;
        }
    }

    static void print() {
        int mulValue = 1;
        for(int i = 0; i < arrays.length; i++) {
            if(visited[i] == true) {
                mulValue *= arrays[i];
                // System.out.print(arrays[i] + " ");
            }
        }
        // System.out.println();


        // System.out.println(mulValue);
        
        if (result == - 1) {
            result = mulValue;
            return;
        }

        // 우선순위
        // 홀수 > 짝수
        if (mulValue % 2 != 0 && result % 2 == 0) {
            result = mulValue;
            return;
        }

        if (mulValue % 2 == 0 && result % 2 == 0) {
            if (mulValue > result) result = mulValue;
        }

        if (mulValue % 2 != 0 && result % 2 != 0) {
            if (mulValue > result) result = mulValue;
        }
        

    }



}