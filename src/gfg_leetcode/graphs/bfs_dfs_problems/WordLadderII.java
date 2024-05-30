package gfg_leetcode.graphs.bfs_dfs_problems;

import java.util.*;

public class WordLadderII {
    public static void main(String[] args) {
        String[] w = {"des", "der", "dfr", "dgt", "dfs"};
        String start = "der", end = "dfs";
        System.out.println(findSequences(start, end, w));
    }

    public static ArrayList<ArrayList<String>> findSequences(String startWord, String targetWord, String[] wordList) {
        Queue<ArrayList<String>> q = new LinkedList<>();
        List<String> usedWordsOnPreLevels = new ArrayList<>();
        Set<String> se = new HashSet<>(Arrays.asList(wordList));
        ArrayList<ArrayList<String>> ans = new ArrayList<>();

        q.add(new ArrayList<>(Collections.singletonList(startWord)));
        usedWordsOnPreLevels.add(startWord);
        int level = 0;

        while (!q.isEmpty()) {
            ArrayList<String> rem = q.poll();
            if (rem.size() > level) {
                for (String w : usedWordsOnPreLevels) {
                    se.remove(w);
                }
                level++;
                usedWordsOnPreLevels.clear();
            }
            String lastWord = rem.get(rem.size() - 1);
            if (lastWord.equals(targetWord)) {
                if (ans.size() == 0)
                    ans.add(rem);
                else if (ans.get(0).size() == rem.size()) {
                    ans.add(rem);
                }
            }
            char[] wordArr = lastWord.toCharArray();
            for (int i = 0; i < wordArr.length; i++) {
                char ch = wordArr[i];
                for (char j = 'a'; j <= 'z'; j++) {
                    if (j != ch) {
                        wordArr[i] = j;
                        String changed = new String(wordArr);
                        if (se.contains(changed)) {
                            rem.add(changed);
                            q.add(new ArrayList<>(rem));
                            usedWordsOnPreLevels.add(changed);
                            rem.remove(rem.size() - 1);
                        }
                    }
                }
                wordArr[i] = ch;
            }
        }
        return ans;
    }
}
