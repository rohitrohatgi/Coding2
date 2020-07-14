package rohit.leetcode;

import java.util.HashMap;
import java.util.Map;

public class StorePrefixes {
    public int minimumLengthEncoding(String[] words) {
        if(words == null || words.length == 0)
            return 0;
        Map<TrieNode, Integer> nodes = new HashMap<>();
        TrieNode trie = new TrieNode();

        for(int i = 0; i < words.length; ++i){
            char[] wordArray = words[i].toCharArray();
            TrieNode cur = trie;

            for(int j = wordArray.length - 1; j >= 0; --j){
                cur = cur.get(wordArray[j]);
            }
            System.out.println(cur.count +"  "+i);
            nodes.put(cur, i);
        }
        int result = 0;
        for (TrieNode node: nodes.keySet()) {
            if (node.count == 0)
                result += words[nodes.get(node)].length() + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        StorePrefixes storePrefixes = new StorePrefixes();
        System.out.println(storePrefixes.minimumLengthEncoding(new String[]{"time","me","ant"}));
    }
}
class TrieNode{
    TrieNode[] children;
    int count;
    TrieNode() {
        children = new TrieNode[26];
        count = 0;
    }
    public TrieNode get(char c){
        if (children[c-'a'] == null) {
            children[c-'a'] = new TrieNode();
            count++;
        }
        return children[c - 'a'];
    }

    public String toString(){
        return children.toString();
    }

}
