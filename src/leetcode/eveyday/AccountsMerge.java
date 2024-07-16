package leetcode.eveyday;

import java.util.*;

/**
 * @author: ZhangX
 * @createDate: 2024/7/16
 * @description:
 */
public class AccountsMerge {
    public static void main(String[] args) {

    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, List<Integer>> emailToIdx = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                emailToIdx.computeIfAbsent(accounts.get(i).get(j), k -> new ArrayList<>()).add(i);
            }
        }

        List<List<String>> res = new ArrayList<>();
        boolean[] visited = new boolean[accounts.size()];
        Set<String> emailSet = new HashSet<>();
        for (int i = 0; i < accounts.size(); i++) {
            if (visited[i]) {
                continue;
            }
            emailSet.clear();
            dfs(i, accounts, emailToIdx, visited, emailSet);
            List<String> ans = new ArrayList<>(emailSet);
            Collections.sort(ans);
            ans.add(0, accounts.get(i).get(0));

            res.add(ans);
        }
        return res;
    }

    private void dfs(int i, List<List<String>> accounts, Map<String, List<Integer>> emailToIdx, boolean[] visited, Set<String> emailSet) {

        visited[i] = true;
        for(int j = 1; j < accounts.get(i).size(); j++) {
            String email = accounts.get(i).get(j);
            if (emailSet.contains(email)) {
                continue;
            }
            emailSet.add(email);
            for (int k : emailToIdx.get(email)) { // 遍历所有包含该邮箱地址的账户下标 j
                if (!visited[k]) { // j 没有访问过
                    dfs(k, accounts, emailToIdx, visited, emailSet);
                }
            }
        }
    }
}
