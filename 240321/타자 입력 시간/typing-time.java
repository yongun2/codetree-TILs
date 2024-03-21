import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        
        Set<Character> leftHand = new HashSet<>(Arrays.asList(
                                                    'q', 'w', 'e', 'r',
                                                    't', 'a', 's', 'd',
                                                    'f', 'g', 'z', 'x','c','v'
                                                    )
                                                );
        Set<Character> rightHand = new HashSet<>(Arrays.asList(
                                                    'y', 'u', 'i', 'o',
                                                    'p', 'h', 'j', 'k',
                                                    'l', 'b', 'n', 'm'
                                                    )
                                                );
        char[][] keyboard = new char[][] {
                                {'q','w','e','r','t','y','u','i','o','p'},
                                {'a','s','d','f','g','h','j','k','l',' '},
                                {'z','x','c','v','b','n','m',' ',' ',' '}
                            };

        Map<Character, List<Integer>> keyboardLookup = new HashMap<>();

        for (int i = 0; i < keyboard.length; ++i) {
            for (int j = 0; j < keyboard[i].length; ++j) {
                keyboardLookup.put(keyboard[i][j], Arrays.asList(i, j));
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] pos = br.readLine().split(" ");
        char left = pos[0].charAt(0);
        char right = pos[1].charAt(0);

        String target = br.readLine();
        int result = 0;
        int pressTime = 1;
        int moveTime = 0;
        for (int i = 0; i < target.length(); ++i) {
            char curCharacter = target.charAt(i);
            if (leftHand.contains(curCharacter)) {
                if (curCharacter == left) result += pressTime;
                else {
                    // move
                    moveTime += Math.abs(keyboardLookup.get(left).get(0) - keyboardLookup.get(curCharacter).get(0));
                    moveTime += Math.abs(keyboardLookup.get(left).get(1) - keyboardLookup.get(curCharacter).get(1));
                    left = curCharacter;
                    result += (moveTime + pressTime);
                }   
            } else if (rightHand.contains(curCharacter)) {
                if (curCharacter == right) result += pressTime;
                else {
                    moveTime += Math.abs(keyboardLookup.get(right).get(0) - keyboardLookup.get(curCharacter).get(0));
                    moveTime += Math.abs(keyboardLookup.get(right).get(1) - keyboardLookup.get(curCharacter).get(1));
                    right = curCharacter;
                    result += (moveTime + pressTime);
                }
            }
            moveTime = 0;
        }
        System.out.println(result);
    }
}