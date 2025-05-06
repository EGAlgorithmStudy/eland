package week5;

public class pro_60057 {
    class Solution {
        public int solution(String s) {
            int minLen = s.length();

            for (int i=1; i<=s.length()/2; i++) {
                StringBuilder sb = new StringBuilder();

                //0부터 i까지 잘라냄
                String check = s.substring(0, i);

                int count = 1;

                //i부터 i씩만큼 건너뛰며 체크
                for (int j = i; j <= s.length(); j += i) {

                    String current;

                    //체크 하는 부분이 문자열 안넘어갈때
                    if (j+i <= s.length()) {
                        current = s.substring(j,j+i);
                    } else {
                        current = s.substring(j);
                    }

                    //잘라낸거랑 같으면
                    if (current.equals(check)) {
                        count++;
                    }
                    else {
                        if (count>1){
                            sb.append(count);
                        }
                        sb.append(check);
                        check = current;
                        count = 1;
                    }
                }

                if (count > 1) {
                    sb.append(count);
                }
                sb.append(check);

                minLen = Math.min(minLen, sb.length());
            }

            return minLen;
        }
    }
}
