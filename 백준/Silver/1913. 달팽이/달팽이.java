import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int findNumber = Integer.parseInt(br.readLine());
		int x = n / 2; 
		int y = n / 2;
		
		int[][] snail = new int[n][n];
		StringBuilder answer = new StringBuilder();
		
		int number = 1;
		// 첫번째 위치에 1 입력
		snail[x][y] = number++;
		
		int move = 0;
		int total = 1;
		int[] index = new int[2];
		while(true) {
			if(number > (n*n)) break;
			// 위
			if(total%4 == 1) {
				move++;
				for(int j=0;j<move;j++) {
					snail[--x][y] = number++;
					if(snail[0][0] != 0) break;
				}
			}
			else if(total%4 == 2) {
				for(int j=0;j<move;j++)snail[x][++y] = number++; 
			}
			else if(total%4 == 3) {
				move++;
				for(int j=0;j<move;j++)snail[++x][y] = number++;
			}
			else if(total%4 == 0) {
				for(int j=0;j<move;j++) snail[x][--y] = number++;
			}
			total++;
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				answer.append(snail[i][j] + " ");
				if(findNumber == snail[i][j]) {index[0] = i+1; index[1] = j+1;}
			}
			
			answer.append("\n");
		}
		answer.append(index[0]+ " " + index[1]);
		System.out.println(answer.toString());

	}

}