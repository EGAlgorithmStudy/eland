package week6;

public class pro_181187 {

    class Solution {
        public long solution(int r1, int r2) {
            long answer = 0;

            long piece = 0;

            for (int x = 1; x <= r2; x++) {

                //내접원 보다 밖에 있어야 하니까 올림
                int start = (int) Math.ceil(Math.sqrt((long) r1 * r1 - (long) x * x));

                //외접원 보다 안에 있어야 하니까 내림
                int end = (int) Math.floor(Math.sqrt((long) r2 * r2 - (long) x * x));

                piece += end - start + 1;
            }

            answer = piece*4;

            return answer;
        }
    }
}
