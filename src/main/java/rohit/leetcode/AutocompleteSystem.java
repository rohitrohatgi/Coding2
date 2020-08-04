package rohit.leetcode;

import java.security.Key;
import java.util.*;

/*
Design a search autocomplete system for a search engine. Users may input a sentence (at least one word and end with a special character '#'). For each character they type except '#', you need to return the top 3 historical hot sentences that have prefix the same as the part of sentence already typed. Here are the specific rules:

    The hot degree for a sentence is defined as the number of times a user typed the exactly same sentence before.
    The returned top 3 hot sentences should be sorted by hot degree (The first is the hottest one). If several sentences have the same degree of hot, you need to use ASCII-code order (smaller one appears first).
    If less than 3 hot sentences exist, then just return as many as you can.
    When the input is a special character, it means the sentence ends, and in this case, you need to return an empty list.

Your job is to implement the following functions:

The constructor function:

AutocompleteSystem(String[] sentences, int[] times): This is the constructor. The input is historical data. Sentences is a string array consists of previously typed sentences. Times is the corresponding times a sentence has been typed. Your system should record these historical data.

Now, the user wants to input a new sentence. The following function will provide the next character the user types:

List<String> input(char c): The input c is the next character typed by the user. The character will only be lower-case letters ('a' to 'z'), blank space (' ') or a special character ('#'). Also, the previously typed sentence should be recorded in your system. The output will be the top 3 historical hot sentences that have prefix the same as the part of sentence already typed.

 */
class AutocompleteSystem {

    class TrieNode{
        Map<Character,TrieNode> children;
        Map<String, Integer> counts;
        public TrieNode() {
            children = new HashMap<Character, TrieNode>();
            counts = new HashMap<String, Integer>();
        }
    }
    class Pair{
        String sentence;
        int count;
        public Pair(String sentence,int count){
            this.sentence = sentence;
            this.count = count;
        }
    }
    TrieNode root;
    String prefix;
    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        prefix = "";
        for(int i = 0 ; i < sentences.length; i++){
            add(sentences[i],times[i]);
        }
    }
    private void add(String sentence, int times){

        TrieNode current = root;
        for(int i = 0 ;  i < sentence.length() ; i++){
            TrieNode next = current.children.get(sentence.charAt(i));
            if(next == null){
                next = new TrieNode();
                current.children.put(sentence.charAt(i), next);
            }
            next.counts.put(sentence,current.counts.getOrDefault(sentence,0) + times);
            current = next;
        }

    }
    public List<String> input(char c) {
        List<String> result =  new  ArrayList<>();
        if(c == '#'){
            add(prefix,1);
            prefix = "";
            return result;
        }
        prefix = prefix + c;
        TrieNode current = root;
        for(char s : prefix.toCharArray()){
            TrieNode next = current.children.get(s);
            if(next == null){
                return result;
            }
            current = next;
        }
        // System.out.print(prefix);
        PriorityQueue<Pair> queue = new PriorityQueue<>((a,b) -> (a.count == b.count) ? a.sentence.compareTo(b.sentence) : b.count - a.count);
        for(String key : current.counts.keySet()){
            queue.offer(new Pair(key,current.counts.get(key)));
        }
        for(int i = 0; i < 3 && !queue.isEmpty() ; i++){
            result.add(queue.poll().sentence);
        }
        //  System.out.println(prefix);
        return result;
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */