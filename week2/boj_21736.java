package week2;

import java.util.*;

public class boj_21736 {
    static int N;
    static int M;
    static String[][] campus;
    static boolean[][] visit;
    static int meet = 0;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        campus = new String[N][M];
        visit = new boolean[N][M];

        int x=0;
        int y=0;
        //campus[i] 를 한줄씩 받아서
        //campus[i].indexof(j) 이런 식으로 써도 됨.

        for(int i=0; i<N; i++){
            String[] mElements = sc.next().split("");
            for(int j=0; j<M; j++){
                campus[i][j] = mElements[j];
                if(mElements[j].equals("I")){       //여기서 mElement[j]로 해야되는데 안해서 x,y갱신안됨 -> 0,0 시작이 아니면 에러
                    x=i;
                    y=j;
                }
            }
        }

        dfs(x,y);

        if(meet==0) {
            System.out.println("TT");
            return;
        }
        System.out.println(meet);

    }
    public static void dfs(int x,int y){

        visit[x][y] = true;

        if (campus[x][y].equals("P")) {
            meet++;
        }

        if (x + 1 < N && !visit[x + 1][y] && !campus[x + 1][y].equals("X")) {
            dfs(x + 1, y);
        }
        if (x - 1 >= 0 && !visit[x - 1][y] && !campus[x - 1][y].equals("X")) {
            dfs(x - 1, y);
        }
        if (y + 1 < M && !visit[x][y + 1] && !campus[x][y + 1].equals("X")) {
            dfs(x, y + 1);
        }
        if (y - 1 >= 0 && !visit[x][y - 1] && !campus[x][y - 1].equals("X")) {
            dfs(x, y - 1);
        }

//          dx랑 dy 기존에 static으로 {1,-1,0,0} 이런식으로 넣어놓고 이렇게 하는게 더깔끔하긴 함
//        for (int d = 0; d < 4; d++) {
//            int nx = x + dx[d];
//            int ny = y + dy[d];
//
//            if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
//                if (!visit[nx][ny] && !campus[nx][ny].equals("X")) {
//                    dfs(nx, ny);
//                }
//            }
//        }

    }

}
