import java.io.*;
import java.util.*;

public class Main {

    private static String S;
    private static int targetLength;
    private static int result = 0;
    private static Set<Integer> results = new HashSet<>();

    public static class State {
        public int window;
        public int clipboard;
        public int count;

        public State(int window, int clipboard, int count) {
            this.window = window;
            this.clipboard = clipboard;
            this.count = count;
        }

        public boolean equals(Object o) {
            if (o instanceof State) {
                return ((State) o).window == window && 
                        ((State) o).clipboard == clipboard &&
                        ((State) o).count == count;
            }
            return false;
        }

        public int hashCode() {
            return window + clipboard + count;
        }

        public String toString() {
            return "[" + window +  ", " + clipboard +  ", " + count +  "]";
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        S = br.readLine();
        targetLength = Integer.parseInt(S);

        bfs();
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();

    }

    private static void bfs() {
        Deque<State> queue = new ArrayDeque<>();
        Set<State> visited = new HashSet<>();
        queue.add(new State(1, 0, 0));
        visited.add(new State(1, 0, 0));

        while(!queue.isEmpty()) {

            State cur = queue.poll();
            
            if (cur.window == targetLength) {
                result = cur.count;
                return;
            }

            // operation 1
            State newState = new State(cur.window, cur.window, cur.count + 1);
            if (inRange(newState.window) && !visited.contains(newState)) {
                queue.add(newState);
                visited.add(newState);
            }

            // operation 2
            if (cur.clipboard != 0) {
                newState = new State(cur.window + cur.clipboard, cur.clipboard, cur.count + 1);
                if (inRange(newState.window) && !visited.contains(newState)){
                    queue.add(newState);
                    visited.add(newState);
                }
            }

            // operation 3
            newState = new State(cur.window - 1, cur.clipboard, cur.count + 1);
            if (inRange(newState.window) && !visited.contains(newState)) {
                queue.add(newState);
                visited.add(newState);
            }


        }
    }

    private static boolean inRange(int window) {
        return window > 0 && window <= targetLength;
    }
}