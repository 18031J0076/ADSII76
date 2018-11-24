import java.io.*; 
import java.util.*; 
class Graph 
{ 
    private int V;   
    private LinkedList<Integer> adj[];  
    Graph(int v) 
    { 
        V = v; 
        adj = new LinkedList[v]; 
        for (int i=0; i<v; ++i) 
            adj[i] = new LinkedList(); 
    }  
    void addEdge(int v,int w) 
    { 
        adj[v].add(w);
        adj[w].add(v);
    } 
    void BFS(int s,int num) 
    { 
    	if(s==num)
    		System.out.println(0);
    	else {
    	int count=0;
        boolean visited[] = new boolean[V]; 
        LinkedList<Integer> queue = new LinkedList<Integer>(); 
        visited[s]=true; 
        queue.add(s); 
  
        while (queue.size() != 0) 
        { 
            s = queue.poll(); 
            Iterator<Integer> i = adj[s].listIterator(); 
            while (i.hasNext()) 
            { 
                int n = i.next(); 
                if (!visited[n]) 
                { 
                    visited[n] = true;
                    if(n==num) {
                    	//count--;
                    System.out.println(count);}
                    else count++;
                    queue.add(n); 
                } 
            } 
        }
    }
    }
   // void distance(int )
}
public class SocialNetworkingGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner sc = new Scanner(System.in);
			//int v= Integer.parseInt(sc.nextLine());
			//int v1= Integer.parseInt(sc.nextLine());
		String m = sc.nextLine();
		String st[] = m.split(" ");
		int v = Integer.parseInt(st[0]);
		int v1 = Integer.parseInt(st[1]);
			Graph g = new Graph(v);
			for(int i=0;i<v1;i++)
			{
				String state = sc.nextLine();
				String s[] = state.split(" ");
				g.addEdge(Integer.parseInt(s[0]),Integer.parseInt(s[1]));
			}
			int num = sc.nextInt();
			//System.out.println(num);
			String ss1[] = new String[2];
			for(int i=0;i<=num;i++)
			{
				String ss = sc.nextLine();
				if(!ss.equals("")) {
				 ss1 = ss.split(" ");}
				if(ss1[0]!=null&&ss1[1]!=null) {
					int sor = Integer.parseInt(ss1[0]);
					int des = Integer.parseInt(ss1[1]);
				     g.BFS(sor,des);
			                                    }
				}
			
	}
}