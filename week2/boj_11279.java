package week2;

import java.io.*;
import java.util.*;

public class boj_11279 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        int N = Integer.parseInt(br.readLine());


        for(int i=0; i<N; i++){
            int number = Integer.parseInt(br.readLine());
            if(number==0){
                if(!queue.isEmpty()) {
                    int peekNum = queue.poll();
                    System.out.println(peekNum);
                }
                else {
                    System.out.println(0);
                }
            }
            else {
                queue.add(number);
            }
        }
    }
}
