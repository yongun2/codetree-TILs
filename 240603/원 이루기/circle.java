import java.io.*;
import java.util.*;

public class Main {
    
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        
        N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; ++i) {
            if (i == N && N % 2 != 0) {
                System.out.print("3 ");
                break;
            }
            System.out.print(i % 2 == 0 ? "2 " : "1 ");
        }
        

    }
}