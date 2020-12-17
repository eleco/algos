package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainCount {


    public static void main(String args[]) {
        System.out.println(subdomainVisits(new String[]{"9001 test.google.com", "1 google.com"}));
    }

    public static List<String> subdomainVisits(String[] cpdomains) {

        Map<String, Integer> m = new HashMap<String,Integer>();

        for (String s : cpdomains) {

            Integer c = Integer.valueOf(s.split(" ")[0]);
            String d = s.split(" ")[1];

            int pos=d.length()-1;
            int p=d.lastIndexOf(".", pos);
            while(p>=0) {
                String k = d.substring(p+1);
                m.merge(k, c, Integer::sum);
                pos=p;
                p=d.lastIndexOf(".", pos-1);
            }
            m.merge(d, c, Integer::sum);
        }


        List<String> l = new ArrayList<String>();
        for (Map.Entry<String,Integer> e: m.entrySet()) {
            l.add(e.getValue() + " " + e.getKey());
        }
        return l;

    }
}

