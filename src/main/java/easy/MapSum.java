package easy;

import java.util.HashMap;
import java.util.Map;

class MapSum {

    /*
    Implement a PrefixMapSum class with the following methods:
    insert(key: str, value: int): Set a given key's value in the map. If the key already exists, overwrite the value.
    sum(prefix: str): Return the sum of all values of keys that begin with a given prefix.
     */
    public static void main(String args[]) {

        MapSum ms = new MapSum();
        ms.insert("abc",2);
        ms.insert("abcd",1);
        ms.insert("d",2);
        System.out.println(ms.sum("ab"));

    }

    Map<String, Integer> m = new HashMap<String, Integer>();

    public void insert(String key, int val) {
        m.put(key,val);
    }

    public int sum(String prefix) {
        int sum=0;
        for (Map.Entry<String, Integer> e: m.entrySet()) {
            if (e.getKey().startsWith(prefix)) sum+=e.getValue();
        }
        return sum;
    }
}

