package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InsertDeleteGetRandom {

    /*
    Implement the RandomizedSet class:

    RandomizedSet() Initializes the RandomizedSet object.
    bool insert(int val) Inserts an item val into the set if not present.
     Returns true if the item was not present, false otherwise.

    bool remove(int val) Removes an item val from the set if present.
    Returns true if the item was present, false otherwise.

    int getRandom() Returns a random element from the current set of elements
     (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.

    You must implement the functions of the class such that each function
    works in average O(1) time complexity.
     */

    class RandomizedSet {


        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        public RandomizedSet() {
            list = new ArrayList<>();
            map = new HashMap<>();
        }

        public boolean insert(int val) {
            boolean contain = map.containsKey(val);
            if (contain) return false;
            list.add(val);

            map.put(val, list.size() - 1);
            return true;

        }

        public boolean remove(int val) {
            boolean contain = map.containsKey(val);
            if (!contain) return false;

            int loc = map.get(val);
            if (loc != list.size() - 1) {
                //case where element is not at end of the list
                //then swap with last one
                int lastone = list.get(list.size() - 1);
                map.put(lastone, loc);
                list.set(loc, lastone);

            }

            list.remove(list.size() - 1);
            map.remove(val);
            return true;
        }

        public int getRandom() {
            return list.get(new java.util.Random().nextInt(list.size()));
        }
    }
}
