package rohit.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
There are 8 prison cells in a row, and each cell is either occupied or vacant.
Each day, whether the cell is occupied or vacant changes according to the following rules:

If a cell has two adjacent neighbors that are both occupied or both vacant, then the cell becomes occupied.
Otherwise, it becomes vacant.
(Note that because the prison is a row, the first and the last cells in the row can't have two adjacent neighbors.)

We describe the current state of the prison in the following way: cells[i] == 1 if the i-th cell is occupied, else cells[i] == 0.

Given the initial state of the prison, return the state of the prison after N days (and N such changes described above.)

Example 1:

Input: cells = [0,1,0,1,1,0,0,1], N = 7
Output: [0,0,1,1,0,0,0,0]
 */
public class PrisonCellsAfterNDays {
    public int[] prisonAfterNDays(int[] cells, int N) {

        int[] dp1 = cells;
        Set<String> store = new HashSet<>();
        int cycle = 0;
        boolean hasCycle = false;
        for(int i = 1; i <=N ; i++ ){
            int[] next = nextDay(dp1);
            String key = Arrays.toString(next);
            if(!store.contains(key)){
                store.add(key);
                cycle++;
            }else{
                hasCycle = true;
                break;
            }
            dp1 = next;
        }
        if(hasCycle){
            N %= cycle;
            for(int i = 0; i < N ; i++ ){
                dp1 = nextDay(dp1);
            }
        }

        return dp1;
    }
    public int[] nextDay(int[] cells){
        int[] dp1 = cells;
        int[] dp2 = new int[cells.length];
        for(int j = 1; j < (cells.length - 1) ; j++ ){
            dp2[j] = (dp1[j + 1] == dp1[j - 1] )? 1 : 0;
        }
        return dp2;
    }

}
