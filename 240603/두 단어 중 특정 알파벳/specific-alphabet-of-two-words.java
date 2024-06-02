import java.io.*;
import java.util.*;


public class Main {
    private static Map<Character, Integer> result = new HashMap<>();
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (char i = 97; i <= 122; ++i) {
            result.put(i, 0);
        }

        StringTokenizer st;
        Set<Character> lookup = new HashSet<>();
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            
            for (int j = 0; j < 2; ++j) {
                String str = st.nextToken();
                for (int k = 0; k < str.length(); ++k) {
                    char value = str.charAt(k);
                    if (lookup.contains(value)) {
                        continue;
                    } 

                    lookup.add(value);
                    result.put(value, result.get(value) + 1);
                }
            }
            lookup.clear();
            
        }
        for (char i = 97; i <= 122; ++i) {
            System.out.println(result.get(i));
        }
        
        
        
    }
}