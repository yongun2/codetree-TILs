import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int[] arr;
    private static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        choose(0);

        System.out.println(result);
    }

    private static void choose(int index) {
        if (index > N - 1) {
            if (isPerfectNumber()) result+=1;
            return;
        }

        for (int i = 1; i <= 4; ++i) {
            arr[index] = i;
            choose(index + 1);
        }
    }

    private static boolean isPerfectNumber() {
        
        int lookup = arr[0];
        int count = 1;

        if (arr.length == 1 && arr[0] != 1) return false;
        
        for (int i = 1; i < arr.length; ++i) {
            if (lookup == arr[i]) {
                count += 1;
            } else {
                if (count % lookup != 0) break;
                else {
                    count = 1;
                    lookup = arr[i];
                }
            }
        }

        if (count % lookup != 0) return false;
    
        return true;
    }
}