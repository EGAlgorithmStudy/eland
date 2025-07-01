package week13;

import java.util.*;

public class pro_42586 {
	class Solution {
		public List<Integer> solution(int[] progresses, int[] speeds) {
			List<Integer> dayList = new ArrayList<>();

			Queue<Integer> queue = new LinkedList<>();

			for (int i = 0; i < progresses.length; i++) {
				int remain_day = (int)Math.ceil((double)(100 - progresses[i]) / speeds[i]);
				queue.add(remain_day);
			}

			while (!queue.isEmpty()) {
				int nowDay = queue.poll();
				int completeTask = 1;

				while (!queue.isEmpty() && queue.peek() <= nowDay) {
					queue.poll();
					completeTask++;
				}

				dayList.add(completeTask);
			}

			return dayList;
		}
	}
}
