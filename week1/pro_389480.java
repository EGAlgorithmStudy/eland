package week1;

import java.util.*;

public class pro_389480 {



    class Solution {
        public int solution(int[][] info, int n, int m) {
            int answer = 0;
            int len  = info.length;
            int Aevi = 0;
            int Bevi = 0;
            int check = 0;


            Arrays.sort(info, (a, b) -> {
                if(a[1]*b[0]== b[1]*a[0]){
                    return b[1]-a[1];
                }
                return a[1]*b[0] - b[1]*a[0];
            });


            for(int i=0; i<len; i++){
                if(m>Bevi+info[i][1]){
                    Bevi += info[i][1];
                    check++;
                }
                else if (n>Aevi+info[i][0]){
                    Aevi += info[i][0];
                    check++;
                }
            }

            answer = Aevi;

            if(check!=len){
                answer = -1;
            }
            return answer;
        }
    }
}
