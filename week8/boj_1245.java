package week8;

import java.io.*;
import java.util.*;
//bfs를 돌다가 8방향 모두 자신보다 작은 값이면 봉우리가 확정이니까 봉우리로 체크하고
//8방향중 자신과 같거나 더 큰 값이 존재하면 그 좌표로 이동해서 다시 8방향을 체크하고 그랬을 때 더 큰값이 존재하지 않으면 봉우리 인걸로 체크

public class boj_1245 {

    static int N;
    static int M;
    static int count = 0;
    static int[][] farm;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        farm = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                farm[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    howManyPeak(i, j);
                }
            }
        }

        System.out.print(count);

    }

    public static void howManyPeak(int x, int y){
        int[] dx = {1,1,1,-1,-1,-1,0,0};
        int[] dy = {0,1,-1,0,1,-1,1,-1};

        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{x,y});
        visited[x][y] = true;
        int nowPosHeight = farm[x][y];
        boolean isPeak = true;

        while(!queue.isEmpty()) {
            int[] pos = queue.poll();
            for (int i = 0; i < 8; i++) {
                if(pos[0]+dx[i]>=0&&pos[0]+dx[i]<N&&pos[1]+dy[i]>=0&&pos[1]+dy[i]<M){
                    if(farm[pos[0]+dx[i]][pos[1]+dy[i]]>nowPosHeight){      //8방향 중 지금 높이 보다 큰놈이 하나라도 있으면
                        isPeak = false;
//                        break;
//                        이거 있으면 8방향 조사하기 전에 나와서 visited이 제대로 갱신이 안됨.
                    }
                    else if(!visited[pos[0]+dx[i]][pos[1]+dy[i]]&&farm[pos[0]+dx[i]][pos[1]+dy[i]]==nowPosHeight){      //같고 안간데면
                        visited[pos[0]+dx[i]][pos[1]+dy[i]] = true;
                        queue.add(new int[]{pos[0]+dx[i],pos[1]+dy[i]});
                    }
                }
            }
        }
        if(isPeak){

            count++;
        }
    }

}
