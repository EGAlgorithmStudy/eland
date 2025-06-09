package week10;

import java.util.*;

public class pro_1844 {
    class Solution {
        static int answer = -1;
        static int n,m;
        static boolean[][] visited;
        public int solution(int[][] maps) {

            n = maps.length;
            m = maps[0].length;

            visited = new boolean[n][m];

            ROR(maps);

            return answer;
        }

        public static void ROR(int[][] maps){
            Queue<int[]> queue = new LinkedList<>();

            int[] dx = {1,-1,0,0};
            int[] dy = {0,0,1,-1};

            queue.add(new int[]{0,0,1});
            visited[0][0] = true;


            while(!queue.isEmpty()){

                int[] pos = queue.poll();
                int nowX = pos[0];
                int nowY = pos[1];
                int moveCount = pos[2];

                if(nowX==n-1&&nowY==m-1){
                    answer = moveCount;
                    return;
                }

                for(int i=0; i<4; i++){
                    if(nowX+dx[i]>=0&&nowX+dx[i]<n&&nowY+dy[i]>=0&&nowY+dy[i]<m){
                        if(maps[nowX+dx[i]][nowY+dy[i]]==1&&!visited[nowX+dx[i]][nowY+dy[i]]){
                            visited[nowX+dx[i]][nowY+dy[i]] = true;
                            queue.add(new int[]{nowX+dx[i],nowY+dy[i],moveCount+1});
                        }
                    }
                }
            }
        }


    }
}
