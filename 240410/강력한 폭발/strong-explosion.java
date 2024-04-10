import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static List<Integer[]> bombs = new ArrayList<>();
    private static int[] options = new int[10];
    private static int result = Integer.MIN_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; ++j) {
                int val = Integer.parseInt(st.nextToken());
                if (val == 1) bombs.add(new Integer[] {i, j});
            }
        }
        optionChoose(0);
        System.out.println(result);    
    }

    private static void optionChoose(int index) {
        if (index >= bombs.size()) {
            findResult();
            return;
        }

        for (int i = 1; i <= 3; ++i) {
            options[index] = i;
            optionChoose(index+1);
        }
    }

    private static void findResult() {
        int[][] grid = new int[N][N];

        for (int i = 0; i < bombs.size(); ++i) {
            Integer[] pos = bombs.get(i);

            int posY = pos[0];
            int posX = pos[1];

            grid[posY][posX] = 1;

            int option = options[i];

            int[] dy, dx;
            if (option == 1) {
                dy = new int[] {-2, -1, 1, 2};
                dx = new int[] {0, 0, 0, 0};
            } else if (option == 2) {
                dy = new int[] {-1, 0, 0, 1};
                dx = new int[] {0, -1, 1, 0};
            } else {
                dy = new int[] {-1, -1, 1, 1};
                dx = new int[] {-1, 1, -1, 1};
            } 

            for (int j = 0; j < 4; ++j) {
                int x = dx[j] + posX;
                int y = dy[j] + posY;
                if (canGo(x, y)) {
                    grid[y][x] = 1;
                }
            }
        } 
        int count = 0;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                if (grid[i][j] == 1) count+=1;
            }
        }

        result = Math.max(result, count);
        
    }

    private static boolean canGo(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}