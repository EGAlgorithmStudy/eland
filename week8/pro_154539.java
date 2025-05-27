package week8;

import java.util.*;

public class pro_154539 {
    class Solution {
        public int[] solution(int[] numbers) {

            int numLen = numbers.length;
            int[] answer = new int[numLen];

            Stack<int[]> stack = new Stack<>();

            for (int i=0; i<numLen; i++) {
                int currentNum = numbers[i];

                //지금 숫자가 스택에 들어있는거 보다 클 때(뒷 숫자가 더 클 때)
                while (!stack.isEmpty() && currentNum > stack.peek()[1]) {
                    int[] smallerNum = stack.pop();
                    answer[smallerNum[0]] = currentNum;
                }

                stack.push(new int[]{i, currentNum});
            }

            //스택에 남아있는 애들은 자기들보다 큰 애가 뒤에 없는거
            while (!stack.isEmpty()) {
                int[] remainNum = stack.pop();
                answer[remainNum[0]] = -1;
            }

            return answer;
        }
    }
}
