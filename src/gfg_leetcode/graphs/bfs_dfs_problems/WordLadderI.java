package gfg_leetcode.graphs.bfs_dfs_problems;

import java.util.*;

public class WordLadderI {
    public static void main(String[] args) {
        String[] li = {"hot", "dot", "dog", "lot", "log", "cog"};
        String begin = "hit";
        String end = "cog";
        System.out.println(wordLadderLength(begin, end, li));
    }

    static class Node {
        String word;
        int pos;

        public Node(String word, int pos) {
            this.word = word;
            this.pos = pos;
        }
    }

    public static int wordLadderLength(String startWord, String targetWord, String[] wordList) {
        Queue<Node> q = new LinkedList<>();
        Set<String> se = new HashSet<>(Arrays.asList(wordList));
        q.add(new Node(startWord, 1));
        se.remove(startWord);
        while (!q.isEmpty()) {
            Node rem = q.poll();
            if (targetWord.equals(rem.word))
                return rem.pos;
            char[] wordArr = rem.word.toCharArray();
            for (int i = 0; i < wordArr.length; i++) {
                char ch = wordArr[i];
                for (char each = 'a'; each <= 'z'; each++) {
                    if (each != ch) {
                        wordArr[i] = each;
                        String changed = new String(wordArr);
                        if (se.contains(changed)) {
                            q.add(new Node(changed, rem.pos + 1));
                            se.remove(changed);
                        }
                    }
                }
                wordArr[i] = ch;
            }
        }
        return 0;
    }
}
