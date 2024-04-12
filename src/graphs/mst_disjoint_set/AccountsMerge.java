package graphs.mst_disjoint_set;

import java.util.*;
import java.util.stream.Collectors;

public class AccountsMerge {
    static class DisjointSet {
        int[] parent;
        int[] size;

        public DisjointSet(int n) {
            parent = new int[n + 1];
            size = new int[n + 1];
            Arrays.fill(size, 1);
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
        }

        //path compression
        public int findUParent(int node) {
            if (node == parent[node])
                return node;
            return parent[node] = findUParent(parent[node]);
        }

        //union by size
        public void unionBySize(int u, int v) {
            int rootX = findUParent(u);
            int rootY = findUParent(v);
            if (rootX == rootY)
                return;
            if (size[rootX] < size[rootY]) {
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
            } else {
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
            }
        }
    }

    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        Map<String, Integer> mapMailNode = new HashMap<>();
        DisjointSet dis = new DisjointSet(n);
        //traversing through the mails
        for (int i = 0; i < accounts.size(); i++) {
            List<String> acc = accounts.get(i);
            for (int j = 1; j < acc.size(); j++) {
                String mail = acc.get(j);
                if (!mapMailNode.containsKey(mail)) {
                    mapMailNode.put(mail, i);
                } else {
                    dis.unionBySize(i, mapMailNode.get(mail));
                }
            }
        }

        List<List<String>> mergedMailList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            mergedMailList.add(new ArrayList<>());
        }
        for (Map.Entry<String, Integer> it : mapMailNode.entrySet()) {
            String mail = it.getKey();
            Integer par = it.getValue();
            int up = dis.findUParent(par);
            mergedMailList.get(up).add(mail);
        }

        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < mergedMailList.size(); i++) {
            if (mergedMailList.get(i).isEmpty())
                continue;
            Collections.sort(mergedMailList.get(i));
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            temp.addAll(mergedMailList.get(i));
            ans.add(temp);
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 4;
        String[][] accs = {{"Rohan", "rohan123@gmail.com", "1279ro@gmail.com"},
                {"Rohit", "rohit101@yahoo.com", "hitman30487@gmail.com"},
                {"Rohan", "1279ro@gmail.com", "niemann01@gmail.com"},
                {"Rohan", "kaushik@outlook.com"}};
        List<List<String>> li = Arrays.stream(accs).map(acc -> Arrays.stream(acc).collect(Collectors.toList()))
                .toList();
        System.out.print(accountsMerge(li));
    }
}
