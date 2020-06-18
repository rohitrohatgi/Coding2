package rohit.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rohit on 19/6/20.
 */
public class BrowserHistory {

    List<String> history;
    int counter = -1;

    public BrowserHistory(String homepage) {
        history = new ArrayList<>();
        history.add(homepage);
        counter++;
    }

    public void visit(String url) {
        history.subList(counter + 1, history.size()).clear();
        history.add(url);
        counter++;
    }

    public String back(int steps) {
        if(counter - steps >= 0){
            counter = counter - steps;
            return history.get(counter);
        }else{
            counter = 0;
            return history.get(counter);
        }
    }

    public String forward(int steps) {
        if(counter + steps < history.size()){
            counter = counter + steps;;
            return history.get(counter);
        }else{
            counter = history.size() -1;
            return history.get(counter);
        }
    }
}
