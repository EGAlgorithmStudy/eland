package week10;

public class pro_12899 {
    class Solution {

        //1,2,4라고 생각하지말고 그냥 3진법이라고 생각하자.
        public String solution(int n) {
            //n<5000만 이니까 3^18까지
            //배열로 하니까 시초 남
            //int[] digits = new int[18];
            //int index = 17;
            StringBuilder sb = new StringBuilder();
            String answer;

            while (n > 0) {
                int remain = n % 3;
                if (remain == 0) {
                    sb.append("4");
                    // digits[index] = 4;
                    // index--;
                    n = n / 3 - 1;
                } else {
                    sb.append(remain);
                    // digits[index] = remain;
                    // index--;
                    n = n / 3;
                }
            }

            // String answer = "";
            // for (int i = index + 1; i < 18; i++) {
            //     answer += digits[i];
            // }

            answer = sb.reverse().toString();
            return answer;
        }
    }
}
