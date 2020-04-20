import java.util.*;
import java.io.*;

class GetPath{
    public static PrintWriter o=new PrintWriter(System.out);



    public static void bfs(int [][]edges,int size,int sv,int ev,Boolean []visited,Boolean found ){
            // create a hash map
           
            HashMap <Integer,Integer> m=new HashMap<>();
            // base case 
            if (sv==ev){
                o.print(sv);
               
            }
            // create a queue
            Queue <Integer > q =new LinkedList<>();
            q.add(sv);
            
            visited[sv]=true;
            
            while((q.isEmpty()==false) && (found==false)){
                // check for the each element
               
                int front = q.peek();
               q.remove();
                for (int i=0;i<size;i++){
                   
                    if(visited[i])continue;
                    if(edges[i][front]==1){
                            visited[i]=true;
                           
                            q.add(i);
                            m.put(i,front);
                            if(i==ev) {
                                
                                found=true;
                                break;
                            }

                    }

                }
               

            }

            if ((m.isEmpty()==false)&& (found)){
                o.print(ev+" ");
                int val=m.get(ev);
                while(val!=sv){
                    o.print(val+" ");
                    val=m.get(val);
                }
                o.print(val+" ");
            }
            
    }

    public static void getPath(int [][]edges,int size,int sv,int ev){
        
        Boolean [] visited=new Boolean [size];
        for(int i=0;i<size;i++) visited[i]=false;
        Boolean found=false;
        bfs(edges, size, sv, ev, visited,found);
       
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
        int sv,ev;
        sv=s.nextInt();
        ev=s.nextInt();
        getPath(edges, v, sv, ev);
        s.close();
        o.close();
    }
   
}