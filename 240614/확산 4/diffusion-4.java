import java.io.*;
import java.util.*;

public class Main {

    private static class Item {
        public char ch;
        public int time;
        public Item (char ch, int time){
            this.ch = ch;
            this.time = time;
        }

        public String toString() {
            return String.valueOf(ch);
        }
    }

    private static class Pos {
        public int x;
        public int y;
        public Item item;

        public Pos(int x, int y, Item item) {
            this.x = x;
            this.y = y;
            this.item = item;
        }

        public String toString() {
            return item.toString();
        }
    }

    private static int N, M, S;
    private static Pos[][] grid;
    private static List<Pos> generateBlank = new ArrayList<>();
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        grid = new Pos[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; ++i) {
            String line = br.readLine();
            for (int j = 0; j < M; ++j) {
                grid[i][j] = new Pos(j, i, new Item(line.charAt(j), 0));
            }
        }

        for (int i = 1; i <= S; ++i) {
            bfs(i);
            erase();
            generateBlank.clear();
            visited = new boolean[N][M];
            // System.out.println("[time = " + i + "]");
            // for (int j = 0; j < N; ++j) {
            //     System.out.println(Arrays.toString(grid[j]));
            // }
        }

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                bw.write(String.valueOf(grid[i][j]));
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }


    private static void bfs(int time) {
        Deque<Pos> queue = new ArrayDeque<>();
        queue.add(grid[0][0]);
        visited[0][0] = true;

        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};
        
        while(!queue.isEmpty()) {
            Pos cur = queue.poll();

            if (isGenerateO(time, cur)) {
                grid[cur.y][cur.x].item.ch = 'O';
                grid[cur.y][cur.x].item.time = time;
            }
            
            if (isGenerateBlank(time, cur)) {
                generateBlank.add(grid[cur.y][cur.x]);
            }

            // 탐색
            for (int i = 0; i < 4; ++i) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (inRange(nx, ny) && !visited[ny][nx]) {
                    queue.add(grid[ny][nx]);
                    visited[ny][nx] = true;
                }
            }
        }
    }

    private static void erase() {
        int[] dy = {0, -1, 0, 1, 0};
        int[] dx = {0, 0, 1, 0, -1};

        for (int i = 0; i < generateBlank.size(); ++i) {
            for (int j = 0; j < 5; ++j) {
                int nx = dx[j] + generateBlank.get(i).x;
                int ny = dy[j] + generateBlank.get(i).y;
                if (inRange(nx, ny)) {
                    grid[ny][nx].item.ch = '.';
                }
            }
        }
        
    }

    private static boolean isGenerateO(int time, Pos cur) {
        return time != 1 && cur.item.ch == '.';
    }

    private static boolean isGenerateBlank(int time, Pos cur) {

        if (cur.item.ch == '.') {
            return false;
        }

        if (time == cur.item.time) {
            return false;
        }

        return (time - cur.item.time) % 3 == 0;
    }
    
    private static boolean inRange(int x, int y) {
        return x >= 0 && x < M && y >= 0 && y < N;
    }

    
}