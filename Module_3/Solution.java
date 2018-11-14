import java.util.ArrayList; 
import java.util.LinkedList; 
import java.util.List;
import java.util.Scanner; 

class Graph { 
   
 private final int V; 
 private final List<List<Integer>> adj; 
 
 public Graph(int V)  
 { 
     this.V = V; 
     adj = new ArrayList<>(V);     
     for (int i = 0; i < V; i++) 
         adj.add(new LinkedList<>()); 
 } 
  boolean isCyclicUtil(int i, boolean[]vi, boolean[] re)  
 {      
     if (re[i]) 
         return true; 

     if (vi[i]) 
         return false; 
           
    vi[i] = true; 

     re[i] = true; 
     List<Integer> children = adj.get(i); 
       
     for (Integer c: children) 
         if (isCyclicUtil(c,vi, re)) 
             return true; 
               
     re[i] = false; 
     return false;  
 }
  void addEdge(int source, int dest) { 
     adj.get(source).add(dest); 
 } 
  boolean isCyclic()  
 {          
	 boolean[]vi = new boolean[V]; 
     boolean[] re = new boolean[V]; 
     for (int i = 0; i < V; i++) 
         if (isCyclicUtil(i,vi, re)) 
             return true; 
     return false; 
 } 
 }
 class Cyclic{
 public static void main(String[] args) 
 { 
	 Scanner sc = new Scanner(System.in);
	 int t= Integer.parseInt(sc.nextLine());
	 int t1= Integer.parseInt(sc.nextLine());
     Graph g = new Graph(t);
     String s[] = new String[2];
     for(int i=0;i<t1;i++)
     {
    	String str = sc.nextLine();
    		if(!str.equals(""))
    	 s = str.split(" ");
    	int v= Integer.parseInt(s[0]);
    	int v1=Integer.parseInt(s[1]);
    	g.addEdge(v,v1);
     }   
     if(g.isCyclic()) 
         System.out.println("Cycle exists."); 
     else
         System.out.println("Cycle doesn't exists."); 
 } 
} 