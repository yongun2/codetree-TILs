import java.io.*;
import java.util.*;

public class Main {
    
    private static int N, K;

    private static List<Integer> lookup = new ArrayList<>();
    private static StringBuilder result = new StringBuilder();
    private static int index = 1;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        backtracking(0);

        bw.write(result.length() == 0 ? String.valueOf(-1) : result.toString());
        bw.flush();
        bw.close();

    }

    private static void backtracking(int sum) {
        
        if (sum > N) {
            return;
        }

        if (sum == N) {
            if (index == K){
                result();
            }
            index++;
            return;
        }

        for (int i = 1; i<=3; ++i) {
            lookup.add(i);
            backtracking(i + sum);
            lookup.remove(lookup.size() - 1);
        }


    }

    private static void result() {
        
        for (int i = 0; i < lookup.size(); ++i) {
            result.append(lookup.get(i));
            if (i != lookup.size() - 1) {
                result.append("+");
            }
        }
        
        
        
    }
}