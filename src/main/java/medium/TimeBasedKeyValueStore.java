package medium;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeBasedKeyValueStore {

    /*
    Design a time-based key-value data structure that can store multiple values for the same key at different time stamps and retrieve the key's value at a certain timestamp.

    Implement the TimeMap class:

    TimeMap() Initializes the object of the data structure.
    void set(String key, String value, int timestamp) Stores the key key with the value value at the given time timestamp.
    String get(String key, int timestamp) Returns a value such that set was called previously, with timestamp_prev <= timestamp. If there are multiple such values, it returns the value associated with the largest timestamp_prev. If there are no values, it returns "".

     */

    class TimeMap {

        Map<String, TreeMap<Integer, String>> m = new HashMap<>();

        public TimeMap() {

        }

        public void set(String key, String value, int timestamp) {
            TreeMap<Integer, String> inner = m.get(key);
            if (inner == null) inner = new TreeMap<>();
            inner.put(timestamp, value);
            m.put(key, inner);
        }

        public String get(String key, int timestamp) {
            TreeMap<Integer, String> inner = m.get(key);
            if (inner == null) return "";

            String value = inner.get(timestamp);
            if (value == null) {
                Map.Entry<Integer, String> entry = inner.floorEntry(timestamp);
                if (entry == null) return "";
                return entry.getValue();
            }
            return value;
        }
    }
}
