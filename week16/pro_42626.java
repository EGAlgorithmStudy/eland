package week16;
import java.util.*;

public class pro_42626 {
	class Solution {
		public int solution(int[] scoville, int K) {
			int answer = 0;

			PriorityQueue<Integer> pq = new PriorityQueue<>();

			for(int a:scoville){
				pq.add(a);
			}

			int check = pq.peek();

			while(check<K){
				if(pq.size()==1){
					answer = -1;
					break;
				}

				int firstFood = pq.poll();
				int secondFood = pq.poll();

				int newFood = firstFood + (secondFood*2);
				answer++;

				pq.add(newFood);

				check = pq.peek();
			}





			return answer;
		}
	}
}
