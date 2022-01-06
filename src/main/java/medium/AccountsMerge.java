package medium;

import java.util.*;

public class AccountsMerge {

    public static void main(String[] args) {
        List account = List.of(
                List.of("John", "johnsmith@mail.com", "john_newyork@mail.com" ),
                List.of("John", "johnsmith@mail.com", "john00@mail.com" ),
                List.of("Mary", "mary@mail.com" ),
                List.of("John", "johnnybravo@mail.com" ));
        System.out.println(accountsMerge(account));
    }

    static List<List<String>> accountsMerge(List<List<String>> accounts) {

        Map<String, String> emailToName = new HashMap();
        Map<String, Set<String>> neighbours = new HashMap();
        for (int i = 0; i < accounts.size(); i++) {

            List<String> list = accounts.get(i);
            String name = list.get(0);
            Set<String> paths = new HashSet();
            for (int k = 1; k < list.size(); k++) {
                paths.add(list.get(k));
            }
            for (int j = 1; j < list.size(); j++) {
                String email = list.get(j);
                Set<String> existingPaths = neighbours.get(list.get(j));
                if (existingPaths == null) existingPaths = new HashSet();
                existingPaths.addAll(paths);
                neighbours.put(list.get(j), existingPaths);
                emailToName.put(email, name);
            }
        }


        Set<String> emails_visited = new HashSet();

        List<List<String>> merged = new ArrayList();
        for (int i = 0; i < accounts.size(); i++) {
            String name = accounts.get(i).get(0);
            Set<String> toMerge = new HashSet();
            for (int j = 1; j < accounts.get(i).size(); j++) {
                dfs(toMerge, accounts.get(i).get(j), neighbours, emails_visited);
            }
            List<String> sortedMerge = new ArrayList<>(toMerge);
            Collections.sort(sortedMerge);
            if (!sortedMerge.isEmpty()) {
                List<String> l = new ArrayList();
                l.add(name);
                for (String s : sortedMerge) l.add(s);
                merged.add(l);
            }

        }

        return merged;

    }

    static void dfs(Set<String> toMerge, String email, Map<String, Set<String>> neighbours, Set<String> emails_visited) {
        if (emails_visited.contains(email)) return;
        emails_visited.add(email);
        toMerge.add(email);
        for (String nei : neighbours.get(email)) {
            dfs(toMerge, nei, neighbours, emails_visited);
        }
    }

}
