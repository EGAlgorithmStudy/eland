package week16;
import java.util.*;

public class pro_12981 {
	class Solution {
		public int[] solution(int n, String[] words) {
			int[] answer = new int[2];
			answer[0] = 0;
			answer[1] = 0;
			HashSet<String> set = new HashSet<>();

			set.add(words[0]);

			char finishWord = words[0].charAt(words[0].length()-1);

			for(int i=1; i<words.length; i++){
				char firstWord = words[i].charAt(0);
				if(firstWord!=finishWord||set.contains(words[i])){
					System.out.println(words[i]);
					answer[0] = i%n+1;
					answer[1] = i/n+1;
					break;
				}
				set.add(words[i]);
				finishWord = words[i].charAt(words[i].length()-1);
			}



			return answer;
		}
	}
}
