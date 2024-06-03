import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    private static int N;
    private static int[] array;
    private static List<Integer> arrayList = new ArrayList<>();

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
            for (int j = array.length - (i - 1) * 3 - 1; j > array.length - (i - 1) * 3 - 3; --j) {
                sum += array[j];
                // System.out.print(array[j] + " ");
            }
            // System.out.println();
        }
        // 0 1 2
        // 3 4 5

        // 0 ~ 8
        //

        for (int i = array.length - delimeter * 3 - 1 ; i >= 0; --i) {
            sum += array[i];
            // System.out.print(array[i] + " ");

        }

        System.out.println(sum);

        // 17467410
        // 17467738
        
        
    }
}