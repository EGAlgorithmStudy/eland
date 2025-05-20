package week7;

import java.util.*;

public class pro_159993 {


    class Solution {

        static int answer = 0;
        static int root = 0;
        static boolean visited[][];
        static int n,m;
        public int solution(String[] maps) {
            n = maps.length;
            m = maps[0].length();
            int[] startPoint = new int[2];
            int[] leverPoint = new int[2];

            char[][] map = new char[n][m];


            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    map[i][j] = maps[i].charAt(j);
                    if(maps[i].charAt(j)=='S'){
                        startPoint[0] = i;
                        startPoint[1] = j;
                    }
                    if(maps[i].charAt(j)=='L'){
                        leverPoint[0] = i;
                        leverPoint[1] = j;
                    }
                }
            }


            findChar(startPoint[0],startPoint[1],map,'L');

            if(root!=0){
                answer += root;
                findChar(leverPoint[0],leverPoint[1],map,'E');
                if(root!=0){
                    answer +=root;
                }
                else{
                    answer = -1;
                }
            }
            else{
                answer = -1;
            }



            return answer;
        }


        public static void findChar(int startX, int startY,char[][] map,char target){
            root = 0;
            Queue<int[]> queue = new LinkedList<>();
            visited = new boolean[n][m];
            queue.add(new int[]{startX,startY,0});
            visited[startX][startY] = true;
            int[] dx = {1,-1,0,0};
            int[] dy = {0,0,1,-1};


            //레버 찾기
            while(!queue.isEmpty()){
                int[] nowPos = queue.poll();

                int x = nowPos[0];
                int y = nowPos[1];

                if(map[x][y]==target){
                    root = nowPos[2];
                    break;
                }

                for(int i=0; i<4; i++){
                    if(x+dx[i]>=0&& x+dx[i]<n && y+dy[i]>=0 && y+dy[i]<m){
                        if(!visited[x+dx[i]][y+dy[i]] && map[x+dx[i]][y+dy[i]]!='X'){
                            visited[x+dx[i]][y+dy[i]]= true;
                            queue.add(new int[]{x+dx[i],y+dy[i],nowPos[2]+1});
                        }
                    }
                }
            }
        }


    }
}
