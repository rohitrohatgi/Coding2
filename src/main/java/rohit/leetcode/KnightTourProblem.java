package rohit.leetcode;

public class KnightTourProblem {
    public boolean solveKnightTour(int[][] board){

        //default all cells to -1
        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board[0].length ; j++){
                board[i][j] = -1;
            }
        }
        //set first cell as 0
        board[0][0] = 0;
       //  printSolution(board);
        return backtrack(board,1,0,0);
    }
    int[][] directions = {
            {2,1},//
            {1,2},//
            {-1,2},//
            {-2,1},//
            {-2,-1},//
            {-1,-2},//
            {1,-2},//
            {2,-1}//
    };
    /*int[][] directions = {
            {-2,1}, //
            {-2,-1}, //
            {2,1}, //
            {2,-1}, //
            {-1,2}, //
            {1,2}, //
            {-1,-2}, //
            {1,-2} //
    };
*/
    private boolean backtrack(int[][] board, int n, int row, int col) {
        //System.out.println(n +" "+ row +" " + col);
        if( n == board.length * board[0].length){
            return true;
        }
        for(int[] dir : directions){
           /* int r = row + dir[0];
            int c = col + dir[1];
            if(isSafe(r,c,board)){
                board[r][c] = n;
                if(backtrack(board,n + 1,r,c)){
                    return true;
                }else {
                    board[r][c] = -1;
                }
            }*/
            int next_x = row + dir[0];
            int next_y = col + dir[1];
            if (isSafe(next_x, next_y, board)) {
                board[next_x][next_y] = n;
                if (backtrack(board, n+1,next_x, next_y))
                    return true;
                else
                   board[next_x][next_y] = -1;// backtracking
            }
        }
        return false;
    }

    private boolean isSafe(int row, int col, int sol[][]) {
        return (row >= 0 && row < sol.length && col >= 0 &&
                col < sol[0].length && sol[row][col] == -1);
    }

    public static void main(String[] args) {
        int[][] sol = new int[8][8];
        KnightTourProblem knightTourProblem = new KnightTourProblem();
        System.out.println(knightTourProblem.solveKnightTour(sol));
        printSolution(sol);
    }
    /* A utility function to print solution
      matrix sol[N][N] */
    static void printSolution(int sol[][]) {
        for (int x = 0; x < sol.length; x++) {
            for (int y = 0; y < sol[0].length; y++)
                System.out.print(sol[x][y] + " ");
            System.out.println();
        }
    }
}
