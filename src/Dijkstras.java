import static java.lang.Integer.MAX_VALUE;

import java.util.*;

public class Dijkstras{
	public static void main(String args[]){
		
		Scanner scan = new Scanner(System.in);
		int matrix[][] = new int[4][4];
		int [] distance = new int[4];
		int[] visited = new int[4];
		int[] preD = new int[4];
		int min;
		int nextNode = 0;
		System.out.println("Please enter the matrix");
		for (int i=0; i<4;i++){
			visited[i] = 0;
			preD[i]=0;
//			for (int j=0;j<4;j++){
//				matrix[i][j]= scan.nextInt();
//				if(matrix[i][j] == 0){
//					matrix[i][j] = 999;
//				}
//			}
			
		}
		
		for(int i = 0; i<4; i++){
	   		for(int j = 0; j<4; j++)
	   		{
	   			if( i!=j && matrix[i][j]!=MAX_VALUE )  //graph[i][j] == 0s
	   			{
	   				Random rand = new Random();
	   				//graph[i][j] = ;//int randomNumber=(rand.nextInt(65536)-32768);
	   				matrix[i][j] = matrix[j][i]=(rand.nextInt(100)-20);
	   			}
	   		}}
		
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
			System.out.print("|" + distance[i]);
		}
		System.out.print("|");
		
		for(int i= 0; i<4;i++){
			int j;
			System.out.print("Path = "+i);
			j = i;
			
			do{
				j=preD[j];
				System.out.print(" <-- " +j);
			}while(j != 0);
			
			System.out.println();
			
		}
		
	}
	
}