

// Java program to find minimum number of swaps 
// required to sort an array 
import java.util.*;
import java.io.*;

// Driver class 
class Main {
	// Driver program to test the above function 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while (t--> 0) {
			int n = Integer.parseInt(br.readLine().trim());
			String str[] = br.readLine().trim().split(" ");
			int[] a = new int[n];
			for (int i = 0; i<n; i++) {
				a[i] = Integer.parseInt(str[i]);
			}
			System.out.println(new GfG().minSwaps(a, n));
		}
	}
}// } Driver Code Ends




class GfG {
    // return the minimum number of swaps required to sort the arra
	
	public int minSwaps(int[] a, int n) {
	    // remember the p &c thing 
	    // if there are n elements in cycle
	    // then n-1 swaps are req to arrange them as last elemenet is 
	    // already arranged
	    
	    // 1--> making elements sorted on the basis of val
	    // the reason is to have the idx arry sorted 
	    // read further to understand
	    TreeMap<Integer,Integer> m=new TreeMap<>();
	    for(int i=0;i<n;i++){
	        m.put(a[i],i);
	    }
	    // 2--> getting the sorted idx array
	    // this is req to search for the cycle
	    int []idx=new int[n];
	    int i=0;
	    for(int val:m.values()){
	        idx[i++]=val;
	    }
	    // once all the idx sort 
	    //3-> final task is to find the cycle
	    // so that we can caluclate how many swaps 
	    // will be req to sort
	    int []visited=new int[n];
	    Arrays.fill(visited,-1);
	    int swaps=0;
	    for( i=0;i<n;i++){
	        // if i already visited skip
	        if(visited[i]!=-1)continue;
	        int start=i;
	        int j=i;
	       // create a node count
	       // add 1 as including the self node
	       int count=1;
	        // travel until u a again reach to index i
	        while(start!=idx[j]){
	            j=idx[j];
	            // increment the count
	            // as u visit new element and mark it visited
	            visited[j]=1;
	            count++;
	        }
	        swaps+=count-1;
	        
	    }
	    return swaps;
	   
	}
	
}
