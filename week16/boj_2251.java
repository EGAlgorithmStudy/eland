package week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_2251 {
	static TreeSet<Integer> set;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		set = new TreeSet<>();

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		bfs(A, B, C);

		for(int i:set){
			System.out.print(i+" ");
		}
	}


	public static void bfs(int A,int B, int C){
		Queue<waterBottle> queue = new LinkedList<>();

		//A랑B물 저장
		boolean[][] visited = new boolean[A+1][B+1];

		queue.add(new waterBottle(0,0,C));
		visited[0][0] = true;

		while(!queue.isEmpty()){
			waterBottle waterBottle = queue.poll();

			int[] limit = {A, B, C};
			int a = waterBottle.A;
			int b = waterBottle.B;
			int c = waterBottle.C;

			if(a==0){
				set.add(c);
			}

			for(int i=0; i<3; i++){
				for(int j=0; j<3; j++){
					if(i!=j){		//다른 물통에 물 넣을 때
						int[] nextWater = {a,b,c};

						int moveWater = Math.min(nextWater[i],limit[j]-nextWater[j]);
						nextWater[i] -= moveWater;
						nextWater[j] += moveWater;

						int newA = nextWater[0];
						int newB = nextWater[1];
						int newC = nextWater[2];

						if(!visited[newA][newB]){
							visited[newA][newB] = true;
							queue.add(new waterBottle(newA,newB,newC));
						}
					}
				}
			}

		}

	}


	static class waterBottle{
		int A;
		int B;
		int C;

		public waterBottle(int A, int B, int C) {
			this.A = A;
			this.B = B;
			this.C = C;
		}
	}
}
