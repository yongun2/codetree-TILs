import java.io.*;
import java.util.*;

public class Main {
    
    public static int N;

    public static List<Integer> numbers = new ArrayList<>();
    public static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        backtracking(0);
        System.out.println(result);
    }

    public static void backtracking(int index) {
        if (index == N) {
            isBeautifulNumber();
            return;
        }

        for (int i = 1; i <= 4; ++i) {
            numbers.add(i);
            backtracking(index + 1);
            numbers.remove(numbers.size() - 1);
        }

    }

    public static void isBeautifulNumber() {
        int startNumber = numbers.get(0);
        int count = 1;
        
        for (int i = 1; i < numbers.size(); ++i) {
            int curNumber = numbers.get(i);

            if (curNumber != startNumber) {
                if (count != startNumber) return;
                count = 1;
                startNumber = curNumber;
            } else {
                if (startNumber == 1) {
                    count = 1;
                } else {
                    count += 1;
                    if (count > startNumber) return;
                }
            }
        }

        if (count != startNumber) return;
        // System.out.println(numbers.toString());
        result += 1;
    }
}