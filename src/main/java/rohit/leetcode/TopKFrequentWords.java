package rohit.leetcode;

import java.util.*;

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {

        Map<String,Integer> map = new HashMap<>();

        for(String word : words){
            if(map.containsKey(word))
                map.put(word,(map.get(word))+1);
            else
                map.put(word,1);
        }


        PriorityQueue<String> heap = new PriorityQueue<String>(
                (a,b) -> map.get(a) == map.get(b) ?  b.compareTo(a):map.get(a) - map.get(b) );
        for(String key : map.keySet()){
            heap.offer(key);
            if(heap.size()>k)
                heap.poll();
        }

        // Option 1
        List<String> ans = new ArrayList();
        while (!heap.isEmpty()) ans.add(heap.poll());
        Collections.reverse(ans);
        return ans;

         /* Option 2
        List<String> wordsList = new ArrayList(map.keySet());
        Collections.sort(wordsList, (a,b) -> map.get(a) == map.get(b) ?  a.compareTo(b):map.get(b).compareTo(map.get(a)));
        return wordsList.subList(0,k);
        */
    }

    public static void main(String[] args) {
        String[] input = {"i", "love", "leetcode", "i", "love", "coding"};

        TopKFrequentWords topKFrequentWords = new TopKFrequentWords();
        System.out.println(topKFrequentWords.topKFrequent(input,2));
        //"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"
        input = new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        System.out.println(topKFrequentWords.topKFrequent(input,4));
    }
}
