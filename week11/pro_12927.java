package week11;

import java.util.*;

public class pro_12927 {
    //가장 큰값 ,인덱스를 가지고 있어서 n을 감소시키면서 빼다가 가장큰 값이 아니게 되면 교체
//priorityQueue 쓰면 될거 같기도? 배열의 인덱스랑 works값을 인자로 가지는 큐에서 works           값을 기준으로 큰거부터 빼서 처리하고 다시 넣는 방식으로
//사실 인덱스도 필요없음. 그냥 값만 넣고 후에 제곱해서 처리하자
    class Solution {
        public long solution(int n, int[] works) {
            long answer = 0;
            int workCnt = works.length;
            int workSum = 0;

            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

            for(int i=0; i<workCnt; i++){
                pq.add(works[i]);
                workSum += works[i];
            }

            if(workSum<=n){
                return 0;
            }

            for(int i=0; i<n; i++){
                int work = pq.poll();
                work--;
                if(work!=0){
                    pq.add(work);
                }
            }

            int pqSize = pq.size();
            for(int i=0; i<pqSize; i++){
                answer += Math.pow(pq.poll(),2);
            }





            return answer;
        }
    }
}
