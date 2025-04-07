package week1;

public class pro_178870 {
    class Solution {
        public int[] solution(int[] sequence, int k) {
            //투포인터로 풀면 될 듯
            //k<=10억
            int[] answer = new int[2];
            int seqLen = sequence.length;
            int subSum = 0;
            int idxCnt = 0;
            int start=0;
            int minIdxCnt = 1000001;


            for(int end=0; end<seqLen; end++){
                subSum+=sequence[end];
                idxCnt++;
                while(subSum>k){
                    subSum -= sequence[start];
                    idxCnt--;
                    start++;
                }
                if(subSum==k&&idxCnt<minIdxCnt){
                    minIdxCnt = idxCnt;
                    answer[0] = start;
                    answer[1] = end;
                }
            }

            return answer;
        }
    }
}
