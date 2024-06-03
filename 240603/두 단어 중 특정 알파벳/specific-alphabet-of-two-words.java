import java.io.*;
import java.util.*;

public class Main {

    private static int N;

    private static Map<Character, Integer> strA = new HashMap<>();
    private static Map<Character, Integer> strB = new HashMap<>();
    private static Map<Character, Integer> result = new HashMap<>();

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (char i = 97; i < 123; ++i) {
            result.put(i, 0);
        }

        StringTokenizer st;
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());

            String str = st.nextToken();
            for (int j = 0; j < str.length(); ++j) {
                Character value = str.charAt(j);
                strA.put(value, strA.getOrDefault(value, 0) + 1);
            }

            str = st.nextToken();
            for (int j = 0; j < str.length(); ++j) {
                Character value = str.charAt(j);
                strB.put(value, strB.getOrDefault(value, 0) + 1);
            }

            for (Character c: strA.keySet()) {
                if (strB.containsKey(c)) {
                    result.put(c, result.get(c) + Math.max(strA.get(c), strB.get(c)));
                } else {
                    result.put(c, result.get(c) + strA.get(c));
                }
            }

            for (Character c: strB.keySet()) {
                if (strA.containsKey(c)) {
                    continue;
                } else {
                    result.put(c, result.get(c) + strB.get(c));
                }
            }
            strA.clear();
            strB.clear();
        }

        for (char i = 97; i < 123; ++i) {
            System.out.println(result.get(i));
        }
    }
}