import java.util.*;
// import java.io.*;






class Cycle {
    static int countCycles(int adj,int sv,int size,int [][]edges){
        int cycles=0;
        for (int i=0;i<size;i++){
            if(i==adj || i==sv) continue;
            if (edges[sv][i]==1) cycles++;
        }
        return cycles;
    }

    static int count(int sv,int size,int [][]edges){
        
        int cycles=0;
        for(int i=0;i<size;i++){
            if (i==sv) continue;
            if (edges[i][sv]==1){
                cycles+=countCycles(i,sv,size,edges);
            } 
        }

        return cycles;
    }

    static int totalCycles(int size,int [][]edges){
        int cycles=0;
        for (int i=0;i<size;i++ ){
            cycles+=count(i, size, edges);
        }
        return cycles/6;
    }


    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        int n,m;
        n=s.nextInt();       
        m=s.nextInt();       
        int [][] edges=new int [m][m];
        for (int i=0;i<m;i++)
            for(int j=0;j<m;j++)
                edges[i][j]=0;
        int []arr1=new int[n];
        int []arr2=new int[n];
        for (int i=0;i<n;i++)
            {
                int v1=s.nextInt();
                arr1[i]=v1;
            }
            for (int i=0;i<n;i++)
            {
                int v1=s.nextInt();
                arr2[i]=v1;
            }


        for(int i=0;i<n;i++)
            {
                int v1,v2;
                v1=arr1[i];       
                v2=arr2[i];
                edges[v1-1][v2-1]=1;
                edges[v2-1][v1-1]=1;
            }

            s.close();
            int ans=totalCycles(m,edges);
            System.out.println(ans);


    }



}