package week4;
import java.util.*;

public class pro_42628 {
    class Solution {
        public int[] solution(String[] operations) {
            int[] answer = new int[2];

            PriorityQueue<Integer> queue = new PriorityQueue<>();       //오름차순

            PriorityQueue<Integer> queue_reverse = new PriorityQueue<>(Collections.reverseOrder());     //내림차순

            for(int i=0; i<operations.length; i++){
                String[] temp = new String[2];

                temp = operations[i].split(" ");
                if(temp[0].equals("I")){
                    queue.add(Integer.parseInt(temp[1]));
                    queue_reverse.add(Integer.parseInt(temp[1]));
                }
                else if(temp[0].equals("D")){
                    if(!queue.isEmpty()){
                        if(temp[1].equals("1")){
                            int check = queue_reverse.poll();
                            queue.remove(check);
                        }
                        else{           //D -1
                            int check = queue.poll();
                            queue_reverse.remove(check);
                        }
                    }
                }
            }

            if(queue.isEmpty()){
                answer[0] = 0;
                answer[1] = 0;
            }
            else{
                answer[0] = queue_reverse.poll();
                answer[1] = queue.poll();
            }

            return answer;
        }
    }
}
