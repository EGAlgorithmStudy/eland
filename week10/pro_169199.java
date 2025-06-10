package week10;

import java.util.*;

public class pro_169199 {
    class Solution {

        //G의 상하좌우에 벽 or 끝이 아니라면 멈출 수 없음
        //bfs써서 벽이나 끝에 닿을때 까지 이동시키기
        //visit은 장애물 구간 빼면 될 듯?
        static int answer = -1;
        static int n,m;
        public int solution(String[] board) {

            n = board.length;
            m = board[0].length();
            int[] start = new int[2];
            int[] end = new int[2];

            char[][] gameBoard = new char[n][m];

            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    gameBoard[i][j] = board[i].charAt(j);
                    if(gameBoard[i][j]=='R'){
                        start[0] = i;
                        start[1] = j;
                    }
                    if(gameBoard[i][j]=='G'){
                        end[0] = i;
                        end[1] = j;
                    }
                }
            }

            game(gameBoard,start,end);

            return answer;
        }

        public static void game(char[][] gameBoard,int[] start,int[] end){
            Queue<int[]>queue = new LinkedList<>();
            boolean[][] visited = new boolean[n][m];
            int[] dx = {1,-1,0,0};
            int[] dy = {0,0,1,-1};

            queue.add(new int[]{start[0],start[1],0});
            visited[start[0]][start[1]]=true;

            while(!queue.isEmpty()){
                int[] nowPos = queue.poll();
                int nowX = nowPos[0];
                int nowY = nowPos[1];
                int moveCount = nowPos[2];

                if(nowX==end[0]&&nowY==end[1]){
                    answer = moveCount;
                    break;
                }

                for(int i=0; i<4;i++){
                    int newX = nowX;
                    int newY = nowY;
                    while(
                            newX + dx[i] >= 0 && newX + dx[i] < n &&
                                    newY + dy[i] >= 0 && newY + dy[i] < m &&
                                    gameBoard[newX + dx[i]][newY + dy[i]] != 'D'){
                        newX += dx[i];
                        newY += dy[i];
                    }

                    if(!visited[newX][newY]){
                        visited[newX][newY] = true;
                        queue.add(new int[]{newX,newY,moveCount+1});
                    }
                }
            }
        }
    }
}
