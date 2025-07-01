package week13;

import java.util.*;
public class pro_42587 {
	class Solution {
		public int solution(int[] priorities, int location) {
			int answer = 0;
			int count = 0;
			Queue<int[]> queue = new LinkedList<>();

			for(int i=0; i<priorities.length; i++){
				queue.add(new int[]{priorities[i],i});
			}

			while(!queue.isEmpty()){
				boolean excute = true;

				int[] item = queue.poll();
				int queueSize = queue.size();

				for(int[] que : queue){
					if(item[0]<que[0]){
						queue.add(item);
						excute = false;
						break;
					}
				}

				if(excute){
					count++;
					if(item[1]==location){
						answer = count;
						break;
					}
				}
			}

			return answer;
		}


	}
}
