#include <bits/stdc++.h>
using namespace std;

void printBFS(int **edges, int v,int sv,int * visited){
  
    visited[sv]=1;
    // create a queue
    queue<int> q;
    int start =sv;
    // if not done q will initially be empty
    q.push(sv);
    
    while(q.empty()==false){
    
     start = q.front();
     cout<<start<<endl;
     for (int i=0;i<v;i++)
        {
                if (visited[i]==1) continue;
                if(edges[i][start]==1){
                    q.push(i);
                    visited[i]=1;
                   
                } 
      }

      q.pop();
   
    

   }
   

}



void print(int **edges,int v,int sv){

    int * visited =new int [v];
    for (int i=0;i<v;i++) visited[i]=0;
    printBFS(edges,v,sv,visited);
    // also further print for the remaining vertex
    for (int i=0;i<v;i++){
        if (visited[i]==1 || i==sv) continue;
        else {
            printBFS(edges,v,i,visited);
        }
    }
    // free memory
    delete [] visited ;

}

int main(){

     // vertices and edges
    int v,e;
    cin>>v>>e;
    
    // intialize our adjacency matrix
    int ** edges=new int *[v];
    for (int i=0;i<v;i++) edges[i]=new int [v];

    // remove the garbage values
    for (int i=0;i<v;i++)
        {   
            for (int j=0;j<v;j++){
                edges[i][j]=0;
                
            }
        }

  
    // take the inputs
    for (int j=0;j<e;j++){
        int v1,v2;
        cin>>v1>>v2;
        edges[v1][v2]=1;
        edges[v2][v1]=1;
        
    }


    print(edges,v,0);


    delete [] edges;


}