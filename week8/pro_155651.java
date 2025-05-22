package week8;

import java.util.*;

public class pro_155651 {
    class Solution {
        public int solution(String[][] book_time) {
            int roomCnt;
            int client = book_time.length;

            int[][] bookTime = new int[client][2];

            for(int i=0; i<client; i++){
                for(int j=0; j<2; j++){
                    String[] time = book_time[i][j].split(":");
                    int convertTime = Integer.parseInt(time[0])*60 + Integer.parseInt(time[1]);
                    if(j==1){
                        convertTime+=10;    //청소시간
                    }
                    bookTime[i][j] = convertTime;

                }
            }

            Arrays.sort(bookTime,(o1,o2)->{
                return o1[0]-o2[0];         //시작 시간 기준 오름 차순
            });


            PriorityQueue<Integer> book = new PriorityQueue<>();

            book.add(bookTime[0][1]);       //처음 객실 끝나는 시간
            roomCnt = 1;
            //roomCnt = 0 으로 처리하고 for문 안에서 구하려고 하면 bookTime.length = 1 일때 roomCnt = 0 으로 처리되서 오류 발생
            for(int i=1; i<client; i++){
                if(book.peek()<=bookTime[i][0]){
                    book.poll();
                }
                book.add(bookTime[i][1]);

                roomCnt = Math.max(roomCnt,book.size());
            }
            return roomCnt;
        }
    }
}
