import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] bottles = new int[3][2];

        for (int i = 0; i < 3; ++i) {
            bottles[i] = Arrays.stream(br.readLine().split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray();
        }

        for(int i = 0; i < 100; ++i) {
            int cur = i % 3;
            int next = (i + 1) % 3;
            int amount = bottles[cur][1] + bottles[next][1];
            if (amount > bottles[next][0]) {
                bottles[next][1] = bottles[next][0];
                bottles[cur][1] = amount - bottles[next][0];
            } else {
                bottles[next][1] = amount;
                bottles[cur][1] = 0;
            }
                
            
        }
        
        for (int i = 0 ; i < 3; ++i) {
            System.out.println(bottles[i][1]);
        }

    }
}