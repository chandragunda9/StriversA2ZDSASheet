package graphs.bfs_dfs_problems;

import java.util.*;

public class WordLadderI {
    static class Node {
        String word;
        int pos;

        public Node(String word, int pos) {
            this.word = word;
            this.pos = pos;
        }
    }

    public static void main(String[] args) {
        String[] wordList = {"des", "der", "dfr", "dgt", "dfs"};
        String startWord = "der", targetWord = "dfs";
        System.out.println(wordLadderLength(startWord, targetWord, wordList));
    }

    public static int wordLadderLength(String startWord, String targetWord, String[] wordList) {
        Set<String> se = new HashSet<>(Arrays.asList(wordList));
        se.add(startWord);
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(startWord, 1));
        se.remove(startWord);
        while (!q.isEmpty()) {
            Node rem = q.poll();
            if (rem.word.equals(targetWord))
                return rem.pos;
            char[] wordArr = rem.word.toCharArray();
            for (int i = 0; i < wordArr.length; i++) {
                char ch = wordArr[i];
                for (char each = 'a'; each <= 'z'; each++) {
                    if (each != ch) {
                        wordArr[i] = each;
                        String replacedWord = new String(wordArr);
                        if (se.contains(replacedWord)) {
                            q.add(new Node(replacedWord, rem.pos + 1));
                            se.remove(replacedWord);
                        }
                    }
                }
                wordArr[i] = ch;
            }
        }
        return 0;
    }
}
