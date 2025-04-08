package week1;

public class pro_340212 {
    class Solution {
        public int solution(int[] diffs, int[] times, long limit) {
            long answer = 0;
            long left =1; //최저 시간
            long right = limit; //최대 시간

            while(left<right){
                long mid = (left+right) /2;     //level
                if(canSolve(diffs,times,mid,limit)){
                    left = mid+1;
                }
                else{
                    right = mid;
                }
            }
            answer = left;

            return (int)answer;
        }

        public boolean canSolve(int[] diffs, int[] times, long level, long limit){
            long t = (long)times[0];

            for(int i =1; i<times.length; i++){
                if(diffs[i] > level){
                    t += ((long)diffs[i] - level) * ((long)times[i-1] + (long)times[i]);
                }
                t += (long)times[i];
            }

            return limit < t;
        }
    }
}
