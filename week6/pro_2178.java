package week6;

import java.io.*;
import java.util.*;

public class pro_2178 {
    static int N;
    static int M;

    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N= Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] maze = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            String line = br.readLine();
            for(int j=0; j<M; j++){
                maze[i][j] = line.charAt(j) - '0';
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(maze[i][j]==0){
                    visited[i][j] = true;
                }
            }
        }

        bfs(0,0,1);

    }

    public static void bfs(int x, int y, int moveCnt){
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{x,y,moveCnt});
        visited[x][y] = true;

        while(!queue.isEmpty()){
            int[] move = queue.poll();

            if(move[0]==N-1&&move[1]==M-1){
                System.out.println(move[2]);
            }

            int nowX = move[0];
            int nowY = move[1];
            int howManyMove = move[2];

            if(nowX+1<N&&!visited[nowX+1][nowY]){
                visited[nowX+1][nowY] = true;
                queue.add(new int[]{nowX+1,nowY,howManyMove+1});
            }
            if(nowX-1>=0&&!visited[nowX-1][nowY]){
                visited[nowX-1][nowY] = true;
                queue.add(new int[]{nowX-1,nowY,howManyMove+1});
            }
            if(nowY+1<M&&!visited[nowX][nowY+1]){
                visited[nowX][nowY+1] = true;
                queue.add(new int[]{nowX,nowY+1,howManyMove+1});
            }
            if(nowY-1>=0&&!visited[nowX][nowY-1]){
                visited[nowX][nowY-1] = true;
                queue.add(new int[]{nowX,nowY-1,howManyMove+1});
            }
        }



    }


}
