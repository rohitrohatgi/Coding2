package rohit.leetcode;

import java.util.PriorityQueue;

public class TrappingRainWaterII {
    class Cell{
        int row;
        int col;
        int height;
        @Override
        public String toString() {
            return "Cell{" +
                    "row=" + row +
                    ", col=" + col +
                    ", height=" + height +
                    '}';
        }


        public Cell(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }

    }

    public int trapRainWater(int[][] heightMap) {
        int result = 0;
        if(heightMap == null || heightMap.length == 0 || heightMap[0].length == 0)
            return result;

        PriorityQueue<Cell> queue = new PriorityQueue<>((a,b) -> a.height - b.height);

        int r = heightMap.length;
        int c = heightMap[0].length;

        boolean[][] visited = new boolean[r][c];

        for(int i=0; i<r;i++){
            visited[i][0] = true;
            visited[i][c-1] = true;
            queue.offer(new Cell(i,0,heightMap[i][0]));
            queue.offer(new Cell(i,c-1,heightMap[i][c-1]));
        }

        for(int i=0; i<c;i++){
            visited[0][i] = true;
            visited[r-1][i] = true;
            queue.offer(new Cell(0,i,heightMap[0][i]));
            queue.offer(new Cell(r-1,i,heightMap[r-1][i]));
        }

        int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};

        while (!queue.isEmpty()){
            Cell cell = queue.poll();
            visited[cell.row][cell.col] = true;
            for(int[] dir : dirs){
                int x = cell.row + dir[0];
                int y = cell.col + dir[1];
                if(x >= 0 && x < r && y < c && y >= 0 && !visited[x][y]){
                    if(cell.height > heightMap[x][y]){
                        result += cell.height - heightMap[x][y];
                    }
                    visited[x][y] = true;
                    queue.offer(new Cell(x,y, Math.max(heightMap[x][y],cell.height)));
                }

            }

        }

        return result;
    }

    public static void main(String[] args) {
        TrappingRainWaterII trappingRainWaterII = new TrappingRainWaterII();
        int[][] input = {
                {1,4,3,1,3,2},
                {3,2,1,3,2,4},
                {2,3,3,2,3,1}
        };

        System.out.println(trappingRainWaterII.trapRainWater(input));
    }
}
