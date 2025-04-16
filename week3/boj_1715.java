package week3;

import java.io.*;
import java.util.*;

public class boj_1715 {
    public static void main(String[] args) throws IOException {
        //항상 최소인 애들 둘을 더해야 함.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();     //오름 차순
        int compareCnt = 0;

        for(int i=0; i<N; i++){
            int numCard = Integer.parseInt(br.readLine());
            queue.add(numCard);
        }

        while(queue.size()!=1){
            int cardNum1 = queue.poll();
            int cardNum2 = queue.poll();

            int sumCardNum = cardNum1+cardNum2;
            compareCnt += sumCardNum;

            queue.add(sumCardNum);
        }

        System.out.println(compareCnt);

    }
}
