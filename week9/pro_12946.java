package week9;

public class pro_12946 {
    class Solution {

        static int[][] answer;
        static int index = 0;

        public int[][] solution(int n) {
            int moves = (int)Math.pow(2,n) -1;

            answer = new int[moves][2];
            move(n, 1, 2, 3);
            return answer;
        }

        public void move(int cnt, int start, int mid, int end) {
            if (cnt == 0) {
                return;
            }

            move(cnt - 1, start, end, mid); //n-1개를 1에서 2로

            answer[index][0] = start;       //남은 1개를 3으로 (제일 큰 판)

            answer[index][1] = end;

            index++;

            move(cnt - 1, mid, start, end);     //n-1개를 2에서 3으로
        }


    }
}
