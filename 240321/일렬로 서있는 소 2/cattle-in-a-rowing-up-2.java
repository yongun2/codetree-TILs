import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());

        int[] inputs = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0 ; i < inputs.length; ++i) {
            inputs[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        for(int i = 0; i < inputs.length - 2; ++i) {
            for (int j = i + 1; j < inputs.length - 1; ++j) {
                for (int k = j+1; k < inputs.length; ++k) {
                    if (inputs[i] <= inputs[j] && inputs[j] <= inputs[k]) result++;
                }
            }
        }
        System.out.println(result);
    }
}