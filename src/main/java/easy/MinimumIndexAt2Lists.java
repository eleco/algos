package easy;

import java.util.*;

public class MinimumIndexAt2Lists {

    /*
    Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings.
    You need to help them find out their common interest with the least list index sum. If there is a choice tie between answers, output all of them with no order requirement. You could assume there always exists an answer.
     */

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findRestaurant(new String[]{"Shogun","Tapioca Express","Burger King","KFC"}
        , new String[]{"Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"})));

    }

    public static String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> m1 = new HashMap<>();
        Integer min = Integer.MAX_VALUE;
        List<String> ret = new ArrayList<>();

        for (int i = 0; i < list1.length; i++) m1.put(list1[i], i);

        for (int i = 0; i < list2.length; i++) {
            if (m1.containsKey(list2[i])) {
                Integer v = m1.get(list2[i]);
                if (v + i < min) {
                    ret.clear();
                    min = v + i;
                }
                if (min.equals(v + i)) {
                    ret.add(list2[i]);
                }

            }
        }


        return ret.toArray(new String[0]);


    }

}
