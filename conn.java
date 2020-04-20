import java.util.*;

class Conn{

    static void DFS(int [][] edges , Boolean []visited,int size,int sv){
            visited[sv]=true;
            for(int i=0;i<size;i++){
                if(visited[i]) continue;
                if(edges[sv][i]==1) {
                    DFS(edges, visited, size, i);
                }
            }
    }
    
     static Boolean isConn(int [][] edges,int size){
        Boolean [] visited=new Boolean[size];
        for(int i=0;i<size;i++)visited[i]=false;
        
            DFS(edges, visited, size, 0);
     
        Boolean conn=true;
        for (int i=0;i<size;i++)
            {
                if(visited[i]==false){
                    conn=false;
                    break;
                }
            } 
        return conn;  
    }


    public static void main (String args[]){
        Scanner s=new Scanner(System.in);
        int v,e;
        v=s.nextInt();
        e=s.nextInt();
        // create adj matrix;
        int [][]edges=new int[v][v];
        for (int i=0;i<v;i++){
            for(int j=0;j<v;j++) edges[i][j]=0;
        }
        // take edge conn
        for(int i=0;i<e;i++){
            int v1=s.nextInt();
            int v2=s.nextInt();
            edges[v1][v2]=1;
            edges[v2][v1]=1;
        }

        if(isConn(edges, v)) System.out.print(true);
        else System.out.print(false);
        s.close();
    }
}