import java.util.*;
public class Dijkastra {

    private static void dijkastra(int[][]  adjecencyMatrix){
      int v=adjecencyMatrix.length;
      boolean visited[]=new boolean[v];
      int distance[]=new int[v];
      distance[0]=0;
      for(int i=1;i<v;i++){
          distance[i]=Integer.MAX_VALUE;

      }
      for(int i=0;i<v-1;i++){
        //find vertex with min distance
        int minVertex=findMinVertex(distance,visited);
        visited[minVertex]=true;

        //explore neighbours
        for(int j=0;j<v;j++){
          if(adjecencyMatrix[minVertex][j] != 0 && !visited[j] && distance[minVertex] != Integer.MAX_VALUE){
            int newDist=distance[minVertex] + adjecencyMatrix[minVertex][j];
            if(newDist< distance[j]){
              distance[j]=newDist;
            }
          }
        }
      }
     //print 
     for (int i=0;i<v;i++){
      System.out.print("shortest path of the graph is:");
      System.out.println(i+" "+distance[i]);
     }
     


    }
   private static int findMinVertex(int[] distance,boolean visited[]){
       int minVertex=-1;
       for(int i=0;i<distance.length;i++){
        if(!visited[i] && (minVertex ==-1 || distance[i]<distance[minVertex])){
          minVertex=i;
        }
       }
  return minVertex;
 } 

public static void main(String[] args) {
  
    Scanner sc=new Scanner(System.in);
    //vertex &edges
    System.out.println("enter the vertices & edges:");
     int v=sc.nextInt();
     int e=sc.nextInt();
     int adjacencyMatrix[][]=new int[v][v];
     for(int i=0;i<e;i++){
      System.out.println("enter the connection & weights:");
        int s=sc.nextInt();
        int d=sc.nextInt();
        int weight=sc.nextInt();
        adjacencyMatrix[s][d]=weight;
        adjacencyMatrix[d][s]=weight;
     }
     System.out.println("enter the source:");
     int source=sc.nextInt();
     


    dijkastra(adjacencyMatrix);
}
}








