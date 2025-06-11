package week10;

import java.io.*;
import java.util.*;

//어차피 한번 이어진 애들은 계속 이어짐. (한 덩이가 됨)
public class pro_16234 {

    static int[][] map;
    static boolean[][] visited;
    static int N,L,R;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        int day = 0;

        map = new int[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean isMove = true;

        while(isMove){
            visited = new boolean[N][N];

            isMove =false;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(!visited[i][j]){
                        if(move(i,j)){
                            isMove =true;
                        }
                    }
                }
            }

            if(!isMove){
                break;
            }
            day++;
        }

        System.out.println(day);

    }


    public static boolean move(int x,int y){
        Queue<int[]> queue = new LinkedList<>();
        List<int[]> union = new ArrayList<>();
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};


        queue.add(new int[]{x,y});
        union.add(new int[]{x,y});
        visited[x][y] =true;

        int unionPeople = map[x][y];

        while(!queue.isEmpty()){
            int[] nowPos = queue.poll();

            int nowX = nowPos[0];
            int nowY = nowPos[1];

            for(int i=0; i<4; i++){
                if(nowX+dx[i]>=0&&nowX+dx[i]<N&&nowY+dy[i]>=0&&nowY+dy[i]<N&&!visited[nowX+dx[i]][nowY+dy[i]]){
                    int diffPeople = Math.abs(map[nowX][nowY] - map[nowX+dx[i]][nowY+dy[i]]);
                    if(diffPeople>=L&&diffPeople<=R){
                        queue.add(new int[]{nowX+dx[i],nowY+dy[i]});
                        union.add(new int[]{nowX+dx[i],nowY+dy[i]});
                        visited[nowX+dx[i]][nowY+dy[i]] = true;
                        unionPeople += map[nowX+dx[i]][nowY+dy[i]];
                    }
                }
            }
        }
        if(union.size()==1){        //자기자신만 연합이면 이동 x
            return false;
        }

        int avgPeople = unionPeople/union.size();
        for(int i=0; i<union.size(); i++){
            int[] nation = union.get(i);
            map[nation[0]][nation[1]] = avgPeople;
        }

        return true;
    }

}
