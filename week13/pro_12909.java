package week13;

import java.util.*;

public class pro_12909 {
	class Solution {
		boolean solution(String s) {
			boolean answer = true;
			int sLen = s.length();
			Queue<Character> queue = new LinkedList<>();

			if(s.charAt(0)==')'){
				return false;
			}

			for(int i=0; i<sLen; i++){
				if(s.charAt(i)=='('){
					queue.add(s.charAt(i));
				}
				else if(s.charAt(i)==')'){
					if(queue.isEmpty()){
						return false;
					}
					else{
						queue.poll();
					}
				}
			}

			if(queue.size()!=0){
				return false;
			}

			return answer;
		}
	}
}
