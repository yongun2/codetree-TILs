import java.io.*;
import java.util.*;

public class Main {
    
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; ++i) {
            if (i == N && N % 2 != 0) {
                bw.write("3 ");
                // System.out.print("3 ");
                break;
            }
            bw.write(i % 2 == 0 ? "2 " : "1 ");
            // System.out.print(i % 2 == 0 ? "2 " : "1 ");
        }
        bw.flush();
        bw.close();
        

    }
}