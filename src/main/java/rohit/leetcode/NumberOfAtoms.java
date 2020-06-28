package rohit.leetcode;

import java.util.Map;
import java.util.TreeMap;

//formula = "Mg(OH)2"
//Output: "H2MgO2"

//formula = "K4(ON(SO3)2)2"
//Output: "K4N2O14S4"


public class NumberOfAtoms {
    int i;
    public String countOfAtoms(String formula) {
        i = 0;
        StringBuffer sb = new StringBuffer();

        Map<String,Integer> map = parse(formula);
        for(String key : map.keySet()){
            sb.append(key);
            if(map.get(key) > 1)
                sb.append(map.get(key));
        }

        return sb.toString();
    }

    private Map<String, Integer> parse(String formula) {
        int length = formula.length();
        Map<String, Integer> map = new TreeMap<>();
        while(i < length && formula.charAt(i)!=')'){
            if(formula.charAt(i) =='('){
                i++;
                Map<String, Integer> result = parse(formula);
                for(String key : result.keySet()){
                    map.put(key,map.getOrDefault(key,0)+result.get(key));
                }
            }else{
                int start = i++;

                while(i < length && Character.isLowerCase(formula.charAt(i))){
                    i++;
                }
                String name = formula.substring(start,i);

                start = i;
                while(i < length && Character.isDigit(formula.charAt(i))){
                    i++;
                }
                int num = (start == i)? 1 : Integer.valueOf(formula.substring(start,i));

                map.put(name,map.getOrDefault(name,0)+num);
            }
        }
        int start = ++i;

        while(i < length && Character.isDigit(formula.charAt(i))){
            i++;
        }
        if(start != i){
            int num = Integer.valueOf(formula.substring(start,i));
            for (String key : map.keySet()){
                map.put(key,map.get(key) * num);
            }

        }

        return map;
    }

}
