package graphs.mst_disjointset;

import java.util.*;

public class AccountsMerge {
    public static void main(String[] args) {
        int n = 4;
        String[][] accounts = {{"John", "johnsmith@mail.com", "john_newyork@mail.com"},
                {"John", "johnsmith@mail.com", "john00@mail.com"},
                {"Mary", "mary@mail.com"},
                {"John", "johnnybravo@mail.com"}};
        List<List<String>> inp = Arrays.stream(accounts).map(arr -> Arrays.stream(arr).toList()).toList();
        System.out.print(accountsMerge(inp));
    }

    static List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet dis = new DisjointSet(n);
        Map<String, Integer> mailMap = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String mail = accounts.get(i).get(j);
                if (mailMap.containsKey(mail)) {
                    dis.unionBySize(i, mailMap.get(mail));
                } else {
                    mailMap.put(mail, i);
                }
            }
        }
        List<List<String>> li = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            li.add(new ArrayList<>());
        }
        for (Map.Entry<String, Integer> entry : mailMap.entrySet()) {
            String mail = entry.getKey();
            int u = entry.getValue();
            int rootU = dis.findParent(u);
            li.get(rootU).add(mail);
        }
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < li.size(); i++) {
            if (li.get(i).isEmpty())
                continue;
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            Collections.sort(li.get(i));
            temp.addAll(li.get(i));
            ans.add(temp);
        }
        return ans;
    }
}
