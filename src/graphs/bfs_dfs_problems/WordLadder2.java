package graphs.bfs_dfs_problems;

import java.util.*;

public class WordLadder2 {
    public static void main(String[] args) {
        List<String> wordPool = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        String start = "hit", end = "cog";
        System.out.println(shortestTransitionPaths(start, end, wordPool));
    }

    public static List<List<String>> shortestTransitionPaths(String start, String finish, List<String> wordPool) {
        Queue<List<String>> q = new LinkedList<>();
        Set<String> seWordPool = new HashSet<>(wordPool);
        List<String> usedWordsOnPreviousLevels = new ArrayList<>();
        List<List<String>> ans = new ArrayList<>();

        q.add(new ArrayList<>(Collections.singletonList(start)));
        usedWordsOnPreviousLevels.add(start);
        int level = 1;
        while (!q.isEmpty()) {
            List<String> remSeq = q.poll();
            String lastWord = remSeq.get(remSeq.size() - 1);
            if (lastWord.equals(finish)) {
                ans.add(remSeq);
            }
            if (remSeq.size() == level) {
                for (String word : usedWordsOnPreviousLevels) {
                    seWordPool.remove(word);
                }
                level++;
            }
            for (int i = 0; i < lastWord.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    if (lastWord.charAt(i) == ch)
                        continue;
                    char[] replacedArr = lastWord.toCharArray();
                    replacedArr[i] = ch;
                    String replacedWord = new String(replacedArr);
                    if (seWordPool.contains(replacedWord)) {
                        remSeq.add(replacedWord);
                        q.add(new ArrayList<>(remSeq));
                        usedWordsOnPreviousLevels.add(replacedWord);
                        remSeq.remove(replacedWord);
                    }
                }
            }
        }
        return ans;
    }
}
