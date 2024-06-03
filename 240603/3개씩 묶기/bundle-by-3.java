import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        array = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; ++i) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);

        if (array.length / 3 == 0) {
            int sum = 0;
            for (int i = 0; i < array.length; ++i) {
                sum += array[i];
            }

            System.out.println(sum);
            return;
        } 

        int delimeter = array.length / 3;
        int sum = 0;
        for (int i = 1; i <= delimeter; ++i) {
            for (int j = (i - 1) * 3 + 1; j < (i - 1) * 3 + 3; ++j) {
                sum += array[j];
            }
        }

        for (int i = delimeter * 3; i < array.length; ++i) {
            sum += array[i];
        }

        System.out.println(sum);
        
        
    }
}