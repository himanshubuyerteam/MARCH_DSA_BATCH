int countConnected(int V, ArrayList<ArrayList<Integer>> edges) {
        // code here
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        
        for(int i=0;i<V;i++)
        {
            graph.add(new ArrayList<>());
        }
        
        
        for(int i=0;i<edges.size();i++)
        {
            ArrayList<Integer> edge = edges.get(i);
            int u = edge.get(0);
            int v = edge.get(1);
            
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        boolean []vis = new boolean [V];

        int count = 0;
        for(int i=0;i<V;i++)
        {
            if(!vis[i])
            {
                dfs(i,graph,vis);
                count++;
            }
        }
        return count;
    }
    
    void dfs(int src,ArrayList<ArrayList<Integer>> graph,boolean []vis)
    {
        vis[src]=true;
        for(int nbr:graph.get(src))
        {
            if(!vis[nbr])
            {
                dfs(nbr,graph,vis);
            }
        }
    }
    
    
    
    public void dfs(int i,int j,char [][]grid)
    {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length )
        
            return;
        // if(vis[i][j]==true)
        //     return;
        if(grid[i][j]=='0')
            return;
        // vis[i][j]=true;
        grid[i][j]='0';
        dfs(i+1,j,grid);
        dfs(i-1,j,grid);
        dfs(i,j+1,grid);
        dfs(i,j-1,grid);
    }
    public int numIslands(char[][] grid) {
        // boolean [][]vis = new boolean [grid.length][grid[0].length];
        int count = 0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]=='1' )
                {
                    count++;
                    dfs(i,j,grid);
                }
            }
        }
        return count;
    }
    
   
   
   
   
   
   public int dfs(int i,int j,int [][]grid)
    {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length )
            return 0 ;
        // if(vis[i][j]==true)
        //     return;
        if(grid[i][j]==0)
            return 0 ;
        // vis[i][j]=true;
        grid[i][j]=0;
        int size = 1;
        size +=dfs(i+1,j,grid);
        size +=dfs(i-1,j,grid);
        size +=dfs(i,j+1,grid);
        size +=dfs(i,j-1,grid);
        return size;
    }
    public int maxAreaOfIsland(int[][] grid) {
        // boolean [][]vis = new boolean [grid.length][grid[0].length];
        int maxSize = 0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1 )
                {
                    int size = dfs(i,j,grid);
                    if(size>maxSize)
                        maxSize = size;

                }
            }
        }
        return maxSize;
    }

    class obj
    {
        int i;
        int j;
        int dist;
        obj(int i,int j,int dist)
        {
            this.i=i;
            this.j=j;
            this.dist=dist;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        boolean [][]vis = new boolean [mat.length][mat[0].length];

        int [][]ans = new int[mat.length][mat[0].length];

        ArrayDeque<obj> q= new ArrayDeque<>();

        for(int i=0;i<mat.length;i++)
        {
            for(int j=0;j<mat[0].length;j++)
            {
                if(mat[i][j]==0)
                {
                    q.add(new obj(i,j,0));
                }
            }
        }
        int [][]dir = {{0,1},{0,-1},{1,0},{-1,0}};
        while(q.size()>0)
        {
            //REMOVE
            obj fnt = q.removeFirst();
            //MARK
            if(vis[fnt.i][fnt.j]==true)
                continue;
            vis[fnt.i][fnt.j]=true;
            //WORK
            ans[fnt.i][fnt.j]=fnt.dist;
            //ADD
            for(int []d:dir)
            {
                int i = fnt.i+d[0];
                int j = fnt.j+d[1];

                if(i>=0 && j>=0 && i<mat.length 
                    && j<mat[0].length && mat[i][j]==1)
                {
                    q.add(new obj(i,j,fnt.dist+1));
                }
            }
            
        }

        return ans;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    