package week2;
import java.util.*;

public class pro_142085 {
    class Solution {
        public int solution(int n, int k, int[] enemy) {
            int answer = 0;
            int clearCnt = 0;

            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

            int enemys = 0;
            int enemyCnt = enemy.length;

            for (int i=0; i<enemyCnt; i++) {
                enemys += enemy[i];
                maxHeap.add(enemy[i]);

                if(enemys>n){
                    if(k>0){        //무적권이 있으면
                        enemys -= maxHeap.poll(); // 가장 큰 적의 수를 무적권으로 막음
                        k--;
                    }
                    else{           // 없으면
                        break;      //끝
                    }
                }
                clearCnt++;
            }
            answer = clearCnt;

            return answer;
        }
    }

}
