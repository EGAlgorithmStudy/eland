package week6;

import java.io.*;
import java.util.*;

public class boj_1697 {

    static int K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs(N,0);

    }

    public static void bfs(int N, int moveCnt){
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visit = new boolean[100001];

        queue.add(new int[]{N,moveCnt});
        visit[N] = true;

        while(!queue.isEmpty()){
            int[] position = queue.poll();

            if(position[0]==K){
                System.out.println(position[1]);
                return;
            }
            if(position[0]-1>-1&&!visit[position[0]-1]){
                queue.add(new int[]{position[0]-1,position[1]+1});
                visit[position[0]-1] = true;
            }
            if(position[0]+1<100001&&!visit[position[0]+1]){
                queue.add(new int[]{position[0]+1,position[1]+1});
                visit[position[0]+1] = true;
            }
            if(position[0]!=0&&position[0]*2<100001&&!visit[position[0]*2]){
                queue.add(new int[]{position[0]*2,position[1]+1});
                visit[position[0]*2] = true;
            }

        }


    }

}
