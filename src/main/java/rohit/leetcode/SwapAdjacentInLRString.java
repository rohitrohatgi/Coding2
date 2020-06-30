package rohit.leetcode;

public class SwapAdjacentInLRString {
    public boolean canTransform(String start, String end) {

        if (!start.replace("X", "").equals(end.replace("X", "")))
            return false;
        int p1 = 0;
        int p2 = 0;

        //loop until both have either one or both have not reached end
        while(p1 < start.length() && p2 < end.length()){
            //loop and skip X for start
            while(p1 < start.length() && start.charAt(p1) == 'X')
                p1++;

            //loop and skip X for end
            while(p2 < end.length() && end.charAt(p2) == 'X')
                p2++;


            //check if both are already at end - return true
            if(p1 == start.length() && p2 == end.length()){
                return true;
            }

            //check if only 1 is at end - return false
            if(p1 == start.length() || p2 == end.length()){
                return false;
            }
            //check if current char is different for start end if it is different - return false
            if(start.charAt(p1) !=  end.charAt(p2)){
                return false;
            }


            //check if current p1 has L and also check if p2 > p1 - retrun false
            if(start.charAt(p1) == 'L' && p2 > p1){
                return false;
            }

            //check if current p1 has R and also check if p2 < p1 - retrun false
            if(start.charAt(p1) == 'R' && p2 < p1){
                return false;
            }

            //increment p1 and p2
            p1++;
            p2++;

        }

        //return true it seems the strings can be transformed.
        return true;

    }
}
