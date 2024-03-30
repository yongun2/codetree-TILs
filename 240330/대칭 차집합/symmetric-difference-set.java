import java.io.*;
import java.util.*;

public class Main {

    public static int aLen, bLen;
    public static int[] A, B;
    public static Set<Integer> aSet = new HashSet<>();
    public static Set<Integer> bSet = new HashSet<>();

    public static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        aLen = Integer.parseInt(st.nextToken());
        bLen = Integer.parseInt(st.nextToken());

        A = new int[aLen];
        B = new int[bLen];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < aLen; ++i) {
            int val = Integer.parseInt(st.nextToken()); 
            A[i] = val;
            aSet.add(val);
        }
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < bLen; ++i) {
            int val = Integer.parseInt(st.nextToken()); 
            B[i] = val;
            bSet.add(val);
        }

        int result = 0;
        for (int number: B) {
            if (!aSet.contains(number)) result +=1;
        }

        for (int number: A) {
            if (!bSet.contains(number)) result +=1;
        }

        System.out.println(result);



    }
}