package others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SearchSuggestionsSystem {
    class Trie{
        Trie[] sub = new Trie[26];
        LinkedList<String> suggestion = new LinkedList<>();
    }
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        Trie root = new Trie();
        for(String product : products){
            insertProduct(product,root);
        }
        return searchProduct(searchWord,root);
    }

    private List<List<String>> searchProduct(String searchWord, Trie root) {
        List<List<String>> result = new ArrayList<>();

        Trie t = root;
        for (char c : searchWord.toCharArray()) {
            if (t != null)
                t = t.sub[c - 'a'];
            result.add(t.suggestion != null  ? t.suggestion : Arrays.asList()) ;
        }

        return result;
    }

    private void insertProduct(String product, Trie root) {
        Trie t = root;
        for (char c : product.toCharArray()) {
            if (t.sub[c - 'a'] == null)
                t.sub[c - 'a'] = new Trie();
            t = t.sub[c - 'a'];
            if (t.suggestion.size() < 3)
                t.suggestion.offer(product);
        }
    }
}
