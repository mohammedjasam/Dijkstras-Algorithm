import static java.lang.Integer.MAX_VALUE;

import java.util.*;

public class Dijkstras{
	static long startTime = System.currentTimeMillis();
	public static void main(String args[]){
		
		int matrix[][] = new int[4][4];
		int [] distance = new int[4];
		int[] visited = new int[4];
		int[] preD = new int[4];
		int min;
		int nextNode = 0;
		
		for (int i=0; i<4;i++){
			visited[i] = 0;
			preD[i]=0;
		}
		//Creating a Random Graph with Positive and Negative Weights
		for(int i = 0; i<4; i++){
	   		for(int j = 0; j<4; j++)
	   		{
	   			if( i!=j && matrix[i][j]!=MAX_VALUE )  
	   			{
	   				Random rand = new Random();
	   				matrix[i][j] = matrix[j][i]=(rand.nextInt(100)-20);
	   			}
	   			
	   		}}
		
		for (int i = 0; i < 4; i++) {
		    for (int j = 0; j < 4; j++) {
		        System.out.print(matrix[i][j] + " ");
		    }
		    System.out.println();
		    
		}
		
		distance = matrix[0];
		distance[0] = 0;
		visited[0]=1;
		for (int i = 0; i<4;i++){
			min = 999;
			for (int j=0;j<4;j++){
				if(min > distance[j] && visited[j] != 1  ){
					min = distance[j];
					nextNode = j;
				}
			}
			visited[nextNode] = 1;
			
			for (int a = 0; a<4;a++){
				if (visited[a] != 1){
					if(min+matrix[nextNode][a] < distance[a]){
						distance[a] = min+matrix[nextNode][a];
						preD[a] = nextNode;
						
					}
		}

			}
		}
		
		for (int i =0;i<4;i++){
			if(distance[i]>0)
			System.out.print("|" + distance[i]);
			else 
				System.out.println("");
		}
		System.out.println("|");
		
		for(int i= 0; i<4;i++){
			int j;
			if(distance[i]>=0){
			System.out.print("Path = "+i);
			j = i;
			
			do{
				j=preD[j];
				System.out.print(" <-- " +j);
			}while(j != 0);}
			else
				System.out.println("The Edges have negative weight, Dijkstra's algorithm cannot work for this Path!");
			System.out.println();
			 long endTime   = System.currentTimeMillis();
		    	long totalTime = endTime - startTime;
		    
		    	System.out.println("The Time Taken is... " + totalTime + " ms");
			
			
		}
		
	}
	
}