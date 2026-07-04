//Leetcode 207
public boolean canFinish(int noc, int[][] prerequisites) {
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    LinkedList<Integer>q = new LinkedList<>();
    ArrayList<Integer>topo = new ArrayList<>();


    int []indegree = new int[noc];
    for(int i=0;i<noc;i++)
        graph.add(new ArrayList<>());

    for(int e[]:prerequisites)
    {
        int a = e[0];
        int b = e[1];
        graph.get(a).add(b);  // graph.get(b).add(a);
        indegree[b]++;
    }

    for(int i=0;i<indegree.length;i++)
    {
        if(indegree[i]==0)
            q.add(i);
    }

    while(q.size()>0)
    {
        int fnt = q.remove();
        topo.add(fnt);
        
        for(int nbr:graph.get(fnt))
        {
            indegree[nbr]--;
            if(indegree[nbr]==0)
                q.add(nbr);
        }
    }
    if(topo.size()==noc)
        return true;
    return false;
}

// Leetcode 210

public int[] findOrder(int noc, int[][] prerequisites) {
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    LinkedList<Integer>q = new LinkedList<>();
    ArrayList<Integer>topo = new ArrayList<>();
    int []indegree = new int[noc];
    for(int i=0;i<noc;i++)
        graph.add(new ArrayList<>());

    for(int e[]:prerequisites)
    {
        int fe = e[0];
        int se = e[1];
        graph.get(fe).add(se);
        indegree[se]++;
    }

    for(int i=0;i<indegree.length;i++)
    {
        if(indegree[i]==0)
            q.add(i);
    }

    while(q.size()>0)
    {
        int fnt = q.remove();
        topo.add(fnt);
        
        for(int nbr:graph.get(fnt))
        {
            indegree[nbr]--;
            if(indegree[nbr]==0)
                q.add(nbr);
        }
    }

    if(topo.size()!=noc)
    {
        int [] baseCase = new int[0];
        return baseCase;
    }
    int []fans = new int[topo.size()];
    int k = topo.size()-1;
    for(int i=0;i<fans.length;i++,k--)
        fans[i]=topo.get(k);
    return fans;
}