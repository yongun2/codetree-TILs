import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static int N, K;
    public static int[][] grid;
    public static boolean[][] visited;
    
    public static Pair current;
    public static Pair next;

    public static List<Pair> neighbors;

    static class Pair {
        public int x, y, val;
        public Pair(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        }

        public int getVal() {
            return this.val;
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        grid = new int[N][N];
        

        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; ++j) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        int r = Integer.parseInt(st.nextToken()) - 1;
        int c = Integer.parseInt(st.nextToken()) - 1;
        current = new Pair(c, r, grid[r][c]);

        for (int i = 0; i < K; ++i) {
            visited = new boolean[N][N];
            neighbors = new ArrayList<Pair>();
            BFS();

            Optional<Pair> first = neighbors.stream()
                    .sorted(Comparator
                            .comparing((Pair p) -> p.val).reversed()
                          .thenComparing(Pair::getY)
                          .thenComparing(Pair::getX)
                    ).collect(Collectors.toList())
                    .stream().findFirst();
            if (first.isPresent()) {
                current = first.get();
            }   
            else break;
            // System.out.printf("%d %d %d\n", current.y, current.x, current.val);
        }

        System.out.printf("%d %d\n", current.y + 1, current.x + 1);
    }

    public static void BFS() {

        Deque<Pair> queue = new ArrayDeque<>();
        queue.add(current);
        visited[current.y][current.x] = true;

        int[] dx = new int[] {0, 1, 0, - 1};
        int[] dy = new int[] {-1, 0, 1, 0};
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();

            for (int i = 0; i < 4; ++i) {
                int nx = pair.x + dx[i];
                int ny = pair.y + dy[i];
                if (canGo(nx, ny)) {
                    visited[ny][nx] = true;
                    Pair next = new Pair(nx, ny, grid[ny][nx]);
                    queue.add(next);
                    neighbors.add(next);
                }
            }
        }

    }

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }

    public static boolean canGo(int x, int y) {
        if (!inRange(x, y)) return false;

        if (grid[y][x] >= current.val || visited[y][x]) return false;

        return true;
    }
}