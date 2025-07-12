public class PathWithMoreGold {
  public int getMaximumGold(int[][] grid) {
        boolean[][] isVisited=new boolean[grid.length][grid[0].length];
        int max=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]!=0)  max=Math.max(max,DFS(grid,i,j,isVisited));
            } 
        } return max;
    }
    private int DFS(int[][] grid,int i,int j,boolean[][] isVisited){
        if(i<0 || i==grid.length || j<0 || j==grid[0].length || isVisited[i][j] || grid[i][j]==0) return 0;
        isVisited[i][j]=true;
        int[][] dir={{0,1},{0,-1},{-1,0},{1,0}};
        int max=0;
        for(int[] d:dir) max=Math.max(max,DFS(grid,i+d[0],j+d[1],isVisited));
        isVisited[i][j]=false;
        return max+grid[i][j];
    }
}
