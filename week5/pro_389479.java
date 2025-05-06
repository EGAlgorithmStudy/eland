package week5;
import java.util.*;
public class pro_389479 {
    class Solution {
        public int solution(int[] players, int m, int k) {
            int answer = 0;
            int ableUser = m-1;
            int serverCnt = 0;

            Queue<int[]> end_time = new LinkedList<>();
            //queue안의 int[2]배열에 0번째에 시간, 1번째에 사람 수

            //24시간
            for (int i=0; i<24; i++) {

                while (!end_time.isEmpty()&&end_time.peek()[0]==i) {
                    int[] ended = end_time.poll();
                    ableUser -= ended[1];
                }

                while (players[i]>ableUser) {
                    ableUser += m;
                    serverCnt++;
                    end_time.add(new int[]{i+k, m});
                }
            }

            return serverCnt;
        }
    }
}
