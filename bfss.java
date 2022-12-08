import java.util.*;
public class bfss {
    private LinkedList<Integer> adjecency[];
    public bfss(int v){
        adjecency=new LinkedList[v];
        for(int i=0;i<v;i++){
            adjecency[i]=new LinkedList<Integer>();
        }
    }
    public void insertedge(int s,int d){
        adjecency[s].add(d);
        adjecency[d].add(s);
    }
    public void bfs(int source){
    boolean visited_nodes[]=new boolean[adjecency.length];
    int parent_nodes[]=new int[adjecency.length];
    Queue<Integer> q=new LinkedList<>();
    q.add(source);
    visited_nodes[source]=true;
    parent_nodes[source]=-1;
    while(!q.isEmpty()){
        int p=q.poll();
        System.out.println(p);
        for(int i:adjecency[p]){
            if(visited_nodes[i]!=true){
                visited_nodes[i]=true;
                parent_nodes[i]=p;
                q.add(i);
             }
        }
    }
 }
 public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("enter the vertex & edges:");
        int v=sc.nextInt();
        int e=sc.nextInt();
        bfss g=new bfss(v);
        System.out.println("enter the edge connection:");
        for(int i=0;i<e;i++){
            int s=sc.nextInt();
            int d=sc.nextInt();
            g.insertedge(s,d);
        }
        System.out.println("enter the source to visit bfs:");
        int source=sc.nextInt();
        g.bfs(source);
    
    }
}
