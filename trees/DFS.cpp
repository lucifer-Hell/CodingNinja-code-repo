#include <bits/stdc++.h>
using namespace std;

void printDFS(int ** edges,int v, int sv,int * visited){
    cout<<sv<<endl;
    // this vertex is now visited and will not be considered again
    visited[sv]=1;
    // iterate through and print them
    // their childs if they have conn
    for (int i=0;i<v;i++){
        // if comparing with start vertex just ignore
        if (sv==i) continue;
        if (edges[i][sv]==1){
            // if theres a match 
            // check its visited or not 
            if (visited[i]==1) continue;
            // if not visited
            printDFS(edges,v,i,visited);
        }


    }
    
}

void  print(int ** edges,int v,int sv){
    // create a visited array
    int * visited=new int [v];
    for (int i=0;i<v;i++) visited[i]=0;
    printDFS(edges,v,sv,visited);
   

    
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
   // print the matrix
   // array,no of v,start vertex
   print(edges,v,0);

 return 0;
}