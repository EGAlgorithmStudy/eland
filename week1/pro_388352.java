package week1;

import java.util.HashSet;

public class pro_388352 {

    class Solution {
        int answer;

        public int solution(int n, int[][] q, int[] ans) {
            answer = 0;
            boolean[] visit = new boolean[n + 1];
            int[] code = new int[5];

            backtracking(n, visit, code, 0, 1, q, ans);

            return answer;
        }

        public void backtracking(int n, boolean[] visit, int[] code, int index, int number, int[][] q, int[] ans) {

            if (index == 5) {       //5개 뽑아서 넣었으면 검사
                check(code, q, ans);
                return;
            }


            for (int i = number; i <= n; i++) {
                if (!visit[i]) {
                    visit[i] = true;
                    code[index] = i;
                    backtracking(n, visit, code, index + 1, i + 1, q, ans);
                    visit[i] = false;
                }
            }
        }

        public void check(int[] code, int[][] q, int[] ans) {
            HashSet<Integer> codes = new HashSet<>();
            int codeCnt = 0;

            for (int i = 0; i < code.length; i++) {
                codes.add(code[i]);
            }

            for (int i = 0; i < q.length; i++) {

                int chk = 0;
                for (int j = 0; j < q[0].length; j++) {
                    if (codes.contains(q[i][j])) {
                        chk++;
                    }
                }
                if (chk == ans[i]) {
                    codeCnt++;
                }


            }
            if (codeCnt == q.length) {
                answer++;
            }

        }


    }
}
