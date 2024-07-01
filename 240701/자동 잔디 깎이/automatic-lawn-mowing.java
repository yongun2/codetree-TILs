import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int[][] grid = new int[2000][2000];

    private static List<Integer> results = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int x = 1000;
        int y = 1000;
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            String direction = st.nextToken();
            int distance = Integer.parseInt(st.nextToken());
            int dy, dx;
            
            switch (direction.charAt(0)) {
                case 'N':
                    dy = -1;
                    dx = 0;
                    break;
                case 'E':
                    dx = 1;
                    dy = 0;
                    break;
                case 'S':
                    dx = 0;
                    dy = 1;
                    break;
                case 'W':
                    dx = -1;
                    dy = 0;
                    break;
                default:
                    dy = 0;
                    dx = 0;
                    break;
            }

            for (int j = 0; j < distance; ++j) {
                int nx = x + dx;
                int ny = y + dy;
                if (grid[ny][nx] != 0) {
                    results.add(grid[y][x] + 1);
                }
                grid[ny][nx] = grid[y][x] + 1;
                x = nx;
                y = ny;
            }
        }
        // System.out.println(results);
        
        if (results.size() < 2) {
            bw.write(String.valueOf(-1));
        } else {
            bw.write(String.valueOf(Math.abs(results.get(0) - results.get(1)) + 1));
        }

        // for (int i = 990; i < 1020; ++i) {
        //     for (int j = 990; j < 1020; ++j) {
        //         System.out.print(grid[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        
        bw.flush();
        bw.close();
    }
}