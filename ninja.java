import java.io.*;
import java.util.*;

class Ninja {

    static PrintWriter o=new PrintWriter(System.out);

    public static void hasPath(char [][]matrix,int rowSize,int colSize,char []s){
            
    }



    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        int rows,cols;
        rows=s.nextInt();
        cols=s.nextInt();
        char[][] matrix=new char[rows][cols];
        for(int i=0;i<rows;i++){
            char []a =s.next().toCharArray();
            
            matrix[i]=a;
        }
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++)System.out.print(matrix[i][j]+" ");
            System.out.println();
        }

    }
}