import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    private static int N;
    private static List<String> arrays = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; ++i) {
            arrays.add(br.readLine());
        }

        arrays = arrays.stream()
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());

        arrays.forEach(System.out::println);
    }
}