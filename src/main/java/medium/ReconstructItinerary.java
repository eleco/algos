package medium;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class ReconstructItinerary {

    /*
    You are given a list of airline tickets where tickets[i] = [fromi, toi] represent the departure and the arrival airports of one flight.
    Reconstruct the itinerary in order and return it.

    All of the tickets belong to a man who departs from "JFK", thus, the itinerary must begin with "JFK".
    If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string.
    For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].

    You may assume all tickets form at least one valid itinerary. You must use all the tickets once and only once.
    */

    static int nbtickets=0;
    static Map<String, List<String>> possibleVisits = new HashMap<>();
    static List<String> result = new ArrayList<String>();

    public static void main(String[] args) {
        System.out.println(findItinerary(List.of(List.of("JFK","SFO"),
                List.of("JFK","ATL"),List.of("SFO","ATL"),
                List.of("ATL","JFK"),List.of("ATL","SFO"))));
    }


   static List<String> findItinerary(List<List<String>> tickets) {

            result = new ArrayList<String>();
            possibleVisits.clear();

            for (List<String> ticket : tickets) {
                List<String> l = possibleVisits.get(ticket.get(0));
                if (l==null) {
                    l = new CopyOnWriteArrayList<String>();
                    l.add(ticket.get(1));
                }else {
                    l.add(ticket.get(1));
                }
                possibleVisits.put(ticket.get(0),l);
            }

            for (Map.Entry<String, List<String>> entry : possibleVisits.entrySet()) {
                Collections.sort(entry.getValue());
            }

            nbtickets = tickets.size();

            List<String> trips = new ArrayList<String>();
            trips.add("JFK");
            dfs("JFK",  trips);
            return result;
        }


        static void dfs(String departure, List<String> trips) {

            //terminal condition
            if (trips.size()==nbtickets+1) {
                result.addAll(trips);
                return ;
            }
            List<String> candidates = possibleVisits.get(departure);
            if(candidates==null) return;

            for (String candidate:candidates){

                List<String> arrivals = possibleVisits.get(departure);
                if (arrivals==null || !arrivals.contains(candidate)) {
                    continue;
                }
                else {
                    arrivals.remove(candidate);
                }
                trips.add(candidate);

                dfs(candidate, trips);
                if (!result.isEmpty()) {
                    return;
                }

                //backtrack
                trips.remove(trips.size()-1);
                arrivals.add(candidate);
            }

        }
    }

