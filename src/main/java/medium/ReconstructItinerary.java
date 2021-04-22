package medium;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class ReconstructItinerary {

    static int nbtickets=0;
    static Map<String, List<String>> m = new HashMap<>();
    static List<String> result = new ArrayList<String>();

    public static void main(String[] args) {
        System.out.println(findItinerary(List.of(List.of("JFK","SFO"),
                List.of("JFK","ATL"),List.of("SFO","ATL"),
                List.of("ATL","JFK"),List.of("ATL","SFO"))));
    }


   static List<String> findItinerary(List<List<String>> tickets) {

            result = new ArrayList<String>();
            m.clear();

            for (List<String> ticket : tickets) {
                List<String> l = m.get(ticket.get(0));
                if (l==null) {
                    l = new CopyOnWriteArrayList<String>();
                    l.add(ticket.get(1));
                }else {
                    l.add(ticket.get(1));
                }
                m.put(ticket.get(0),l);
            }

            for (Map.Entry<String, List<String>> entry : m.entrySet()) {
                Collections.sort(entry.getValue());
            }

            nbtickets = tickets.size();

            List<String> trips = new ArrayList<String>();
            trips.add("JFK");
            dfs("JFK",  trips);
            return result;
        }


        static void dfs(String node, List<String> trips) {

            if (trips.size()==nbtickets+1) {
                result.addAll(trips);
                return ;
            }
            List<String> candidates = m.get(node);
            if(candidates==null) return;

            for (String candidate:candidates){

                List<String> visits = m.get(node);
                if (visits==null || !visits.contains(candidate)) {
                    continue;
                }
                else {
                    visits.remove(candidate);
                }
                trips.add(candidate);

                dfs(candidate, trips);
                if (!result.isEmpty()) {
                    return;
                }

                trips.remove(trips.size()-1);
                visits.add(candidate);
            }

        }
    }

