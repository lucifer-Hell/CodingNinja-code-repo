import java.util.*;
import java.io.*;
class Components{ 

    static PrintWriter o=new PrintWriter(System.out);
    static void DFS(int [][] edges , Boolean []visited,int size,int sv,ArrayList <Integer>comps){
          
            visited[sv]=true;
            comps.add(sv);
            for(int i=0;i<size;i++){
                if(visited[i]) continue;
                if(edges[sv][i]==1) {
                    DFS(edges, visited, size, i,comps);
                }
            }
    }
    
     static void allComponents(int [][] edges,int size){
        Boolean [] visited=new Boolean[size];

        for(int i=0;i<size;i++)visited[i]=false;
        ArrayList <ArrayList<Integer>> allComps=new ArrayList<>();
        
        for(int i=0;i<size;i++){
            if(visited[i]) continue;
            ArrayList <Integer> comps=new ArrayList<>();
            DFS(edges, visited, size, i,comps);
            Collections.sort(comps);
            allComps.add(comps);
        }
        
        for(int i=0;i<allComps.size();i++){
               for(int j=0;j<allComps.get(i).size();j++){
                   
                   o.print((allComps.get(i)).get(j)+" ");
               }  
               o.println();
        }
       
      
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
        allComponents(edges, v);
        s.close();
        o.close();
    }
}