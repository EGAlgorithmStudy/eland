package week7;

import java.util.*;

public class pro_152996 {
    class Solution {
        public long solution(int[] weights) {
            long answer = 0;

            //hashmap으로 했다가 정렬 순서 보장 안되서 key값으로 오름차순으로 정렬 보장하는 treemap사용
            Map<Integer,Integer> weight = new TreeMap<>();

            for (int i=0; i<weights.length; i++) {
                weight.put(weights[i],weight.getOrDefault(weights[i],0) + 1);
            }

            //키값 배열로 받아오기 (얘는 인터넷찾아서 함)
            Integer[] keys = weight.keySet().toArray(new Integer[0]);

            for (int i = 0; i < keys.length; i++) {
                int w1 = keys[i];
                long c1 = weight.get(w1);

                //키 값은 같고 사람수만 여려명일때
                if (c1 > 1) {
                    answer += (c1 * (c1 - 1)) / 2;
                }

                for (int j = i + 1; j < keys.length; j++) {
                    int w2 = keys[j];
                    long c2 = weight.get(w2);

                    //key값에 대한 비율 비교
                    if (w1 * 2 == w2 || w1 * 3 == w2 * 2 || w1 * 4 == w2 * 3) {
                        answer += c1 * c2;
                    }
                }
            }

            return answer;
        }
    }
}
