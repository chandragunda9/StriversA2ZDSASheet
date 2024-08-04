package graphs.bfs_dfs_problems;

import java.util.*;

public class WordLadderII {
    public static void main(String[] args) {
        String[] wordList = {"des", "der", "dfr", "dgt", "dfs"};
        String startWord = "der", endWord = "dfs";
        System.out.println(findSequences(startWord, endWord, wordList));
    }

    public static ArrayList<ArrayList<String>> findSequences(String startWord, String targetWord, String[] wordList) {
        Set<String> se = new HashSet<>(Arrays.asList(wordList));
        Queue<ArrayList<String>> q = new LinkedList<>();
        List<String> usedWordsOnPreLevels = new ArrayList<>();
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        int level;

        q.add(new ArrayList<>(Collections.singletonList(startWord)));
        usedWordsOnPreLevels.add(startWord);
        level = 0;

        while (!q.isEmpty()) {
            ArrayList<String> seq = q.poll();
            String lastWord = seq.get(seq.size() - 1);

            //removing words used in previous levels
//            if (seq.size() > level) {
                for (String word : usedWordsOnPreLevels) {
                    se.remove(word);
                }
                usedWordsOnPreLevels.clear();
                level++;
//            }

            if (lastWord.equals(targetWord)) {
                if (ans.isEmpty() || ans.get(0).size() == seq.size()) {
                    ans.add(seq);
                }
            }

            char[] wordArr = lastWord.toCharArray();
            for (int i = 0; i < wordArr.length; i++) {
                char ch = wordArr[i];
                for (char each = 'a'; each <= 'z'; each++) {
                    if (ch != each) {
                        wordArr[i] = each;
                        String changedWord = new String(wordArr);
                        if (se.contains(changedWord)) {
                            seq.add(changedWord);
                            usedWordsOnPreLevels.add(changedWord);
                            q.add(new ArrayList<>(seq));
                            seq.remove(seq.size() - 1);
                        }
                    }
                }
                wordArr[i] = ch;
            }
        }
        return ans;
    }
}
