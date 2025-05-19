package week7;

import java.util.*;

public class pro_154540 {
    class Solution {
        static int[][] map;
        static boolean[][] visited;
        static int[] dx = {1,-1,0,0};
        static int[] dy = {0,0,1,-1};
        static int n,m;
        static int time;

        public int[] solution(String[] maps) {
            int[] answer;
            ArrayList<Integer> island = new ArrayList<>();


            n = maps.length;        //행
            m = maps[0].length();   //열

            map = new int[n][m];
            visited = new boolean[n][m];

            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    //이렇게 하면 대신 X = 40으로 체크 됨
                    map[i][j] = maps[i].charAt(j) -'0';
                }
            }


            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(map[i][j]!=40&&!visited[i][j]){
                        time = 0;
                        dfs(i,j);
                        island.add(time);
                    }
                }
            }

            Collections.sort(island);

            if(island.isEmpty()){
                island.add(-1);
            }

            answer = new int[island.size()];

            for(int k=0; k<island.size(); k++){
                answer[k] = island.get(k);
            }


            return answer;
        }

        public static void dfs(int i, int j){
            visited[i][j] = true;
            time+= map[i][j];
            for(int k=0; k<4; k++){
                if(i+dx[k]<n&&i+dx[k]>=0&&j+dy[k]<m&&j+dy[k]>=0){
                    if(map[i+dx[k]][j+dy[k]]!=40&&!visited[i+dx[k]][j+dy[k]]){
                        dfs(i+dx[k],j+dy[k]);
                    }
                }
            }

        }




    }
}
