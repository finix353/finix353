import java.util.*;
public class ford {
    private  int  D[];
    private int v;
    public static final int m=999;
    public ford(int v){
        this.v=v;
        D=new int[v+1];

    }
    public void belmanFord(int source,int A[][]){
        for(int i=1;i<=v;i++){
            D[i]=m;
        }
     D[source]=0;

     for(int i=1;i<=v-1;i++){
        for(int s=1;s<=v;s++){
            for(int d=1;d<=v;d++){

           if(A[s][d]!=m){
             if(D[d]>D[s]+A[s][d]){
               D[d]=D[s]+A[s][d];
              }
            }
         }
       }
    }
    for(int s=1;s<=v;s++){
        for(int d=1;d<=v;d++){
              
            if(A[s][d] !=m){
                 
                if(D[d] > D[s]+A[s][d]){
                    System.out.println("The graph contains negative edge cycle");
                }
            }
        }
    }

    for(int g=1;g<=v;g++){
        System.out.println("Distance of source"+source+"to"+g+"is"+D[g]);
    }
}




    public static void main(String[] args) {
        int v=0;
        int source;
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the vertices:");
        v=sc.nextInt();

        int A[][]=new int[v+1][v+1];
        System.out.println("enter the adjecency matrix:");

        for(int s=1;s<=v;s++){
            for(int d=1;d<=v;d++){
                A[s][d]=sc.nextInt();
                
                if(s==d){

                    A[s][d]=0;
                }
                if(A[s][d] == 0){
                    A[s][d]=m;
                }
            }
        }
       System.out.println("enter the source:");
       source=sc.nextInt();
       ford g=new ford(v);
       g.belmanFord(source,A);

      sc.close();



    }
    
}
