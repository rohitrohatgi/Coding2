package rohit.leetcode;

import java.util.*;
/*
We are given some website visits: the user with name username[i] visited the website website[i] at time timestamp[i].

A 3-sequence is a list of websites of length 3 sorted in ascending order by the time of their visits.  (The websites in a 3-sequence are not necessarily distinct.)

Find the 3-sequence visited by the largest number of users. If there is more than one solution, return the lexicographically smallest such 3-sequence.


 */
public class AnalyzeUserWebsiteVisitPattern {
    class Pair{
        public Pair(String website,int timestamp){
            this.website = website;
            this.timestamp = timestamp;
        }
        String website;
        int timestamp;
    }
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {

        Map<String,List<Pair>> map = new HashMap<>();
        for(int i = 0 ; i < username.length ; i++){
            map.putIfAbsent(username[i], new ArrayList<>());
            map.get(username[i]).add(new Pair(website[i],timestamp[i]));
        }
        Map<String, Integer> count = new HashMap<>();
        String res = "";
        for(String key : map.keySet()){
            List<Pair> details = map.get(key);
            Collections.sort(details,(x,y) -> x.timestamp - y.timestamp);
            for(int i = 0 ; i < details.size() - 2 ; i++){
                String pattern = details.get(i).website + " " + details.get(i + 1).website + " " + details.get(i + 2).website;
                count.put(pattern,count.getOrDefault(pattern,0) + 1);
                if(res.equals("") || count.get(res) < count.get(pattern) || (count.get(res) == count.get(pattern) && res.compareTo(pattern) > 0) )
                    res = pattern;
            }
        }
        List<String> result = new ArrayList<>();
        String[] r = res.split(" ");

        for (String str : r) {
            result.add(str);
        }
        return result;
    }

    public static void main(String[] args) {
        String[] username = {"joe","joe","joe","james","james","james","james","mary","mary","mary"};
        int[] timestamp = {1,2,3,4,5,6,7,8,9,10};
        String[] website = {"home","about","career","home","cart","maps","home","home","about","career"};
        AnalyzeUserWebsiteVisitPattern analyzeUserWebsiteVisitPattern = new AnalyzeUserWebsiteVisitPattern();
        System.out.println(analyzeUserWebsiteVisitPattern.mostVisitedPattern(username,timestamp,website));
    }
}
