package week3;

import java.io.*;

public class boj_9663 {

    static int N;
    static int[] board;
    static int count =0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new int[N];

        nQueen(0);

        System.out.println(count);
    }

    public static void nQueen(int queenPos){

        if(queenPos==N){        //끝까지 도달하면
            count++;
            return;
        }

        for(int i=0; i<N; i++){
            board[queenPos] = i;        //queenPos번째 행의 queen위치는 i(열)이다
            if(canPos(queenPos)){
                nQueen(queenPos+1);
            }
        }
    }

    public static boolean canPos(int queenPos){

        for(int i=0; i<queenPos; i++) {     //0번째 행부터 queenPos 전 행 까지 체크
            //행열 체크
            if (board[queenPos] == board[i]){   //queenPos번째 행의 queen위치와 그 전까지의 행의 queen의 위치가 일치할 때
                return false;       //못 놔둠
            }

            //대각선 체크
            if(queenPos - i == Math.abs(board[queenPos]-board[i])){
                return false;
            }
        }

        return true;
    }


}
