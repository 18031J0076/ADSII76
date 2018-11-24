package ADSIIEXM;

import java.util.ArrayList;
import java.util.Scanner;

class Edge 
{
@Override
	public String toString() {
		return  " "+v + "-" + w + "  " + (float)weight +"0000"+"  ";
	}
 int v; int w;
 double weight;
 Edge(int v, int w, double weight)
{
this.v = v;
this.w = w;
this.weight = weight;
}
public int v()
{ return v; }
public int w()
{ return w; }
public double weight()
{ return  weight; }

}
class Graph
{
 private int V,c=0;;
 private ArrayList<Edge>[] adj;
 public Graph(int V)
 {
 this.V = V;
 adj = (ArrayList<Edge>[]) new ArrayList[V+1];
 for (int v = 0; v <=V; v++)
 adj[v] = new ArrayList<Edge>();
 }
 public void addEdge(int v,int w,double wa)
 {c++;
	  Edge e=new Edge(v,w,wa);
	  Edge e1=new Edge(v,w,wa);
 int v1 = e.v();
 int w1=e.v();
 int wa1=e.w();
 adj[v1].add(e);
 adj[wa1].add(e1);
 }
 public Iterable<Edge> adj(int v)
 { return adj[v]; }
 int V()
 {
	  return V;
 }
 public void display()
 {
	 System.out.println(V+" vertices "+c+" edges");
	 for(int i = 0;i<V-1;i++)
	 {System.out.print(i +" :");
		 for(int j=adj[i].size()-1;j>=0;j--)
		 {
			System.out.print(adj[i].get(j));
		 }
		 System.out.println();
		 
	 }
	 
 }
 class Bellman
 {
 	   boolean marked[];
 	    Edge[] edgeto;
 		double distto[];
 		double d;
 		Bellman(Graph e,int s)
 		{
 			distto =new double[e.V()];
 			edgeto =new Edge[e.V()];
 			for(int i=0;i<e.V();i++)
 			{
 				distto[i]=Double.POSITIVE_INFINITY;
 				
 			}
 			distto[s]=0.0;
 			 
 				   relax(e);
 		}
 		public void display(int m) {
 			for(int i=0;i<distto.length;i++)
 			{		
 				if(i==m)
 					System.out.println(distto[i]);
 				
 			}
 		}

 		void relax(Graph G)
 		 {
 			 for (int i = 1; i <= G.V(); i++)
 				 for (int v = 0; v < G.V(); v++)
 				 for (Edge e : G.adj(v))
 				 {
 				 int w = e.w();
 				 if (distto[w] > distto[v] + e.weight())
 				 {
 				 distto[w] = distto[v] + e.weight();
 				 edgeto[w] = e;
 				 }
 				 }
 		 }
    }	
}
public class AmazonTransport {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
     int n1 = sc.nextInt();
     int n2 = sc.nextInt();
     Graph g = new Graph(n1);
     String str[] = new String[3];
     for(int i=0;i<=n2;i++)
     {
    	 String s = sc.nextLine();
    	 if(!s.equals("")) {
			 str = s.split(" ");}
    	 if(str[0]!=null&&str[1]!=null&&str[2]!=null) {
    	 g.addEdge(Integer.parseInt(str[0]), Integer.parseInt(str[1]), Integer.parseInt(str[2]));}
    	// g.display(n2);
     }
     String type = sc.nextLine();
    // System.out.println(type);
     switch(type)
		{
			case "Graph":
			{
	    	     g.display();
	             break;
			}
			case "DirectedPaths":
				String t = sc.nextLine();
				String[] d = t.split(" ");
				Bellman b=new Bellman(g,Integer.parseInt(d[0]));
				b.display(Integer.parseInt(d[1]));

}
	}
}
