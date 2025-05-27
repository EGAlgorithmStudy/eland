package week8;

public class pro_42842 {
    class Solution {
        public int[] solution(int brown, int yellow) {
            int[] answer = new int[2];

            //a = answer[0] (가로)
            //b = answer[1] (세로)
            //ab = sum;
            //brown = sum - yellow
            //yellow = (a-2)*(b-2)
            //brown = ab - (a-2)*(b-2)
            //brown = 2a+2b+4
            //a+b = 1/2 * brown +2
            //(a-b)^2 = (a+b)^2 - 4ab
            //a = {(a+b) + (a-b)} / 2

            int sumAB = brown/2 + 2;
            int subAB = (int) Math.sqrt(Math.pow(sumAB,2)- (4*(brown+yellow)));
            int a = (sumAB+subAB)/2;
            int b = sumAB - a;

            answer[0] = a;
            answer[1] = b;


            return answer;
        }
    }
}
