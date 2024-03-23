package graphs.bfs_dfs_problems;

import java.util.*;

public class WordLadder1 {
    static class Node {
        String word;
        int pos;

        public Node(String word, int pos) {
            this.word = word;
            this.pos = pos;
        }
    }

    public static int wordLadder(String begin, String end, ArrayList<String> dict) {
        Queue<Node> q = new LinkedList<>();
        Set<String> di = new HashSet<>(dict);
        q.add(new Node(begin, 1));
        di.remove(begin);
        while (!q.isEmpty()) {
            Node rem = q.poll();
            if (end.equals(rem.word))
                return rem.pos;
            char[] wordArr = rem.word.toCharArray();
            for (int i = 0; i < wordArr.length; i++) {
                char ch = wordArr[i];
                for (char each = 'a'; each <= 'z'; each++) {
                    if (each != ch) {
                        wordArr[i] = each;
                        String changed = new String(wordArr);
                        if (di.contains(changed)) {
                            q.add(new Node(changed, rem.pos + 1));
                            di.remove(changed);
                        }
                    }
                }
                wordArr[i] = ch;
            }
        }
        return -1;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Node> q = new LinkedList<>();
        Set<String> di = new HashSet<>(wordList);
        q.add(new Node(beginWord, 1));
        di.remove(beginWord);
        while (!q.isEmpty()) {
            Node rem = q.poll();
            if (endWord.equals(rem.word))
                return rem.pos;
            char[] wordArr = rem.word.toCharArray();
            for (int i = 0; i < wordArr.length; i++) {
                char ch = wordArr[i];
                for (char each = 'a'; each <= 'z'; each++) {
                    if (each != ch) {
                        wordArr[i] = each;
                        String changed = new String(wordArr);
                        if (di.contains(changed)) {
                            q.add(new Node(changed, rem.pos + 1));
                            di.remove(changed);
                        }
                    }
                }
                wordArr[i] = ch;
            }
        }
        return 0;
    }
}
