package week14;

import java.util.*;

public class pro_43163 {
	//visit써서 같은 단어 안가도록 처리.
	//queue써야될 듯
	//word전체를 순회하면서 바꿀 수있으면 queue에 넣기.
	//변경로직.
	class Solution {

		static boolean isExist;
		static int answer;
		public int solution(String begin, String target, String[] words) {
			answer = 0;

			wordFind(begin, target, words);

			if(!isExist){
				answer = 0;
			}

			return answer;
		}

		public static void wordFind(String begin, String target, String[] words){
			Queue<wordChange> queue = new LinkedList<>();
			int wordCount = words.length;
			isExist = false;
			HashSet<String> visited = new HashSet<>();

			for(int i=0; i<wordCount; i++){
				if(words[i].equals(target)){
					isExist = true;
					break;
				}
			}

			queue.add(new wordChange(begin,0));
			visited.add(begin);

			while(!queue.isEmpty()){

				if(!isExist){
					break;
				}
				wordChange wc = queue.poll();

				if(wc.word.equals(target)){
					answer = wc.changeCnt;
					break;
				}


				int wordLen = wc.word.length();


				for(int i=0; i<wordCount; i++){
					int chk = 0;
					if(!visited.contains(words[i])){
						for(int j=0; j<wordLen; j++){
							if(words[i].charAt(j)!=wc.word.charAt(j)){
								chk++;
							}
						}
						if(chk==1){
							queue.add(new wordChange(words[i],wc.changeCnt+1));
							visited.add(words[i]);
						}
					}
				}
			}

		}

		static class wordChange{
			String word;
			int changeCnt;

			wordChange(String word, int changeCnt){
				this.word = word;
				this.changeCnt = changeCnt;
			}

		}
	}
}
