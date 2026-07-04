class Edge
{
    int v;
    int w;
    Edge(int v,int w)
    {
        this.v=v;
        this.w=w;
    }
}
class data
{
    int node;
    int wt;
    data(int node,int wt)
    {
        this.node=node;
        this.wt=wt;
    }
}
public int[] dijkstra(int V, int[][] edges, int src) {
    // code here
    ArrayList<ArrayList<Edge>>graph = new ArrayList<>();
    boolean []vis = new boolean [V];
    for(int i=0;i<V;i++)
    {
        graph.add(new ArrayList<>());
    }
    
    for(int []e:edges)
    {
        int u = e[0];
        int v=e[1];
        int w=e[2];
        
        graph.get(u).add(new Edge(v,w));
        graph.get(v).add(new Edge(u,w));
    }
    int [] dist = new int[V];
    Arrays.fill(dist,Integer.MAX_VALUE);
    PriorityQueue<data>pq = new PriorityQueue<>((a,b)->a.wt-b.wt);
    pq.add(new data(src,0));
    while(pq.size()>0)
    {
        //REMOVE
        data fnt = pq.remove();
        int node = fnt.node;
        int wt = fnt.wt;
        //MARK*
        if(vis[node])
            continue;
        vis[node]=true;
        //WORK
        dist[node]=wt;
        //ADD*
        for(Edge e:graph.get(fnt.node))
        {
            int edge_wt = e.w;
            int v = e.v;
            if(!vis[v])
            {
                pq.add(new data(v,wt+edge_wt));
            }
        }
    }
    return dist;
}